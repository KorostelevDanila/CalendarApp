package korostelev_danila.service.calendarServices;

import korostelev_danila.model.Day;
import korostelev_danila.model.enums.DayOfWeek;

public class DayService {

    public Day getDay(DayOfWeek dayOfWeek, String dayNumber) {
        return new Day(dayNumber, dayOfWeek);
    }

    public Day getNextDay(Day day) {
        return null;
    }
}
