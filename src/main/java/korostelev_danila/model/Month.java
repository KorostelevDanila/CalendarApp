package korostelev_danila.model;

import java.util.List;

public class Month {
    private String name;
    private List<Day> days;

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
}
