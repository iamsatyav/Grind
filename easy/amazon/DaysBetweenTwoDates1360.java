package easy.amazon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DaysBetweenTwoDates1360 {
	public static void main(String[] args) throws ParseException {
		System.out.println(daysBetweenDates("2020-01-15", "2019-12-31"));
	}
	
    public static int daysBetweenDates(String date1, String date2) throws ParseException {
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);
        int d = (int) Math.abs(ChronoUnit.DAYS.between(d1, d2));
        return d;
    }
}
