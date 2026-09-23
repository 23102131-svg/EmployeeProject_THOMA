package version5;

public class PieceWorkerEmployee extends Employee {

    private float totalPiecesFinished;
    private double ratePerPiece;

    public static final double BIRTHDAY_BONUS = 5000.0;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0.0f;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName) {
        super(empID, empName);
        this.totalPiecesFinished = 0.0f;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName);
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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

    private double basePay() {
        double base = totalPiecesFinished * ratePerPiece;
        double pieceBonus = Math.floor(totalPiecesFinished / 100);
        return base + (pieceBonus * (ratePerPiece * 10));
    }

    @Override
    public double computeSalary() {
        double result = basePay();
        if (isBirthdayMonth()) {
            result += BIRTHDAY_BONUS;
        }
        return result;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double result = basePay();
        if (getBirthDate().getMonth() == currentMonth) {
            result += BIRTHDAY_BONUS;
        }
        return result;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | Pieces Finished: %.0f | Rate/Piece: \u20b1%.2f\n",
                getEmpID(), getEmpName(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        String bonusNote = isBirthdayMonth() ? " (+\u20b15,000 birthday bonus)" : "";
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %.0f, Rate/Piece: \u20b1%.2f, Total Salary: \u20b1%,.2f%s]",
                getEmpID(), getEmpName(), totalPiecesFinished, ratePerPiece, computeSalary(), bonusNote);
    }
}