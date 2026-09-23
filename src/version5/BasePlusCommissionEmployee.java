package version5;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public static final double BIRTHDAY_BONUS = 5000.0;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName) {
        super(empID, empName);
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, double totalSale, double baseSalary) {
        super(empID, empName, totalSale);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary() {
        double salary = baseSalary + (getTotalSale() * getCommissionRate());
        if (isBirthdayMonth()) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary = baseSalary + (getTotalSale() * getCommissionRate());
        if (getBirthDate().getMonth() == currentMonth) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sales: \u20b1%,.2f | Base Salary: \u20b1%,.2f\n",
                getEmpID(), getEmpName(), getTotalSale(), baseSalary);
    }

    @Override
    public String toString() {
        String bonusNote = isBirthdayMonth() ? " (+\u20b15,000 birthday bonus)" : "";
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Sales: \u20b1%,.2f, Base Salary: \u20b1%,.2f, Rate Applied: %.0f%%, Total Salary: \u20b1%,.2f%s]",
                getEmpID(), getEmpName(), getTotalSale(), baseSalary, getCommissionRate() * 100, computeSalary(), bonusNote);
    }
}