import java.util.function.*;

public class Main_57 {

    /*
    1. Конкатенировать (сложить) числа  a  и  b
           пример  1 и 2 -> 12

     2. Если длина строки  = 3  вернуть true  иначе false
     3. Если длина строки четная  вернуть true  иначе false
     4. Вернуть строку в верхнем регистре
     5. Если длина строки = 4 вернуть четыре звездочки **** иначе вернуть строку без изменений
     6. Распечатать строку в виде !строка!
     7. возвращает  "Hello World"
     */

    public static void main(String[] args) {

        //  1. Конкатенировать (сложить) числа  a  и  b

        BiFunction<Integer, Integer, String> biFun = (a, b) -> Integer.toString(a) + b;
        System.out.println(biFun.apply(1, 2)); // 12

        //  2. Если длина строки  = 3  вернуть true  иначе false

        Predicate<String> pred = str -> str.length() == 3;
        System.out.println(pred.test("Karamba"));// false

        //  3. Если длина строки четная  вернуть true  иначе false

        Predicate<String> pred1 = str -> str.length() % 2 == 0;
        System.out.println(pred1.test("Karamba"));// false
        System.out.println(pred1.test("Boston"));// true

        // 4. Вернуть строку в верхнем регистре

        UnaryOperator<String> unary = str -> str.toUpperCase();
        System.out.println(unary.apply("Guten Morgen!"));//GUTEN MORGEN!

        // 5. Если длина строки = 4 вернуть четыре звездочки **** иначе вернуть строку без изменений

        UnaryOperator<String> unary1 = str -> str.length() == 4 ? "****" : str;
        System.out.println(unary1.apply("gern"));// ****
        System.out.println(unary1.apply("gerne"));// gerne

        // 6. Распечатать строку в виде !строка!

        Consumer<String> con = str -> System.out.println('!' + str + '!');
        con.accept("Hallo Welt");// !Hallo Welt!

        // 7. возвращает  "Hello World"

        Supplier<String> sup = () -> "Ich wunsche dir einen schönen Tag!";
        System.out.println(sup.get());

    }


}
