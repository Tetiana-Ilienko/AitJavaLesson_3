import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MainOptional {

    /*
    Optional - это класс в Java, представленный в Java 8 и выше, который предназначен для обработки возможных null
    значений, чтобы избежать NullPointerException и улучшить безопасность кода. Optional может быть использован для
    обертывания значений и указания на их присутствие или отсутствие.

    Основные преимущества Optional:

   *  Безопасная обработка null: Optional предоставляет безопасный способ работы с возможными null значениями.
   Он позволяет избежать NullPointerException, потому что вам не нужно явно проверять значения на null.

   *  Читаемость кода: Использование Optional может улучшить читаемость кода, так как позволяет явно указать,
   что значение может быть отсутствующим.

   *  Функциональный стиль программирования: Optional предоставляет методы для выполнения различных операций над
   обернутым значением, используя функциональный стиль программирования.

   // Создаем Optional с непустым значением
        Optional<String> nonEmptyOptional = Optional.of("Hello, World!");

   // Создаем Optional с пустым значением
        Optional<String> emptyOptional = Optional.empty();

   // Проверяем, присутствует ли значение
        if (nonEmptyOptional.isPresent()) {
            System.out.println("Value is present: " + nonEmptyOptional.get());
        } else {
            System.out.println("Value is absent");
        }

  // Используем метод ifPresent для выполнения действий, если значение присутствует
        nonEmptyOptional.ifPresent(value -> System.out.println("Value is present: " + value));

        метод isPresent()  используется для проверки наличия внутри обьекта Optional  значения.
      если есть - то возвращается true  и false  если null


     */
    public static void main(String[] args) {

        // получить длину строки можно таким способом
        String name = "John";
        if( name != null){
            System.out.println(name.length());
        }
        // или таким
        Optional<String> optional = Optional.of("java");
        optional.ifPresent(str -> System.out.println(str.length()));
//  ************  методы получения значения из Optional  ***************************

        // orElse() - Получение значения по умолчанию, если оно отсутствует - задается дефолтное значение

        String nullName  = null;  // если null - вернет "Kate", иначе "John"
        nullName = "John";
        String kate = Optional.ofNullable(nullName).orElse("Kate");
        System.out.println(kate);

        // orElseGet() - Генерация значения по умолчанию, если оно отсутствует (используя Supplier - функционалльный интерфейс)
        // в этом случае дефолтный объект не создается, что экономит ресурсы
        nullName = null;
        String anotherName = Optional.ofNullable(nullName).orElseGet(()->"Kate");
        System.out.println(anotherName);

        // orElseThrow -  выдает значение, либо кидает Exception  если null
        /*
         String nameEx  = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException :: new);
         String nameEx  = Optional.ofNullable(nullName).orElseThrow();

         */

        // get() - используется для извлечения значения из объекта Optional. Однако, следует быть осторожным при
        // использовании get(), так как если значение в Optional отсутствует (то есть Optional пуст), то вызов get()
        // вызовет NoSuchElementException
        Optional<String> newWord = Optional.of("Hello");
        String hello = newWord.get();
        System.out.println(hello);

        Optional<String> newWordNull = Optional.ofNullable(null); // - в данном случае выдаст Exception
        // newWordNull.get();


        //        ****** методы работы с Optional **********

        List<Integer> emptyList = new ArrayList<>();
        Optional<Integer>minElement =  emptyList.stream().min(Integer::compare);
        if(minElement.isPresent())
            minElement.get();
        //-----------------------------------
        System.out.println(minElement.orElse(-1));
        // ----------------------------------
        Random random = new Random();

        System.out.println(minElement.orElseGet(()->random.nextInt(10)));

        minElement.ifPresent(System.out::println);
        minElement.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Empty!")
        );

    }
}
