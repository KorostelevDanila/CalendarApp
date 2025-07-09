package korostelev_danila.service.calendarServices;

import korostelev_danila.model.Day;
import korostelev_danila.model.Month;
import korostelev_danila.model.enums.DayOfWeek;
import korostelev_danila.model.enums.Months;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import static korostelev_danila.util.YearConsts.DAYS_IN_MONTHS;
import static korostelev_danila.util.YearConsts.MONTHS_NAMES;

@Service
public class MonthService {
    private final DayService dayService;
    private final DayOfWeekService dayOfWeekService;

    public MonthService(DayService dayService, DayOfWeekService dayOfWeekService) {
        this.dayService = dayService;
        this.dayOfWeekService = dayOfWeekService;
    }

    public Month getMonth(String year, Months months) {
        List<Day> days = getListOfDaysInMonth(year, months);
        return new Month(MONTHS_NAMES.get(months.ordinal()), days);
    }

    private Day getFirstDay(String year, Months month) {
        int firstDayNumeric = 1;
        int numericYear = Integer.parseInt(year);
        int numericMonth = month.ordinal() + 1;
        DayOfWeek firstDayOfWeekInMonth = dayOfWeekService.getDayOfWeek(numericYear, numericMonth, firstDayNumeric);
        return dayService.getDay(firstDayOfWeekInMonth, firstDayNumeric);
    }

    private List<Day> getListOfDaysInMonth(String year, Months months) {
        Day currentDay = getFirstDay(year, months);
        List<Day> days = new LinkedList<>();
        int maxDaysInMonth = getMaxDayInMonth(year, months);
        for (int i = 0; i < maxDaysInMonth; i++) {
            days.add(currentDay);
            currentDay = dayService.getNextDay(currentDay);
        }
        return days;
    }

    private int getMaxDayInMonth(String year, Months months) {
        if (Integer.parseInt(year) % 4 == 0) {
            if (months.ordinal() == 1) {
                return 29;
            }
        }
        return DAYS_IN_MONTHS.get(months.ordinal());
    }
}
