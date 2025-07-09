package korostelev_danila.model;

import java.util.List;

public class Year {
    private String year;
    private List<Month> months;

    public Year(String year, List<Month> months) {
        this.year = year;
        this.months = months;
    }

    public List<Month> getMonths() {
        return months;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Year{" +
                "year='" + year + '\'' +
                ", months=" + months +
                '}';
    }
}
