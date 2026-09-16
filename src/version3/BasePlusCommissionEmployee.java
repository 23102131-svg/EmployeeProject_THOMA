/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version3;

/**
 *
 * @author User
 */
public class BasePlusCommissionEmployee {

    private int empID;
    private Name empName;
    private double totalSale;
    private double baseSalary;
    private MyDate birthDate;

    public static final double BIRTHDAY_BONUS = 5000.0;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
        this.birthDate = new MyDate();
    }

    public BasePlusCommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
        this.birthDate = new MyDate();
    }

    public BasePlusCommissionEmployee(int empID, Name empName, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
        this.birthDate = new MyDate();
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

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBirthdayMonth() {
        return birthDate.isSameMonth(MyDate.today());
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

    public double computeSalary() {
        double salary = baseSalary + (totalSale * getCommissionRate());
        if (isBirthdayMonth()) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sales: ₱%,.2f | Base Salary: ₱%,.2f\n", empID, empName, totalSale, baseSalary);
    }

    @Override
    public String toString() {
        String bonusNote = isBirthdayMonth() ? " (+₱5,000 birthday bonus)" : "";
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Sales: ₱%,.2f, Base Salary: ₱%,.2f, Rate Applied: %.0f%%, Total Salary: ₱%,.2f%s]",
                empID, empName, totalSale, baseSalary, getCommissionRate() * 100, computeSalary(), bonusNote);
    }
}