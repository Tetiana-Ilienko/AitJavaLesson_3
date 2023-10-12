import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainYomeTime {


    public static void main(String[] args) {

     /*
     1. Получить и вывести на экран:
       -текущую дату
       -текущий год, месяц и день
      */
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate); // 2023-10-12

        LocalDate currentData = LocalDate.now();
        System.out.println(currentData.getYear());// 2023
        System.out.println(currentData.getMonth());// OCTOBER
        System.out.println(currentData.getDayOfWeek());// THURSDAY

//        2. Создать дату , например день рождения и вывести на экран
        LocalDate birthday = LocalDate.of(2003, 7, 31);
        System.out.println("My sons birthday is : " + birthday); // My sons birthday is : 2003-07-31

//        3. Создать две даты и проверить на равенство
        LocalDate data1 = LocalDate.now();
        LocalDate data2 = LocalDate.of(2023, 12, 24);
        if (data1.equals(data2)) {
            System.out.println(" the dates are equal. Yay, it's Christmas!");
        } else System.out.println("the dates are not equal. Alas...");

//        4. Получить и вывести на экран текущее время
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime); // 22:20:11.150727200

//        5. текущее время + 3 часа
        System.out.println("Add 3  hours: " + currentTime.plusHours(3)); // Add 3  hours: 01:22:57.993637100

//        6. Создать дату на неделю позже сегодняшней
        LocalDate today = LocalDate.now();
        System.out.println(today.plusWeeks(1)); // 2023-10-19

//        7. Создать дату, которая была на год раньше сегодняшней используя метод minus
        System.out.println(today.minusYears(1)); // 2022-10-12

//        8. Создать дату на год позже сегодняшней используя plus метод
        System.out.println(today.plusYears(1)); // 2024-10-12

//        9. Создать даты tomorrow и yesterday и проверить находятся ли они до или после сегодняшней
        LocalDate tomorrow = localDate.plusDays(1);
        LocalDate yesterday = localDate.minusDays(1);
        System.out.println(today.isBefore(tomorrow)); // true
        System.out.println(today.isAfter(yesterday)); // true

//        10. Написать метод, принимающий лист из нескольких дат типа LocalDate и возвращающий
//        количество дней между самой ранней и поздней датами
        
        List<LocalDate> dates = List.of(
                LocalDate.of(2008,12,4),
                LocalDate.of(2010,3,8),
                LocalDate.of(2002,5,18),
                LocalDate.of(2000,12,12)

        );

        System.out.println(dateDifference(dates));


       // dateDifference1(dates); // перегруженный метод

    }

    public static int dateDifference(List<LocalDate> datas) {

        LocalDate minData = datas.get(0);
        LocalDate maxData = datas.get(0);
        for (LocalDate ld : datas) {
            if (ld.isBefore(minData)){
                minData=ld;
            }
            if (ld.isAfter(maxData)){
                maxData = ld;
            }

        }
       Period result = Period.between(minData,maxData);
        return result.getYears()*365+ result.getMonths()*30 + result.getDays() ;
        // значение вернется усредненное, так как месяца(30) и года(365) беру усредненные


    }




    public static void dateDifference1(List<LocalDate> datas) {

        LocalDate minData = datas.get(0);
        LocalDate maxData = datas.get(0);
        for (LocalDate ld : datas) {
            if (ld.isBefore(minData)){
                minData=ld;
            }
            if (ld.isAfter(maxData)){
                maxData = ld;
            }

        }
        Period result = Period.between(minData,maxData);
        int years = result.getYears();
        int months = result.getMonths();
        int days = result.getDays();

        System.out.println("the difference between " +minData+ " and " +maxData+
                " is " + years + " years " + months+ " months " + days+ " days");


    }
}
