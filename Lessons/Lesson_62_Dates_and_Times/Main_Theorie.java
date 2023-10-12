import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.Set;

public class Main_Theorie {
    /*
    Класс LocalDate из пакета java.time предназначен для работы с датами.
    Функционал этого класса позволяет создавать даты и изменять их, добавляя и отнимая необходимое количество дней/месяцев/лет.

Основные методы LocalDate:

static LocalDate now(): возвращает объект, который представляет текущую дату

static LocalDate of(int year, int month, int day): возвращает объект, который представляет дату с определенными годом, месяцем и днем

int getYear(): возвращает год даты

int getMonthValue(): возвращает месяц

int getDayOfMonth(): возвращает день месяца (значение от 1 до 31)

int getDayOfYear(): возвращает номер дня года (значение от 1 до 365)

DayOfWeek getDayOfWeek(): возвращает день недели в виде значения перечисления DayOfWeek

LocalDate plusDays(int n): добавляет к дате некоторое количество дней

LocalDate plusWeeks(int n): добавляет к дате некоторое количество недель

LocalDate plusMonths(int n): добавляет к дате некоторое количество месяцев

LocalDate plusYears(int n): добавляет к дате некоторое количество лет

LocalDate minusDays(int n): отнимает от даты некоторое количество дней

LocalDate minusMonths(int n): отнимает от даты некоторое количество месяцев

LocalDate minusWeeks(int n): отнимает от даты некоторое количество недель

LocalDate minusYears(int n): отнимает от даты некоторое количество лет
     */

    /*
   Date/Time API

   Начиная с Java 8  появились новые классы для работы с датой и временем.

   Существовавшие до этого классы имели ряд недостатков:
   1. Не были потокобезопасными
   2. Плохой дизайн и работа методов
   3. Не учитывались временные зоны.

   Основные новые классы для работы с датой и временем:
   1.LocalDate
   2.LocalTime
   3.LocalDateTime
   4.ZonedDateTime
   5.Period
   6.Duration

   Классы 1-3 - наиболее часто используемые. Используют местное время  и как правило указывать
   временные зоны не нужно.

   LocalTime
    */
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now(); // now() -  возвращает текущее время
        System.out.println("Time now is "+localTime); // Time now is 15:22:53.208815800

        LocalTime localTime1 = LocalTime.of(13,35,20); // of() -создание обьекта LocalTime
        System.out.println("our time is " + localTime1); // our time is 13:35:20

        //  получить часы
        System.out.println("Hour: " + localTime1.getHour());

        // получить минуты
        System.out.println("Minutes: " + localTime1.getMinute());

        // методы для добавления часов, минут, секунд, наносекунд ко времени
        LocalTime newLocalTime = LocalTime.of(17,25,34,1111111);
        System.out.println("Adding hours: " + newLocalTime.plusHours(2));
        System.out.println("Adding minutes: " + newLocalTime.plusMinutes(10));
        System.out.println("Adding minutes: " + newLocalTime.plusSeconds(10));
        System.out.println(newLocalTime);

        // методы для вычитания  часов, минут, секунд, наносекунд от времени
        System.out.println("Subtracting hours: " + newLocalTime.minusHours(1));

        // методы isBefore() and isAfter() -   проверяют будет ли время localtime  на котором они вызываются
        // позже или раньше чем время с котором оно сравнивается. Возвращает true  или false  соответственно

        LocalTime timeToCheck = LocalTime.of(13,25);
        System.out.println(timeToCheck.isBefore(LocalTime.now()));
        System.out.println(timeToCheck.isAfter(LocalTime.now()));

        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MIDNIGHT);
        System.out.println(LocalTime.NOON);

        // LocalDate -  представляет собой дату без указания временной зоны в формате год-месяц-день (year-month-day)

        LocalDate localDate = LocalDate.of(2020,1,10);
        System.out.println(localDate);
        System.out.println(LocalDate.now());
        LocalDate dateNow = LocalDate.now();

        System.out.println("In now a leap year ? " + dateNow.isLeapYear() ); //  проверяет високосный ли год
        System.out.println("In 2020 a leap year ? " + localDate.isLeapYear() ); //  проверяет високосный ли год

        // isBefore isAfter
        System.out.println(dateNow.isBefore(localDate));
        System.out.println(dateNow.isAfter(localDate));

        //  можно отнимать/ прибавлять дни, недели, месяцы
        LocalDate yesterday = dateNow.minusDays(1);
        System.out.println("yesterday was " + yesterday);

        System.out.println(dateNow.getDayOfWeek());
        System.out.println(dateNow.getEra());

        System.out.println(dateNow.lengthOfMonth());
        System.out.println(dateNow.lengthOfYear());


        // LocalDateTime -  сочетание даты и времени

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 =LocalDateTime.of(2000,10,1,10,15);
        System.out.println(localDateTime1.getDayOfYear());
        System.out.println(localDateTime1.getMonth());
        System.out.println(localDateTime1.getMonthValue());

        //  ZonedDateTime - время\дата с учетом временной зоны
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);

        LocalDateTime now = LocalDateTime.now();
        ZoneId london = ZoneId.of("Europe/London");
        //  ZonedDateTime inLondon = ZonedDateTime.of(now,london);
        //  System.out.println("Time in London is " + inLondon);


        ZoneId berlin = ZoneId.of("Europe/Berlin");
        //  ZonedDateTime inBerlin = ZonedDateTime.of(now,berlin);
        //  System.out.println("Time in London is " + inBerlin);

        ZonedDateTime inBerlin = ZonedDateTime.now();
        System.out.println(inBerlin);
        ZonedDateTime inLondon = ZonedDateTime.now(london);
        System.out.println(inLondon);

        Iterator<String> iterator = availableZoneIds.iterator();
        //  while (iterator.hasNext()){
        //    System.out.println(iterator.next());
        //  }
        //availableZoneIds.forEach(System.out::println);

        // Period - класс, используемый для  изменения даты или получения разницы между двумя датами. Он работает
        // с временнЫми  еденицами год, месяц, день
        System.out.println("----Period----");
        LocalDate nowDate = LocalDate.now();
        LocalDate finalDate = nowDate.plus(Period.ofDays(5));
        System.out.println(finalDate);

        int fiveDays = Period.between(nowDate,finalDate).getDays();
        System.out.println(fiveDays);

        ChronoUnit.DAYS.between(nowDate,finalDate);

        // Duration -  класс можно использовать при работе со временем
        LocalTime initTime = LocalTime.of(10,30,0);
        LocalTime newTime = initTime.plus(Duration.ofHours(2));
        long duration =Duration.between(initTime,newTime).getSeconds();
        System.out.println(duration);

        ChronoUnit.SECONDS.between(initTime,newTime);


        // форматирование даты и времени  DateTimeFormatter
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.BASIC_ISO_DATE;
        String formatted = dateTimeFormatter.format(dateTime);
        System.out.println("Formatted with Basic ISO date format string is " + formatted);

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ISO_LOCAL_DATE;
        String formatted1 = dateTimeFormatter1.format(dateTime);
        System.out.println("Formatted with ISO local date format string is " + formatted1);

        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String formatted2 = dateTimeFormatter2.format(dateTime);
        System.out.println("Formatted with ISO local date time format string is " + formatted2);

        // "2023/10/12 12:42:30 - представление текущего времени преобразовать к такому формату
        DateTimeFormatter ourFormatter = DateTimeFormatter.ofPattern("yyyy/MMMM/dd HH:mm:ss");
        dateTime = LocalDateTime.now();
        String res = ourFormatter.format(dateTime);
        System.out.println("DateTime formatted with our formatter: " + res);

        /*
        y - year
        M - month в виде числа
        MMM - month  например  Jan
        MMMM -  полное название месяца
        d - day  день месяца
        E -  день недели  Mon  Пон
        EEEE -  полное название дня недели Monday
        h - hour  час 1-12
        H - hour 0-23
        m - minute
        s - second
        a am/pm

        yyyy-MM-dd  "2023-12-10"
        dd-MMM-yyyy "12-Oct-2023 "
        E,MMM dd yyyy  "Thu,Oct 12 2023
        h:mm a 12:58 PM
         */
}}
