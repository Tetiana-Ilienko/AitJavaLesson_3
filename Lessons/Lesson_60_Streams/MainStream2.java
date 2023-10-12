import StreamAPI.MainStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStream2 {

    public static void main(String[] args) {
        /***********************    flatMap()     ******************/
        /*
        flatMap() - это один из методов в Stream API, предназначенный для манипуляции с элементами внутри потока данных.
        Он часто используется для развертывания вложенных структур данных, таких как списки внутри списков, и
        преобразования их в один общий поток.

        Основное назначение flatMap() заключается в следующем:

        Принимает элементы из исходного потока и преобразовывает их с помощью заданной функции в новые потоки данных.
        Развертывает полученные потоки данных, объединяя элементы в один общий поток.
        Возвращает итоговый поток данных.

        flatMap() полезен, когда у вас есть структуры данных с вложенными списками или потоками,
        и вы хотите работать с элементами внутри этих структур как с одним общим потоком данных.
         */

        String[] strings = {"Hello","Java"};

        Arrays.stream(strings)
                .map(str -> str.split(""))
                .map(Arrays::stream)
                .forEach(System.out::println);
        //  пустили массив в стрим ->> разделили по буквам и на выходе получили стрим масивов
        // ->> далее если я запусскаю еще раз в стрим, то у нас получается два стрима и запускаются
        // они поотдельности
        // метод .flatMap - склеивает эти два стрима


        Arrays.stream(strings)
                .map(str -> str.split(""))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);

        /***********************    distinct()     ******************/
        /* distinct() - возвращает только уникальные элементы
        предназначенный для удаления дубликатов из потока данных. Он возвращает новый поток данных, в котором каждый
        элемент встречается только один раз.

        Основное назначение distinct() заключается в следующем:

       Применяет функцию hashCode() и equals() к элементам потока, чтобы определить их уникальность.
       Удаляет повторяющиеся элементы из исходного потока.
       Возвращает новый поток данных без дубликатов.

       distinct() может быть полезен, когда вы хотите обработать только уникальные элементы в вашем потоке данных
       или когда вам нужно удалить дубликаты из коллекции.
         */


        Stream.of("one","two","three","one","two")
                .distinct()
                .forEach(System.out::println);

        /***********************    skip( long n)     ******************/
        /* skip( long n) - пропускает первые n элементов в потоке данных и возвращает новый поток, начиная с элемента,
        идущего после первых n элементов.
        Его функциональность может быть полезной, когда вам нужно пропустить определенное количество элементов,
        прежде чем начать обработку данных. Например, это может быть полезно для пагинации данных или пропуска
        заголовков в текстовом файле.*/

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> skippedNumbers = numbers.stream()
                .skip(5) // Пропустить первые 5 элементов
                .collect(Collectors.toList());

        System.out.println(skippedNumbers); // Вывод: [6, 7, 8, 9, 10]


        /***********************    // limit(long n)     ******************/
        // limit(long n) -  ограничивает поток данных, так чтобы он включал только первые n элементов.
        // Возвращает новый поток данных, содержащий только первые n элементов из исходного потока.

        System.out.println();
        System.out.println("******  skip and limit *************");
        System.out.println();
        List<String> arr = Arrays.asList("one","two","three","four","five");
        arr.stream()
                .skip(1) // пропустили "one"
                .limit(3)
                .forEach(System.out::println); // "two","three","four"
//***********************************************************************************
//      ******************   terminal operators   Операции сведения ( терминальные) *********************
        //операции, возвращающие результат

//      forEach()
//      ******   count() -  возвращает количество элементов в потоке

        System.out.println(arr.stream()
                .filter(s ->s.length()>3) // отфильтровываем элементы длинной больше 3
                .count()); // 3 - сосчитал элементы

//      *******   findFirst(), findAny()********

        Optional<String> first = arr.stream().findFirst();
        System.out.println(first.get()); // one

        Optional<String> any = arr.stream().findAny();
        System.out.println(any.get()); // one

//       ********    boolean allMatch(),anyMatch(), noneMatch()
        /*
        allMatch(predicate) - true , если все элементы удовлетворяют условию предикаты
        anyMatch(predicate) - true , если хотя бы один элемент удовлетворяет условию предикаты
        noneMatch(predicate) - true , если ни один  элемент не  удовлетворяет условию предикаты
         */

        List<String> names = Arrays.asList("Jack","John","Ann","Benjamin");
        boolean allElements = names.stream().allMatch(s -> s.length() > 2);// true
        System.out.println(allElements); // true

        boolean anyElement = names.stream().anyMatch(s -> s.length() >6);
        System.out.println(anyElement); // true

        boolean noneElt = names.stream().noneMatch(s -> s.equals("Kate")); //  не один не равен "Kate"
        System.out.println(noneElt);// true


//     *****   min()  и max() - используемые для поиска минимального и максимального значения в потоке данных.
//     Они возвращают опциональное (Optional) значение, так как поток данных может быть пустым.
        /*
        Optional<T> min (T comparator)
        Optional<T> max (T comparator)
         */

        List<Integer> ints = Arrays.asList(1,2,34,5,60,21);

        Optional<Integer> minElt =  ints.stream().min(Integer::compare);
        System.out.println(minElt.get());

        Optional<Integer> maxElt = ints.stream().max(Integer::compare);
        System.out.println(maxElt.get());

        /*
        Так же можно работать с классами - только в нем обязательно нужно переопределить
        метод compere()

        Обратите внимание, что результат возвращается в виде Optional, так как, если поток данных пуст,
        метод min() или max() вернет пустой Optional. Поэтому перед доступом к значению результата,
        обычно, вы проверяете его с помощью ifPresent()
         */

//      *******  reduce() - используется для свертывания элементов в потоке в одно окончательное значение.
//      Этот метод может быть использован для выполнения различных агрегирующих операций, таких как суммирование,
//      умножение, конкатенация и другие.

        Optional<Integer> res =  Stream.of(1,2,3,4,5).reduce((a,b)->a * b); // сразу создаем и запускаем стрим
        System.out.println(res.get());
        // el1 * el2 * el3 * el4

        Optional<String> strRes = Stream.of("Hello","Java","!").reduce((str1,str2) ->str1 +" "+str2);
        System.out.println(strRes.get());



        // reduce() -2 (принимает BIFunction b  начальное значение)

        System.out.println(res.stream().reduce(1, (a, b) -> a * b)); // 120 /


        int result =Stream.of(1,2,3,4,5).reduce(2,(a,b)-> a * b);
        System.out.println(result); //  в этом варианте нет Optional, так как есть начальное значение, которое вернеться
        // если массив пустой


//   *******************   метод collect(collector) *******************
        /*  метод collect(collector) - это метод в Java Stream API, предназначенный для сбора элементов
        потока в коллекцию или другую структуру данных. Он является более обобщенным способом сбора элементов,
        чем использование методов, таких как toList(), toSet(), toMap() и другие.

        collect() использует объект Collector для определения того, как элементы потока будут собраны и возвращены в
        конечную структуру. Collector предоставляет методы для накопления, объединения и финишного преобразования данных.

        Конечный результат собирается с помощью метода collect() и возвращает объект, представляющий собой
        конечную структуру данных (например, List, Set, Map или другую).

        Collector также позволяет выполнять более сложные сборки данных, такие как группировку, объединение,
        свертку и другие операции. Вы можете создавать собственные Collector'ы для удовлетворения конкретных
        требований вашего приложения.
         */
        // Collector<T,A,R> collector

        //*****************  некоторые методы класса Collectors
        /*
        toList() -  метод собирает элементы потока в список. Вернет список, содержащий все элементы из потока.
        toSet() - метод собирает элементы потока в множество (набор). Вернет множество, содержащее уникальные
        элементы из потока.
        toMap() - метод собирает элементы потока в карту. Вы можете определить, какие элементы будут ключами,
        а какие значениями в карте, используя лямбда-выражения для определения ключей и значений
         */

        List<String> cars = new ArrayList<>();
        cars.add("Mercedes");
        cars.add("Volvo");
        cars.add("Opel");
        cars.add("Ford");
        cars.add("BMW");

        List<String> carsFiltered =  cars.stream()
                .filter(car -> car.length() > 3)
                .collect(Collectors.toList());

        System.out.println(carsFiltered);

        Set<String> carsSet = cars.stream()
                .filter(car -> car.length() > 3)
                .collect(Collectors.toSet());

        //  для мапы нужно создать ключи значение
        MainStream.Car car1 = new MainStream.Car("Mercedes",100000);
        MainStream.Car car2 = new MainStream.Car("BMW",150000);
        MainStream.Car car3 = new MainStream.Car("Ford",30000);

        List<MainStream.Car> carList = Arrays.asList(car1,car2,car3);

        Map<String,Integer> carMap = carList.stream()
                .collect(Collectors.toMap(MainStream.Car::getBrand, MainStream.Car::getPrice));

        System.out.println(carMap);
                //  то же самое (печать мапы) с методом forEach
        carMap.forEach((key,value)-> System.out.println("key: " +key +" ,value: "+ value));

        // если на выходе после стрима мы должны получить ArrayList
        ArrayList<MainStream.Car> resCars = carList.stream().collect(Collectors.toCollection(ArrayList::new));


        // groupingBy collector -  используется для группировки элементов потока по определенному критерию
        // и сбора их в виде карты (Map), где ключами являются критерии группировки, а значениями - списки элементов,
        // удовлетворяющих каждому критерию.
        System.out.println("----groupingBy------");
        List<String> namesList = Arrays.asList("John","Jack","Ann","Bill","Peter","Eugen");
        System.out.println(namesByLength(namesList));// {3=[Ann], 4=[John, Bill, Jack], 5=[Eugen, Peter]}


        /*
         partitioningBy -  особый случай метода groupingBy,  принимающий предикату и собирающий элементы стрима в мапу
         в которой в качестве ключей будут boolean значения а в качестве значений - коллекции элементов.
         ключ true -  коллекция элементов, удовлетворяющих условию предикаты,
         false -  не удовлетворяющих*/

        System.out.println("----partitioningBy-----");
        System.out.println(partitioningList(namesList));
    }


    /*
    ПРимер метода groupingBy collector
    написать метод , группирующий элементы  листа строк в зависимости от длины строки и сохраняющий  результаты
    в сетах. Метод возвращает мапу
     */
    public  static Map<Integer,Set<String>>  namesByLength(List<String>list){
        return list.stream()
                .collect(Collectors.groupingBy(String::length,Collectors.toSet()));
    }

    /*

    Пример partitioningBy: написать метод, разделяющий элементы листа стрингов  по длине строки > 4  и возвращающий
     мапу с ключами true false   и листами соответствующих элементов
     */
    public  static Map<Boolean,List<String>> partitioningList( List<String>list){
        return list.stream().
                collect(Collectors.partitioningBy(s -> s.length() > 4)); // {false=[John, Jack, Ann, Bill], true=[Peter, Eugen]}



    }



}
