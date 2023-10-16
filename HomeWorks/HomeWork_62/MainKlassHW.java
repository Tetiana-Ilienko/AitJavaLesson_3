import jdk.jshell.execution.LoaderDelegate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MainKlassHW {

    public static void main(String[] args) {
        //1.
        LocalDate today = LocalDate.now();
        System.out.println(today);

        int year = today.getYear();
        int months = today.getMonthValue();
        int day = today.getDayOfMonth();

        LocalDate date = LocalDate.of(1976,5,18);

        today.equals(date);

        LocalTime time = LocalTime.now();
        time.plusHours(3);

        today.plusWeeks(1);
        today.plus(1, ChronoUnit.WEEKS);

        today.minus(1,ChronoUnit.YEARS);


//        10. Написать метод, принимающий лист из нескольких дат типа LocalDate и возвращающий
//        количество дней между самой ранней и поздней датами
        List<LocalDate> dates = new LinkedList<>();
        Collections.addAll(dates,
                LocalDate.now(),
                LocalDate.now().plusDays(20),
                LocalDate.now().plusDays(10),
                LocalDate.now().plusDays(6));

        System.out.println(dateDifference(dates));


    }
    public static long dateDifference(List<LocalDate> dateList){
        List<LocalDate> sortetList = dateList.stream()
                .sorted().collect(Collectors.toList());
        return ChronoUnit.DAYS.between(sortetList.get(0),
                sortetList.get(sortetList.size()-1));
    }



}
