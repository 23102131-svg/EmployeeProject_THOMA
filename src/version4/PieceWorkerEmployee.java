/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version4;

/**
 *
 * @author User
 */
public class PieceWorkerEmployee extends Employee {

    private int empID;
    private Name empName;
    private float totalPiecesFinished;
    private double ratePerPiece;
    private MyDate birthDate;

    public static final double BIRTHDAY_BONUS = 5000.0;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.totalPiecesFinished = 0.0f;
        this.ratePerPiece = 0.0;
        this.birthDate = new MyDate();
    }

    public PieceWorkerEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = 0.0f;
        this.ratePerPiece = 0.0;
        this.birthDate = new MyDate();
    }

    public PieceWorkerEmployee(int empID, Name empName, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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

    public float getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(float totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
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

    public double computeSalary() {
        double base = totalPiecesFinished * ratePerPiece;
        double pieceBonus = Math.floor(totalPiecesFinished / 100);
        double result = base + (pieceBonus * (ratePerPiece * 10));
        if (isBirthdayMonth()) {
            result += BIRTHDAY_BONUS;
        }
        return result;
    }

    // Overload used by EmployeeRoster.displayPayroll(int) so the birthday-bonus
    // check is made against the simulated payroll month instead of the real clock.
    public double computeSalary(int month) {
        double base = totalPiecesFinished * ratePerPiece;
        double pieceBonus = Math.floor(totalPiecesFinished / 100);
        double result = base + (pieceBonus * (ratePerPiece * 10));
        if (birthDate.getMonth() == month) {
            result += BIRTHDAY_BONUS;
        }
        return result;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | Pieces Finished: %.0f | Rate/Piece: ₱%.2f\n", empID, empName, totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        String bonusNote = isBirthdayMonth() ? " (+₱5,000 birthday bonus)" : "";
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %.0f, Rate/Piece: ₱%.2f, Total Salary: ₱%,.2f%s]",
                empID, empName, totalPiecesFinished, ratePerPiece, computeSalary(), bonusNote);
    }
}