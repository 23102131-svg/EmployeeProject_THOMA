package version5;

public class Main {

    public static void main(String[] args) {

        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");


        EmployeeRoster roster = new EmployeeRoster();

        HourlyEmployee alice = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), 45f, 300.0);
        alice.setBirthDate(new MyDate(15, 9, 1995)); // September birthday

        PieceWorkerEmployee bob = new PieceWorkerEmployee(201, new Name("Bob", "C.", "Jones Jr."), 135, 30.0);
        bob.setBirthDate(new MyDate(5, 6, 1998));

        CommissionEmployee maria = new CommissionEmployee(301, new Name("Maria", "L.", "Reyes"), 100000.0);
        maria.setBirthDate(new MyDate(3, 9, 1990)); // September birthday

        BasePlusCommissionEmployee kevin = new BasePlusCommissionEmployee(401, new Name("Kevin", "S.", "Tan"), 100000.0, 15000.0);
        kevin.setBirthDate(new MyDate(10, 3, 1992));

        HourlyEmployee david = new HourlyEmployee(102, new Name("David", "A.", "White"), 40f, 200.0);
        david.setBirthDate(new MyDate(1, 12, 1988));

        PieceWorkerEmployee grace = new PieceWorkerEmployee(202, new Name("Grace", "T.", "Lim"), 80, 25.0);
        grace.setBirthDate(new MyDate(20, 1, 2000));

        enroll(roster, alice, "Smith, Alice M.", "Hourly");
        enroll(roster, bob, "Jones Jr., Bob C.", "Piece Worker");
        enroll(roster, maria, "Reyes, Maria L.", "Commission");
        enroll(roster, kevin, "Tan, Kevin S.", "Base Plus Commission");
        enroll(roster, david, "White, David A.", "Hourly");
        enroll(roster, grace, "Lim, Grace T.", "Piece Worker");

        System.out.println();
        System.out.println("--- ROSTER COMPOSITION COUNTS ---");
        System.out.println("Total Employees: " + roster.countEmployees());
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());


        System.out.println();
        System.out.println("======================================================================");
        System.out.println("DYNAMIC POLYMORPHISM: PAYROLL VIA emp.computeSalary(currentMonth)");
        System.out.println("======================================================================");
        roster.displayPayroll(9);

  
        System.out.println();
        System.out.println("======================================================================");
        System.out.println("COLLECTION REMOVAL VERIFICATION");
        System.out.println("======================================================================");
        int before = roster.countEmployees();
        Employee removed = roster.removeEmployee(201);
        System.out.println("Removing Employee ID 201 (Jones Jr., Bob C.)... "
                + (removed != null ? "Successfully removed." : "Not found."));
        System.out.println("Size before: " + before + " -> Size after: " + roster.countEmployees());

        System.out.println();
        System.out.println("Remaining Employees in Roster:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }

    private static void enroll(EmployeeRoster roster, Employee emp, String displayName, String type) {
        boolean ok = roster.addEmployee(emp);
        System.out.println((ok ? "Enrolled: " : "Failed to enroll: ") + displayName + " (" + type + ")");
    }
}