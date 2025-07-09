package korostelev_danila.model;

import korostelev_danila.model.enums.DayOfWeek;

import java.util.Objects;

public class Day {
    private final int dayNumber;
    private final DayOfWeek dayOfWeek;

    public Day(int dayNumber, DayOfWeek dayOfWeek) {
        this.dayNumber = dayNumber;
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return dayNumber == day.dayNumber && dayOfWeek == day.dayOfWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayNumber, dayOfWeek);
    }

    @Override
    public String toString() {
        return "Day{" +
                "dayNumber=" + dayNumber +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }
}
