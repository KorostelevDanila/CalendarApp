package korostelev_danila.service.calendarServices;

import korostelev_danila.model.Calendar;
import korostelev_danila.model.Year;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {
    private final YearService yearService;
    private Year lastRequestedYear = null;

    public CalendarService(YearService yearService) {
        this.yearService = yearService;
    }

    public Calendar getCalendar(String year) {
        if (lastRequestedYear != null) {
            if (lastRequestedYear.getYear().equals(year)) {
                return new Calendar(lastRequestedYear);
            }
        }
        Year requestedYear = yearService.getYear(year);
        lastRequestedYear = requestedYear;
        return new Calendar(requestedYear);
    }

}
