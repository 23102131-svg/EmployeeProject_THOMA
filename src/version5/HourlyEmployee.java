package version5;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    public static final double BIRTHDAY_BONUS = 5000.0;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName) {
        super(empID, empName);
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName, float totalHoursWorked, double ratePerHour) {
        super(empID, empName);
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
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

    private double basePay() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }
        double regularPay = 40 * ratePerHour;
        double overtimePay = (totalHoursWorked - 40) * (ratePerHour * 1.5);
        return regularPay + overtimePay;
    }

    // Real-time version, used by toString()/display for "salary right now".
    @Override
    public double computeSalary() {
        double salary = basePay();
        if (isBirthdayMonth()) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    // Dynamic-dispatch payroll version: EmployeeRoster calls this directly
    // through an Employee reference, no instanceof/casting required.
    @Override
    public double computeSalary(int currentMonth) {
        double salary = basePay();
        if (getBirthDate().getMonth() == currentMonth) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | Hours: %.2f | Rate: \u20b1%.2f/hr\n",
                getEmpID(), getEmpName(), totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        String bonusNote = isBirthdayMonth() ? " (+\u20b15,000 birthday bonus)" : "";
        return String.format("HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: \u20b1%.2f, Total Salary: \u20b1%,.2f%s]",
                getEmpID(), getEmpName(), totalHoursWorked, ratePerHour, computeSalary(), bonusNote);
    }
}