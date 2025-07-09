package korostelev_danila.model;

import java.util.List;
import java.util.Objects;

public class Month {
    private final String name;
    private final List<Day> days;

    public Month(String name, List<Day> days) {
        this.name = name;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public List<Day> getDays() {
        return days;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return Objects.equals(name, month.name) && Objects.equals(days, month.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, days);
    }

    @Override
    public String toString() {
        return "Month{" +
                "name='" + name + '\'' +
                ", days=" + days +
                '}';
    }
}
