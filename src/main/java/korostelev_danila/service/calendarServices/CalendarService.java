package korostelev_danila.service.calendarServices;

import korostelev_danila.model.Calendar;
import korostelev_danila.model.Year;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {
    private final YearService yearService;

    public CalendarService(YearService yearService) {
        this.yearService = yearService;
    }

    public Calendar getCalendar(String year) {
        return null;
    }

}
