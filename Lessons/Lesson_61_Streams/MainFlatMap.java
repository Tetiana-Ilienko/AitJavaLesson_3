import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainFlatMap {

    public static void main(String[] args) {

        // another flatMap example
    /*
    flatMapToInt() - это одна из операций Stream API в Java, которая позволяет преобразовать элементы
    внутреннего потока в примитивные int и объединить результаты в один поток IntStream.

    Этот метод полезен, когда у вас есть поток элементов, который сам по себе является потоком (Stream) и
    вы хотите преобразовать его элементы в примитивные значения типа int и объединить их в единый IntStream.


    IntStream(a,b)
     */
        Stream.of(2,3,0,1,3)
                .flatMapToInt(i -> IntStream.range(0,i))
                .forEach(System.out::print);


        Stream.of(2,3,0,1,3)
                .map(i -> IntStream.range(0,i))
                .forEach(System.out::print);





    }



}
