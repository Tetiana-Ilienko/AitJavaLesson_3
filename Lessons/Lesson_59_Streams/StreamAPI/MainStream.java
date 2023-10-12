package StreamAPI;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainStream {
    /*
    Stream API - это мощный инструмент в Java для работы с коллекциями данных и выполнения операций над ними.
    Он предоставляет возможность создания потоков данных (streams) и последовательного выполнения на них различных
    операций. Stream API вводит функциональный стиль программирования, который делает код более лаконичным и читаемым.
    Stream - это интерфейс

    Вот основные концепции и операции, предоставляемые Stream API:

    *  Stream: Поток данных представляет собой последовательность элементов, над которой можно выполнять операции.
    Поток можно создать из коллекции, массива или другого источника данных.

    *  Промежуточные операции: Это операции, которые можно выполнять над потоком данных, не изменяя его.
    Промежуточные операции возвращают новый поток данных, который можно дальше обрабатывать.
    Примеры промежуточных операций: filter, map, sorted, distinct.
    Промежуточных опeраторов может быть несколько

    *  Терминальные операции: Эти операции завершают обработку потока данных и возвращают результат.
    Терминальные операции начинают выполнение цепочки операций. Примеры терминальных операций: forEach, collect,
    reduce, count.
    Обработка данных не начнется пока не будет вызван терминальный оператор. Терминальный оператор может быть
    только один

    *   Ленивая обработка: Потоки данных обрабатываются лениво, что означает, что операции выполняются только при
    необходимости. Это позволяет оптимизировать работу с большими объемами данных.

    *   Параллельная обработка: Stream API предоставляет возможность параллельной обработки данных с использованием
    методов parallelStream() и parallel(). Это может значительно улучшить производительность при обработке больших данных.


   !!!!!!!!!! Больше одного раза созданный стрим использовать нельзя!!!!!!
     */


    public static void main(String[] args) {
        int[] ints = {10, 20, 30, 40, 50, 60, 70};
        int counter = 0;
        for (int i : ints) {
            if (i < 21)
                continue; // из цикла не выходим, но переходим к следующей операции
            i = i * 2;
            counter++;
            if (counter > 3)
                break;
            System.out.println(i);
        }
//  **************  "example with stream"  ****************************
        // тот же код с использованием стрима

        IntStream.of(10, 20, 30, 40, 50, 60, 70) // создаем поток целых чисел
                .filter(i -> i >= 21)
                .map(i -> i * 2)
                .limit(3)
                .forEach(System.out::println);


//   *******************  создание стримов    ****************************
        // пустого стрима
        Stream<String> empty = Stream.empty(); // Stream  - это тоже дженерик

        //  стрим коллекции
        Collection<String> collection = Arrays.asList("One", "Two", "Three");
        collection.stream();

        // стрим массива
        String[] array = {"One", "Two", "Three"};
        Arrays.stream(array);

        //  стрим строки
        "abcde".chars(); // запискает стрим символов строки

        // c помощью статического метода of()
        Stream.of("one", "two");

        //  стримы примитивов
        IntStream intStream = IntStream.of(1, 2, 3);
        IntStream.range(1, 3); // создание стрима целых чисел в диапазоне от 1 до 3 (3 не включая)
        IntStream.rangeClosed(1, 3);// создание стрима целых чисел в диапазоне от 1 до 3 (3 включая)

        //  стрим примитивов с помощью класса Random
        Random random = new Random();
        random.doubles();


        Stream<String> fruits = Stream.of("Apple", "Orange", "Lemon", "Kiwi");
        fruits.forEach(System.out::println);

//   **************************  промежуточные операторы  ******************************
        // filter() -  принимает условие (предикату) и возвращает поток из элементов, удовлетворяющих
        //                этому условию

        System.out.println("after filter");
        fruits = Stream.of("Apple", "Orange", "Lemon", "Kiwi"); // нужно создавать еще раз стрим, прошлый был уже закрыт
        fruits.filter(f -> f.length() == 5).forEach(System.out::println);

        // создадим класс  Car (см. ниже)
        Stream<Car> cars = Stream.of(new Car("Mercedes", 100000) // создаем стрим объектов (машин)
                                   , new Car("Volvo", 80000)
                                   , new Car("Bentley", 500000));

        cars.filter(car -> car.getPrice() < 200000).forEach(car -> System.out.println(car.getBrand())); // отфильтровываем машины по
        // цене

        // map() - маппинг, отображение - преобразует элементы потока (из одного типа в другой например)
        //map(Function mapper) - метод принимает функциональный интерфейс

        System.out.println("****  mapping brand  *******");

        cars = Stream.of(new Car("Mercedes", 100000)
                , new Car("Volvo", 80000)
                , new Car("Bentley", 500000));

        cars.filter(car -> car.getPrice() < 200000)
                .map(Car::getBrand)
                .forEach(System.out::println);
//       ---------------------------------------------------------

        cars = Stream.of(new Car("Mercedes", 100000)
                , new Car("Volvo", 80000)
                , new Car("Bentley", 500000));

        cars
                .map(car -> "brand: " + car.getBrand() + " price: " + car.getPrice())
                .forEach(System.out::println);

        // sorted() -  сортировка
        System.out.println("**********  sorting  ****************");
        List<String> carList = new ArrayList<>();
        carList.add("mercedes");
        carList.add("volvo");
        carList.add("bentley");
        carList.add("opel");

        carList.stream()
                .filter(car -> car.length() > 4)
                .sorted()
                .forEach(System.out::println);


    }

    public static class Car {

        private String brand;
        private int price;

        public Car(String brand, int price) {
            this.brand = brand;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public int getPrice() {
            return price;
        }
    }

}
