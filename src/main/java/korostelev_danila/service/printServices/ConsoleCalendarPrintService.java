package korostelev_danila.service.printServices;

import korostelev_danila.model.Calendar;
import korostelev_danila.model.Day;
import korostelev_danila.model.Month;
import korostelev_danila.model.Year;
import korostelev_danila.model.enums.DayOfWeek;
import korostelev_danila.service.printServices.api.CalendarPrintService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ConsoleCalendarPrintService implements CalendarPrintService {

    @Override
    public void print(Calendar calendar) {
        if (calendar == null || calendar.getYear() == null) {
            throw new IllegalArgumentException("Calendar or Year cannot be null");
        }
        printYear(calendar.getYear());
    }

    private void printYear(Year year) {
        System.out.printf("YEAR: %s%n%n", year.getYear());
        for (Month month : year.getMonths()) {
            printMonth(month);
        }
    }

    private void printMonth(Month month) {
        System.out.println(month.getName().toUpperCase());
        printWeekHeader();
        printDays(month.getDays());
        System.out.println("\n");
    }

    private void printWeekHeader() {
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.printf("%-4s", day.name().substring(0, 3));
        }
        System.out.println();
    }

    private void printDays(List<Day> days) {
        if (days.isEmpty()) return;

        DayOfWeek currentDayOfWeek = DayOfWeek.MONDAY;
        int dayCounter = 0;

        while (currentDayOfWeek != days.getFirst().getDayOfWeek()) {
            System.out.print("    ");
            currentDayOfWeek = currentDayOfWeek.next();
        }

        for (Day day : days) {
            System.out.printf("%-4d", day.getDayNumber());
            if (day.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println();
            }
        }
    }

}
