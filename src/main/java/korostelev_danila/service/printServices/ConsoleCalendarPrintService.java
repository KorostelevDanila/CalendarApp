package korostelev_danila.service.printServices;

import korostelev_danila.model.Calendar;
import korostelev_danila.service.printServices.api.CalendarPrintService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ConsoleCalendarPrintService implements CalendarPrintService {

    @Override
    public void print(Calendar calendar) {

    }
}
