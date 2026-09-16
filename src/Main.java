/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package version3;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {

        int currentMonth = MyDate.today().getMonth();

        HourlyEmployee h1 = new HourlyEmployee();
        h1.setEmpID(101);
        h1.setEmpName(new Name("Alice", "Smith"));
        h1.setTotalHoursWorked(45.0f);
        h1.setRatePerHour(200.0);
        h1.setBirthDate(new MyDate(12, currentMonth, 1995));

        HourlyEmployee h2 = new HourlyEmployee(102, new Name("John", "Doe"), 38.0f, 250.0);
        h2.setBirthDate(new MyDate(3, 6, 1990));

        System.out.println("--- Hourly Employee Test ---");
        System.out.print("[displayHourlyEmployee()] ");
        h1.displayHourlyEmployee();
        System.out.println("[toString()] " + h1);
        System.out.print("[displayHourlyEmployee()] ");
        h2.displayHourlyEmployee();
        System.out.println("[toString()] " + h2);

        PieceWorkerEmployee p1 = new PieceWorkerEmployee(201, new Name("Bob", "Jones"));
        p1.setTotalPiecesFinished(250);
        p1.setRatePerPiece(15.0);
        p1.setBirthDate(new MyDate(20, currentMonth, 1988));

        PieceWorkerEmployee p2 = new PieceWorkerEmployee(202, new Name("Emma", "Watson"), 120, 20.0);

        System.out.println("\n--- Piece Worker Employee Test ---");
        System.out.print("[displayPieceWorkerEmployee()] ");
        p1.displayPieceWorkerEmployee();
        System.out.println("[toString()] " + p1);
        System.out.print("[displayPieceWorkerEmployee()] ");
        p2.displayPieceWorkerEmployee();
        System.out.println("[toString()] " + p2);

        CommissionEmployee c1 = new CommissionEmployee();
        c1.setEmpID(301);
        c1.setEmpName(new Name("Charlie", "Brown"));
        c1.setTotalSale(75000.0);

        CommissionEmployee c2 = new CommissionEmployee(302, new Name("Diana", "Prince"), 520000.0);
        c2.setBirthDate(new MyDate(5, currentMonth, 1992));

        System.out.println("\n--- Commission Employee Test ---");
        System.out.print("[displayCommissionEmployee()] ");
        c1.displayCommissionEmployee();
        System.out.println("[toString()] " + c1);
        System.out.print("[displayCommissionEmployee()] ");
        c2.displayCommissionEmployee();
        System.out.println("[toString()] " + c2);

        BasePlusCommissionEmployee b1 = new BasePlusCommissionEmployee(401, new Name("Ethan", "Hunt"));
        b1.setTotalSale(120000.0);
        b1.setBaseSalary(15000.0);

        BasePlusCommissionEmployee b2 = new BasePlusCommissionEmployee(402, new Name("Fiona", "Gallagher"), 30000.0, 10000.0);
        b2.setBirthDate(new MyDate(28, currentMonth, 1985));

        System.out.println("\n--- Base Plus Commission Employee Test ---");
        System.out.print("[displayBasePlusCommissionEmployee()] ");
        b1.displayBasePlusCommissionEmployee();
        System.out.println("[toString()] " + b1);
        System.out.print("[displayBasePlusCommissionEmployee()] ");
        b2.displayBasePlusCommissionEmployee();
        System.out.println("[toString()] " + b2);

        MyDate today = MyDate.today();
        System.out.println("\nToday's date: " + today);
    }
}