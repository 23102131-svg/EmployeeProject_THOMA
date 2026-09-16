package version3;

import java.time.LocalDate;

public class MyDate {
    private int date;
    private int month;
    private int year;

    public MyDate() {
        this.date = 1;
        this.month = 1;
        this.year = 2026;
    }

    public MyDate(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    // Returns a MyDate built from the real system clock, used as "today" for birthday checks.
    public static MyDate today() {
        LocalDate now = LocalDate.now();
        return new MyDate(now.getDayOfMonth(), now.getMonthValue(), now.getYear());
    }

    // True when this date's month matches another date's month (e.g. birthday-month check).
    public boolean isSameMonth(MyDate other) {
        return this.month == other.getMonth();
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", month, date, year);
    }
}
