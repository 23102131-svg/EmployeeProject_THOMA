/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version3;

/**
 *
 * @author User
 */
public class CommissionEmployee {

    private int empID;
    private Name empName;
    private double totalSale;
    private MyDate birthDate;

    public static final double BIRTHDAY_BONUS = 5000.0;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.totalSale = 0.0;
        this.birthDate = new MyDate();
    }

    public CommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
        this.birthDate = new MyDate();
    }

    public CommissionEmployee(int empID, Name empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
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
        double salary = totalSale * getCommissionRate();
        if (isBirthdayMonth()) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sales: ₱%,.2f\n", empID, empName, totalSale);
    }

    @Override
    public String toString() {
        String bonusNote = isBirthdayMonth() ? " (+₱5,000 birthday bonus)" : "";
        return String.format("CommissionEmployee [ID: %d, Name: %s, Sales: ₱%,.2f, Rate: %.0f%%, Total Salary: ₱%,.2f%s]",
                empID, empName, totalSale, getCommissionRate() * 100, computeSalary(), bonusNote);
    }
}