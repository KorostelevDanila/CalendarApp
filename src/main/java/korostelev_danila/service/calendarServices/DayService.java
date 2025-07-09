package korostelev_danila.service.calendarServices;

import korostelev_danila.model.Day;
import korostelev_danila.model.enums.DayOfWeek;

public class DayService {

    public Day getDay(DayOfWeek dayOfWeek, int dayNumber) {
        return new Day(dayNumber, dayOfWeek);
    }

    public Day getNextDay(Day day) {
        int newDayNumber = day.getDayNumber() + 1;
        DayOfWeek newDayOfWeek = DayOfWeek.values()[day.getDayOfWeek().ordinal()].next();
        return new Day(newDayNumber, newDayOfWeek);
    }
}
