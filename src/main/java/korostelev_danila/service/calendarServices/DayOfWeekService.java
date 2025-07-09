package korostelev_danila.service.calendarServices;

import korostelev_danila.model.enums.DayOfWeek;
import org.springframework.stereotype.Service;

@Service
public class DayOfWeekService {
    // Реализация формулы Зеллера для вычисления дня недели по году, месяцу и дню
    public DayOfWeek getDayOfWeek(int year, int month, int day) {
        if (month < 3) {
            year = year - 1;
            month += 10;
        } else {
            month -= 2;
        }

        int dayOfWeekIndex = (day + (31 * month) / 12 + year + year / 4 - year / 100 + year / 400) % 7;
        dayOfWeekIndex = (dayOfWeekIndex + 6) % 7; // Так как формула Зеллера расчитана на американский формат дней недели, то делаем сдвиг на привычный нам формат
        return DayOfWeek.values()[dayOfWeekIndex];
    }
}
