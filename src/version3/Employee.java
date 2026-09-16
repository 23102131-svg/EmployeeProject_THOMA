package version3;

public class Employee {
    private int EmpID;
    private Name empName;
    private MyDate birthDate;
    private MyDate hireDate;

    public Employee(){
        this.EmpID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.hireDate = new MyDate();
    }


}
