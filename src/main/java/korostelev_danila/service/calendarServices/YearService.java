package korostelev_danila.service.calendarServices;

import korostelev_danila.model.Month;
import korostelev_danila.model.Year;
import korostelev_danila.model.enums.Months;
import korostelev_danila.util.YearConsts;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static korostelev_danila.util.YearConsts.MONTHS_IN_YEAR;

@Service
public class YearService {
    private final MonthService monthService;

    public YearService(MonthService monthService) {
        this.monthService = monthService;
    }

    public Year getYear(String year) {
        List<Month> monthList = new ArrayList<>();
        Months currentMonth = Months.JANUARY;
        for (int i = 0; i < MONTHS_IN_YEAR; i++) {
            Month month = monthService.getMonth(year, currentMonth);
            monthList.add(month);
            currentMonth = Months.values()[currentMonth.ordinal()].next();
        }
        return new Year(year, monthList);
    }
}
