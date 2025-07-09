package korostelev_danila.model;

public class Calendar {
    private Year year;

    public Calendar(Year year) {
        this.year = year;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "year=" + year +
                '}';
    }
}
