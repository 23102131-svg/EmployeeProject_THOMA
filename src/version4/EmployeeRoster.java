
package version4;

/**
 * Fixed-size, array-backed container for a polymorphic group of Employee
 * subtypes. Employee itself is concrete but declares no computeSalary()
 * method, so every operation that needs subtype-specific behavior (payroll,
 * category counts, specialized display) must use instanceof introspection
 * and downcast to the correct subclass before calling its methods.
 */
public class EmployeeRoster {

    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this.max = 10;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        this.max = max;
        this.empList = new Employee[this.max];
        this.count = 0;
    }



    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }
        empList[count] = emp;
        count++;
        return true;
    }

    public Employee removeEmployee(int empID) {
        int idx = indexOfID(empID);
        if (idx == -1) {
            return null;
        }
        Employee removed = empList[idx];

        for (int i = idx; i < count - 1; i++) {
            empList[i] = empList[i + 1];
        }
        empList[count - 1] = null;
        count--;
        return removed;
    }

    public Employee searchEmployee(int empID) {
        int idx = indexOfID(empID);
        return (idx == -1) ? null : empList[idx];
    }

    // ---------- Introspection helpers (downcast to read subtype-only fields) ----------

    private int getID(Employee emp) {
        if (emp instanceof BasePlusCommissionEmployee) {
            return ((BasePlusCommissionEmployee) emp).getEmpID();
        } else if (emp instanceof CommissionEmployee) {
            return ((CommissionEmployee) emp).getEmpID();
        } else if (emp instanceof HourlyEmployee) {
            return ((HourlyEmployee) emp).getEmpID();
        } else if (emp instanceof PieceWorkerEmployee) {
            return ((PieceWorkerEmployee) emp).getEmpID();
        }
        return -1;
    }

    private Name getName(Employee emp) {
        if (emp instanceof BasePlusCommissionEmployee) {
            return ((BasePlusCommissionEmployee) emp).getEmpName();
        } else if (emp instanceof CommissionEmployee) {
            return ((CommissionEmployee) emp).getEmpName();
        } else if (emp instanceof HourlyEmployee) {
            return ((HourlyEmployee) emp).getEmpName();
        } else if (emp instanceof PieceWorkerEmployee) {
            return ((PieceWorkerEmployee) emp).getEmpName();
        }
        return new Name();
    }

    private int indexOfID(int empID) {
        for (int i = 0; i < count; i++) {
            if (getID(empList[i]) == empID) {
                return i;
            }
        }
        return -1;
    }

    // ---------- Polymorphic category counts ----------
    // Note: BasePlusCommissionEmployee IS-A CommissionEmployee, so countCE()
    // must exclude BasePlusCommissionEmployee instances to stay "pure".

    public int countHE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                c++;
            }
        }
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                c++;
            }
        }
        return c;
    }

    public int countCE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)) {
                c++;
            }
        }
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                c++;
            }
        }
        return c;
    }

    // ---------- Categorical display (filter, downcast, display) ----------

    public void displayHE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                ((HourlyEmployee) empList[i]).displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                ((PieceWorkerEmployee) empList[i]).displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)) {
                ((CommissionEmployee) empList[i]).displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                ((BasePlusCommissionEmployee) empList[i]).displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        System.out.printf("%-4s %-25s %-30s%n", "ID", "Name", "Type");
        for (int i = 0; i < count; i++) {
            Employee emp = empList[i];
            System.out.printf("%-4d %-25s %-30s%n", getID(emp), getName(emp), emp.getClass().getSimpleName());
        }
    }

    // ---------- Polymorphic downcast payroll ----------

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee emp = empList[i];
            if (emp instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee e = (BasePlusCommissionEmployee) emp;
                printPayrollLine("Base Plus Commission", e.getEmpID(), e.getEmpName(),
                        e.computeSalary(currentMonth), e.getBirthDate().getMonth() == currentMonth);
            } else if (emp instanceof CommissionEmployee) {
                CommissionEmployee e = (CommissionEmployee) emp;
                printPayrollLine("Commission", e.getEmpID(), e.getEmpName(),
                        e.computeSalary(currentMonth), e.getBirthDate().getMonth() == currentMonth);
            } else if (emp instanceof HourlyEmployee) {
                HourlyEmployee e = (HourlyEmployee) emp;
                printPayrollLine("Hourly", e.getEmpID(), e.getEmpName(),
                        e.computeSalary(currentMonth), e.getBirthDate().getMonth() == currentMonth);
            } else if (emp instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee e = (PieceWorkerEmployee) emp;
                printPayrollLine("Piece Worker", e.getEmpID(), e.getEmpName(),
                        e.computeSalary(currentMonth), e.getBirthDate().getMonth() == currentMonth);
            }
        }
    }

    private void printPayrollLine(String type, int id, Name name, double salary, boolean bonus) {
        System.out.printf("[%s] ID: %d | Name: %s | Salary: \u20b1%,.2f%s%n",
                type, id, name, salary, bonus ? " (Birthday Bonus Applied)" : "");
    }

    // ---------- Simple accessors ----------

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }
}


