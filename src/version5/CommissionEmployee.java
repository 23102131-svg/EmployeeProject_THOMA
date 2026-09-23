package version5;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public static final double BIRTHDAY_BONUS = 5000.0;

    public CommissionEmployee() {
        super();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName) {
        super(empID, empName);
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName, double totalSale) {
        super(empID, empName);
        this.totalSale = totalSale;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    @Override
    public double computeSalary() {
        double salary = totalSale * getCommissionRate();
        if (isBirthdayMonth()) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary = totalSale * getCommissionRate();
        if (getBirthDate().getMonth() == currentMonth) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sales: \u20b1%,.2f\n", getEmpID(), getEmpName(), totalSale);
    }

    @Override
    public String toString() {
        String bonusNote = isBirthdayMonth() ? " (+\u20b15,000 birthday bonus)" : "";
        return String.format("CommissionEmployee [ID: %d, Name: %s, Sales: \u20b1%,.2f, Rate: %.0f%%, Total Salary: \u20b1%,.2f%s]",
                getEmpID(), getEmpName(), totalSale, getCommissionRate() * 100, computeSalary(), bonusNote);
    }
}