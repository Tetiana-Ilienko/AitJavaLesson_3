import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class MainBuiltInInterfaces {

    /** Predicate Interface
     *  @FunctionalInterface
     *  public interface Predicate<T>{
     *      boolean test ( T t );
     *  }
     * *//*

    Предикат в программировании - это функция или выражение, которое возвращает булевское значение (true или false) на
    основе заданных условий. В более простых словах, предикат - это выражение, которое проверяет,
    выполняется ли определенное условие, и возвращает true, если условие истинно, и false в противном случае.

    В Java, предикаты часто используются в контексте функционального программирования и в библиотеке java.util.function.
    В этой библиотеке определен интерфейс Predicate<T>, который представляет собой функциональный интерфейс
    с методом test(T t). Этот метод принимает один аргумент типа T и возвращает true или false в зависимости от
    выполнения условия.

    Дополнительные методы предикаты (дефолтные)

    boolean and(Predicate other)
    Метод and возвращает новый предикат, который представляет собой логическое "И" между
    текущим предикатом и другим предикатом other. То есть, он вернет true только если оба предиката возвращают true.

    boolean or(Predicate other)
    позволяет создать новый предикат, представляющий логическое "ИЛИ" (OR) между текущим предикатом и другим
    предикатом other. Это значит, что новый предикат будет возвращать true, если хотя бы один из предикатов
    (текущий или other) вернет true.

    negate()
    Метод negate возвращает новый предикат, который представляет собой отрицание текущего предиката.
    То есть, он инвертирует результат текущего предиката.

    */

    /**  UnaryOperator<T>
     * @FunctionalInterface
     * public interface UnaryOperator<T>{
     *      T apply (T obj)
     * }
     *//*
     UnaryOperator<T> - это функциональный интерфейс в Java из пакета java.util.function. Этот интерфейс
     представляет собой оператор, который принимает входное значение одного типа T и возвращает результат того же типа T.
     Он имеет всего один абстрактный метод apply(T t), который принимает один аргумент типа T и возвращает значение
     того же типа T.
     Этот метод выполняет операцию над входным значением и возвращает результат этой операции.
     */

    /**
     * Function<T, R>
     *
     * @FunctionalInterface
     * public interface Function<T, R>{
     * T apply (T obj)
     * }
     *//*
     Function<T, R> - это функциональный интерфейс в Java из пакета java.util.function. Этот интерфейс представляет
     собой функцию, которая принимает входное значение типа T и возвращает результат типа R.
     Он имеет всего один абстрактный метод apply(T t), который принимает один аргумент типа T и возвращает значение
     типа R.
     Этот метод выполняет операцию над входным значением и возвращает результат этой операции.

     */

    /** BinaryOperator<T>
     *
     * @FunctionalInterface
     * public interface BinaryOperator<T>{
     *  T apply (T obj1, T obj 2)
     * }
     *//*
     Этот интерфейс представляет собой операцию с двумя аргументами типа T и возвращает результат того же типа T.
     BinaryOperator<T> широко используется в Java для выполнения бинарных операций, таких как сложение, умножение,
     объединение строк и так далее. Он также может быть полезен в потоковых операциях для агрегации данных.
     */

    /** Consumer<T>
     *
     * @FunctionalInterface
     * public interface Consumer<T> {
     *     void accept(T t);
     * }
     *//*
     Этот интерфейс представляет собой операцию, которая принимает один аргумент типа T и выполняет какое-то действие,
     но не возвращает результат.
     Основным методом этого интерфейса является accept(T t), который принимает один аргумент и выполняет действие над
     ним. Это действие может быть представлено в виде лямбда-выражения или ссылки на метод.
     Consumer<T> часто используется в потоковых операциях для выполнения действий над элементами потока, таких как вывод
     на экран, запись в файл, отправка данных и другие действия, которые не требуют возврата результата.
     */

    /** Supplier<T>
     *
     * @FunctionalInterface
     * public interface Supplier<T> {
     *     T get();
     * }
     *//*
     Он представляет собой операцию, которая не принимает аргументов, но возвращает результат типа T.
     Этот интерфейс полезен, когда вам нужно получить или сгенерировать значение, но не требуется передавать ему
     входные данные.
     Основным методом этого интерфейса является get(), который не принимает аргументов и возвращает значение типа T.
     Supplier<T> может быть полезным, когда вам нужно создавать объекты, получать данные из внешних источников (например,
     считывать данные из файла или базы данных) или выполнять другие операции, которые возвращают значение без
     входных аргументов.

     */

    /** BiFunction <T,U,R>
     *
     * @FunctionalInterface
     * public interface BiFunction<T, U, R> {
     *     R apply(T t, U u);
     * }
     *//*
      Он представляет собой функцию, которая принимает два аргумента типов T и U, выполняет операцию и возвращает
      результат типа R. Этот интерфейс полезен, когда вам нужно выполнить операцию над двумя входными значениями и
      получить результат.
      BiFunction<T, U, R> может быть полезным, когда вам нужно выполнить операцию, которая зависит от двух входных
      значений, и получить результат. Например, вы можете использовать его для выполнения операций с парами чисел,
      работе с координатами и т. д.
     */

    public static void main(String[] args) {

//        ******************* Predicate Interface *******************
        Predicate<Integer> isPositive = num -> num > 0;
        System.out.println(isPositive.test(10)); // true
        System.out.println(isPositive.test(-10)); // false

//        *****************   UnaryOperator<T> *********************
        UnaryOperator<Integer> unaryOperator = num -> num / 2;
        unaryOperator.apply(2);

//        *****************   Function< T, R>  *********************
        Function<Integer, String> function = String::valueOf;
        function.apply(10);

        Function<Integer, String> function1 = num -> String.valueOf(num) + "times";
        function.apply(10);
//          *****************   BinaryOperator<T>  *********************
//          *****************   Consumer<T>  *********************
//          *****************   Supplier<T>  *********************
//          *****************   BiFunction <T,U,R>  *********************

    }
}
