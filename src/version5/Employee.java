package version5;

/**
 * Concrete base class for the whole employee hierarchy.
 *
 * Unlike Version 4, empID/empName/birthDate/hireDate now live ONLY here
 * (subclasses no longer redeclare them), and Employee itself provides a
 * baseline computeSalary(int)/computeSalary() contract. That's what lets
 * EmployeeRoster call emp.getEmpID(), emp.getEmpName(), and
 * emp.computeSalary(currentMonth) directly on an Employee reference and
 * have the JVM dispatch to the correct subclass override at runtime --
 * no instanceof, no casting.
 */
public class Employee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate hireDate;

    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.hireDate = new MyDate();
    }

    public Employee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
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

    // Baseline implementation: a plain Employee earns nothing. Every
    // concrete subclass overrides this with its real earning logic.
    public double computeSalary(int currentMonth) {
        return 0.0;
    }

    // No target month supplied -> delegate with a month that never
    // matches a real birth month, so the birthday bonus branch in every
    // override naturally stays off unless a subclass wants otherwise.
    public double computeSalary() {
        return computeSalary(-1);
    }

    @Override
    public String toString() {
        return String.format("Employee [ID: %d, Name: %s]", empID, empName);
    }
}