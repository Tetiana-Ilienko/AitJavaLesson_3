import java.util.List;
import java.util.function.Supplier;

public class MainReference {

    /*
    Method Reference (ссылка на метод)
    ссылка на метод - это способ сослаться на метод не выполняя его.
    Ссылки на методы связаны с лямбда-выражениями т.к. им так же требуется совместимый функциональный интерфейс

    Ссылки на статические методы ( Method references to static method)
    ClassName :: methodName
    Ссылки на статические методы в Java позволяют использовать методы в качестве параметров или аргументов для других
    методов. Это особенно полезно, когда вам нужно передать метод как аргумент в функции высшего порядка, такие как
    методы map, filter, reduce и другие.

     */

    public static void main(String[] args) {

//*******************  Ссылки на статические методы ( Method to static method)
//    Создаем функциональный интерфейс
        /*
        @FunctionalInterface
public interface IntPredicate {
    boolean test(int n);

    затем создаем  class OurPredicateClass, в котором определяем три статитеских метода
    создаем метод (ниже) numTest(IntPredicate p, int n)
    метод принимает IntPredicate p - параметр прописанного нами функционального интерфейса
     (тоесть передаем ссылку на метод)
         */
//    ClassName :: methodName
        numTest(OurPredicateClass :: isNegative, -1);
        numTest(OurPredicateClass ::isEven, 4);
        /*
        // Интерфейс для функционального метода, который принимает два числа и возвращает результат
interface Calculator {
    int calculate(int a, int b);
}

// Статический метод, который складывает два числа
class MathUtil {
    public static int add(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = MathUtil::add; // Ссылка на статический метод
        int result = calculator.calculate(5, 3);
        System.out.println("Результат: " + result); // Выводит "Результат: 8"
    }
}
         */



//   *******************  Ссылки  не статические  методы ( Instance method reference) *
        /*
        Ссылки на нестатические методы в Java предоставляют способ вызывать методы на объектах, используя функциональные
        интерфейсы. Это особенно полезно при работе с функциями высшего порядка, такими как map, filter и другими,
        которые требуют функциональных интерфейсов.
        objectRef :: methodName
        экземпляр объекта:: название метода


         */
        /*
        Пример. Используем тот же интерфейс, но создадим новый класс
        class OurInteger
         */
        OurInteger ourInteger = new OurInteger(9); // создали два объекта
        OurInteger ourInteger1 = new OurInteger(10);

        IntPredicate intPredicate = ourInteger :: isFactor; // создаем ссылку через не статический метод
                                 //  здесь мы используем не название класса, а ссылку на объект
        intPredicate.test(3);

//   *******************  Создание ссылки на любой обьект класса через ссылку на обычный метод ************
      //  ClassName :: instanceMethodName(имя обычного метода)
        /*
        Создаем новый интерфейс
        public interface IntPredicate2 {
    boolean test(OurInteger ourNum, int n); // Первымпараметном он принимает объект OurInteger
    вторым переметном - будет принимаемое число

        IntPredicate2 intPredicate2 = OurInteger :: isFactor;
        intPredicate2.test(ourInteger,3);
         */

//  **********************      generic example  *************************
    //    SomeGenericInterface<Integer> someRef = SomeGenericClass ::<Integer>genMethod;



//  **********************   ссылки на конструктор ( Constructor references)  *************************
      /*
        className :: new
        для создания ссылки на конструктор можно использовать функциональный интерфейс, метод которого совместим
        с конструктором


        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> stringList = listSupplier.get(); // создание нового ArrayList
        */



    }


//*******************  Ссылки на статические методы ( Method to static method)

    public static boolean numTest(IntPredicate p, int n){
        return p.test(n);
    }


    public interface SomeGenericInterface<T> { // итерфейс для примера с дженерикиками
        boolean test(T n, T m);


    }

    public class SomeGenericClass { // класс для примера с дженерикиками

        public   <T> boolean genMethod(T a, T b){
            return false;
        }
    }


}
