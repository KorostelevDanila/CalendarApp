import korostelev_danila.service.calendarServices.DayOfWeekService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import korostelev_danila.model.enums.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOfWeekServiceTests {
    private DayOfWeekService service;

    @BeforeEach
    void setUp() {
        service = new DayOfWeekService();
    }

    @ParameterizedTest(name = "{index} => date={0}-{1}-{2} should be {3}")
    @MethodSource("dateProvider")
    @DisplayName("getDayOfWeek should return correct DayOfWeek")
    void testGetDayOfWeek(int year, int month, int day, DayOfWeek expected) {
        DayOfWeek actual = service.getDayOfWeek(year, month, day);
        assertEquals(expected, actual);
    }

    private static Stream<Object[]> dateProvider() {
        return Stream.of(
                new Object[]{2025, 1, 1, DayOfWeek.WEDNESDAY}, // 1 января 2025
                new Object[]{2020, 2, 29, DayOfWeek.SATURDAY},  // Февраль високосного года, делящегося на 4
                new Object[]{1999, 12, 31, DayOfWeek.FRIDAY},   // Конец 20 века
                new Object[]{2021, 2, 1, DayOfWeek.MONDAY},     // 1 февраля 2021
                new Object[]{2021, 3, 1, DayOfWeek.MONDAY},     // 1 марта 2021
                new Object[]{2000, 2, 29, DayOfWeek.TUESDAY},   // Февраль високосного года, делящегося на 400
                new Object[]{1900, 3, 1, DayOfWeek.THURSDAY}    // 1 марта високосного года
        );
    }
}
