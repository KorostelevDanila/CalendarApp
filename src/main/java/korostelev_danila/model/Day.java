package korostelev_danila.model;

import korostelev_danila.model.enums.DayOfWeek;

public class Day {
    private String dayNumber;
    private DayOfWeek dayOfWeek;

    public Day(String dayNumber, DayOfWeek dayOfWeek) {
        this.dayNumber = dayNumber;
        this.dayOfWeek = dayOfWeek;
    }
}
