/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Version1;

/**
 *
 * @author User
 */
public class PieceWorkerEmployee {

    private int empID;
    private String empName;
    private float totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalPiecesFinished = 0.0f;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = 0.0f;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
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

    public double computeSalary(){
        double Base = totalPiecesFinished * ratePerPiece;
        double Bonus = Math.floor(totalPiecesFinished / 100);
        double Result = Base + (Bonus * (ratePerPiece * 10));
        return Result;
    }

    public void displayPieceWorkerEmployee(){
        System.out.printf("ID: %d | Name: %s | Pieces Finished: %f | Rate/Piece: ₱%.2f\n", empID, empName, totalPiecesFinished, ratePerPiece);
    }


    @Override
    public String toString() {
        return "PieceWorkerEmployee{" + "empID=" + empID + ", empName=" + empName + ", totalPiecesFinished=" + totalPiecesFinished + ", ratePerPiece=" + ratePerPiece + '}';
    }


}

