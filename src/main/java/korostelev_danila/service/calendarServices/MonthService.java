package korostelev_danila.service.calendarServices;

import korostelev_danila.model.Month;
import korostelev_danila.model.enums.Months;

public class MonthService {
    private final DayService dayService;

    public MonthService(DayService dayService) {
        this.dayService = dayService;
    }

    public Month getMonth(String year, Months month) {
        return null;
    }
}
