package phone;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static phone.Main.LOGGER;

public class ThreadInfo implements Runnable {
    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    int year = localDate.getYear();
    int month = localDate.getMonthValue();
    int day = localDate.getDayOfMonth();

    public void run() {
        Main main = new Main();
        LOGGER.info(Thread.currentThread().getName() + main.createPhoneList());
    }
}
