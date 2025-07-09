import korostelev_danila.model.Day;
import korostelev_danila.service.calendarServices.DayOfWeekService;
import korostelev_danila.service.calendarServices.DayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import korostelev_danila.model.enums.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayServiceTests {
    private DayService dayService;

    @BeforeEach
    public void setUp() {
        dayService = new DayService();
    }

    @ParameterizedTest(name = "{index} => day = {0} should be {1}")
    @MethodSource("daysProvider")
    @DisplayName("getDayOfWeek should return correct DayOfWeek")
    void testGetDayOfWeek(Day testingDay, Day expectedDay) {
        Day actualDay = dayService.getNextDay(testingDay);
        assertEquals(expectedDay, actualDay);
    }

    private static Stream<Object[]> daysProvider() {
        return Stream.of(
                new Object[]{new Day(1, DayOfWeek.MONDAY), new Day(2, DayOfWeek.TUESDAY)}, // Обычный случай
                new Object[]{new Day(3, DayOfWeek.SUNDAY), new Day(4, DayOfWeek.MONDAY)} // С воскресенья на понедельник
        );
    }
}
