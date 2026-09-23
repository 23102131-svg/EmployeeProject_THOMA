package version5;

import java.util.ArrayList;
import java.util.List;

/**
 * Dynamic, collection-backed container for a polymorphic group of Employee
 * subtypes. Because Employee now provides its own getEmpID()/getEmpName()/
 * computeSalary(int), every method here that touches employee data works
 * through plain Employee references and pure dynamic method dispatch --
 * no instanceof and no downcasting, except in the four count*() methods,
 * which the spec explicitly keeps as instanceof-based administrative
 * breakdowns.
 */
public class EmployeeRoster {

    private List<Employee> empList;

    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        this.empList = new ArrayList<>(initialCapacity);
    }

    // ---------- Collection operations ----------

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            return false;
        }
        empList.add(emp);
        return true;
    }

    public Employee removeEmployee(int empID) {
        int idx = indexOfID(empID);
        if (idx == -1) {
            return null;
        }
        return empList.remove(idx);
    }

    public Employee searchEmployee(int empID) {
        for (Employee emp : empList) {
            if (emp.getEmpID() == empID) {
                return emp;
            }
        }
        return null;
    }

    public int countEmployees() {
        return empList.size();
    }

    private int indexOfID(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) {
                return i;
            }
        }
        return -1;
    }

    // ---------- Polymorphic reporting (pure dynamic dispatch) ----------

    public void displayPayroll(int currentMonth) {
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);
            System.out.printf("ID: %d | Name: %s | Pay: \u20b1%,.2f%n",
                    emp.getEmpID(), emp.getEmpName(), salary);
        }
    }

    public void displayAllEmployees() {
        for (Employee emp : empList) {
            System.out.println(emp);
        }
    }

    // ---------- Administrative breakdown (instanceof allowed here) ----------

    public int countHE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof HourlyEmployee) {
                c++;
            }
        }
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof PieceWorkerEmployee) {
                c++;
            }
        }
        return c;
    }

    public int countCE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof CommissionEmployee && !(emp instanceof BasePlusCommissionEmployee)) {
                c++;
            }
        }
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof BasePlusCommissionEmployee) {
                c++;
            }
        }
        return c;
    }
}