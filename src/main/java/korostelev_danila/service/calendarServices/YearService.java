package korostelev_danila.service.calendarServices;

import korostelev_danila.model.Month;
import korostelev_danila.model.Year;
import korostelev_danila.util.YearConsts;

public class YearService {
    private final MonthService monthService;

    public YearService(MonthService monthService) {
        this.monthService = monthService;
    }

    public Year getYear(String year) {
        return null;
    }
}
