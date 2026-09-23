package version4;


public class HourlyEmployee extends Employee {
    private int empID;
    private Name empName;
    private float totalHoursWorked;
    private double ratePerHour;
    private MyDate birthDate;
    private MyDate hireDate;

    public static final double BIRTHDAY_BONUS = 5000.0;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
        this.birthDate = new MyDate();
        this.hireDate = new MyDate();
    }

    public HourlyEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
        this.birthDate = new MyDate();
        this.hireDate = new MyDate();
    }

    public HourlyEmployee(int empID, Name empName, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
        this.birthDate = new MyDate();
        this.hireDate = new MyDate();
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(MyDate hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isBirthdayMonth() {
        return birthDate.isSameMonth(MyDate.today());
    }

    public double computeSalary() {
        double salary;
        if (totalHoursWorked <= 40) {
            salary = totalHoursWorked * ratePerHour;
        } else {
            double regularPay = 40 * ratePerHour;
            double overtimePay = (totalHoursWorked - 40) * (ratePerHour * 1.5);
            salary = regularPay + overtimePay;
        }
        if (isBirthdayMonth()) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    // Overload used by EmployeeRoster.displayPayroll(int) so the birthday-bonus
    // check is made against the simulated payroll month instead of the real clock.
    public double computeSalary(int month) {
        double salary;
        if (totalHoursWorked <= 40) {
            salary = totalHoursWorked * ratePerHour;
        } else {
            double regularPay = 40 * ratePerHour;
            double overtimePay = (totalHoursWorked - 40) * (ratePerHour * 1.5);
            salary = regularPay + overtimePay;
        }
        if (birthDate.getMonth() == month) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | Hours: %.2f | Rate: ₱%.2f/hr\n", empID, empName, totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        String bonusNote = isBirthdayMonth() ? " (+₱5,000 birthday bonus)" : "";
        return String.format("HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: ₱%.2f, Total Salary: ₱%,.2f%s]",
                empID, empName, totalHoursWorked, ratePerHour, computeSalary(), bonusNote);
    }
}