package korostelev_danila.service.calendarServices;

import korostelev_danila.exception.IncorrectYearFormatException;
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

    public Calendar getCalendar(String year) throws IncorrectYearFormatException {
        try {
            int integerYear = Integer.parseInt(year);
            if (integerYear < 1600) {
                throw new IncorrectYearFormatException("Year is less than 1600, please, enter new value");
            }
        } catch (NumberFormatException e) {
            throw new IncorrectYearFormatException("Incorrect year format, please, enter new value");
        }

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
