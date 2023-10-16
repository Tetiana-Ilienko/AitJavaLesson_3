import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MainParallelStreamAPI {

    /* Параллельные потоки (Parallel Streams) - это одна из возможностей, предоставляемых Java Stream API,
    для выполнения операций над данными в параллельном режиме. Она позволяет использовать несколько ядер процессора
    для обработки больших наборов данных более эффективно

        два метода  превращения потока из последовательного в параллельный
        1. метод parallel из Интерфейса Stream
        2. метод parallelStream() из Интерфейса Collection
         */

    public static void main(String[] args) {

        Stream<Integer> number = Stream.of(1,2,3,4,5);
        Optional<Integer> result = number.parallel().reduce(Integer::sum); // заменили  ->>>  reduce((a,b) -> a+ b)
        System.out.println(result.get()); // 15

        List<String> names = Arrays.asList("Jack","Ann","Kate","Bill","John");


        System.out.println("regular stream");
        names.stream().filter(name -> name.length() >3).forEach(System.out::println);

        System.out.println("\n parallel stream");
        names.parallelStream().filter(name -> name.length() > 3).forEach(System.out::println);


    }


}
