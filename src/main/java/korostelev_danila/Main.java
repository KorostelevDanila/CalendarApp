package korostelev_danila;

import korostelev_danila.exception.IncorrectYearFormatException;
import korostelev_danila.model.Calendar;
import korostelev_danila.service.calendarServices.CalendarService;
import korostelev_danila.service.printServices.api.CalendarPrintService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
        CalendarService calendarService = ctx.getBean("calendarService", CalendarService.class);
        CalendarPrintService calendarPrintService = ctx.getBean(CalendarPrintService.class);
        Scanner scanner = new Scanner(System.in);
        boolean applicationLoop = true;
        boolean notAnswered = true;

        while (applicationLoop) {
            try {
                notAnswered = true;
                System.out.print("Please, enter a year: ");
                String year = scanner.nextLine();
                Calendar calendar = calendarService.getCalendar(year);
                calendarPrintService.print(calendar);
                while (notAnswered) {
                    System.out.print("Get new calendar? [Y/N]: ");
                    String answer = scanner.nextLine();
                    switch (answer) {
                        case "Y":
                            notAnswered = false;
                            break;
                        case "N":
                            notAnswered = false;
                            applicationLoop = false;
                            break;
                        default:
                            System.out.println("Wrong input, please, retry");
                            break;
                    }
                }
            } catch (IncorrectYearFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}