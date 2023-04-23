//From Java version 1.8 New package called Joda-Time API was Introduced to Simplify Things
import java.time.*;
public class _2_Joda_Time_API {
    public static void main(String[] args) {
        LocalDate date=LocalDate.now();
        System.out.println(date);
        // (or)
        //System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());

        int day= date.getDayOfMonth();
        int month=date.getMonthValue();
        int year=date.getYear();
        System.out.println(day+"/"+month+"/"+year);

        LocalTime time=LocalTime.now();
        System.out.println(time);

        int hour=time.getHour();
        int min=time.getMinute();
        int sec=time.getSecond();
        int nano=time.getNano();
        System.out.println(hour+":"+min+":"+sec+":"+nano);
    }
}
