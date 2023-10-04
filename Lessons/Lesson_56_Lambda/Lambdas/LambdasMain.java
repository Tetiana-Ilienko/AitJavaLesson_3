package Lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdasMain {

    // теория: MyTestProject_2 // Lesson_35


    public static void main(String[] args) {
        int height = 1000;

//   ******     реализаия  метода  функционального интерфейса Flyable через анонимный класс   *********
        Flyable f = new Flyable() {
            @Override
            public void fly() {
                System.out.println("Flying at " + height);
            }
        };

        f.fly(); // Flying at 1000

//    *********** реализация через лямбда **************************
        Flyable fLambda = () -> {
            System.out.println("Flying at " + height);
        };

        fLambda.fly();

//         ----------------------------

        Walkable w = () -> {
            return ("I can walk ");
        };

        System.out.println(w.walk());
//        -------------------------
        Eatable eatable = (food) -> {
            return "A man can eat " + food;
        };

        System.out.println(eatable.eat("apple"));// A man can eat apple
//        -----------------------------
        Summable sum = (x, y) -> {
            return x + y;
        };
        System.out.println(sum.sum(1, 2));

//    **********  короткая форма записи - lambda-expression  ***************
        Summable s = (x, y) -> x + y;

        Eatable eat = food -> "A man can eat " + food;

        Summable sMinus = (x, y) -> x - y;
        System.out.println("for sMinus the result is " + sMinus.sum(2, 3));

//    ***********  метод forEach через лямбду  ******************************
        List<String> fruits = new ArrayList<>();
        fruits.add("lemon");
        fruits.add("orange");
        fruits.add("apple");
        fruits.add("kiwi");

        fruits.forEach(
                fruit -> System.out.println(fruit) //  пишем лямбда выражение
        );


//     *************  сортировка через comparator *************************
        List<Product> items = new ArrayList<>();
        items.add(new Product("mouse", 25));
        items.add(new Product("laptop", 1000));
        items.add(new Product("keyboard", 75));

        Collections.sort(items, (p1, p2) -> p1.name.compareTo(p2.name)); // String  name  -  в классе String переопределен
        // соответственно мы можем сравнить через метод compareTo
        System.out.println(items);

        Collections.sort(items, (p1, p2) -> p1.price - p2.price); // здесь происходить сравнение по кстественному порядку
        // (на выход '1 ' или '-1' или  '0' )
        System.out.println(items);

        /*********  св - ва лямбды *********** //*
         * выполнение лямбда выражения - может быть отложенным (вызвана она может быть позже и столько раз, сколько нужно)
         *
         * параметры лямбда выражения должны полностью соответствовать и по типу и по количеству с методом,
         * прописанным в интерфейсе
         *
         * функциональный интерфейс можно сделать обобщенным, лямбда-выражение - нельзя. Прописывая само выражение
         * нужно указать тип
         *
         * лямбда-выражение может выступать в качестве параметра метода
         */

//        **************  пример с обобщенным интерфейсом *********
        /*
           @FunctionalInterface
         public interface Operationable <T> {

         T calc( T i, T j);
            }
         */

        Operationable<Integer> po1 = (a, b) -> a + b;
        Operationable<String> po2 = (a, b) -> a + b;

//    **********  лямбда-выражение в качестве параметра метода  ******************

        int[] numbers = {1, 2, 3, 4, 5, 6, 7};

        IsMoreThan isMoreThan = num -> num > 3;
        System.out.println(isMoreThan.isMore(2)); // true
        System.out.println(isMoreThan.isMore(5)); // false

      //  isMoreThan = num -> num > 10; //  разные реализации на одну ссылку

        System.out.println(sumIfCondition(numbers, isMoreThan)); // 22
    }
      /*
      1. определяем лямбду  IsMoreThan isMoreThan = num -> num > 3;
      2. переопределяем ее в качестве параметра
       */
    public static int sumIfCondition(int[] ints, IsMoreThan expression) {
        // мы хотим суммировать элементы массива, если они удовлетворяют некоему условию
        int sum = 0;

        for (int elt : ints) {
            if(expression.isMore(elt)){
                sum += elt;
            }

        }
        return sum;
    }


}