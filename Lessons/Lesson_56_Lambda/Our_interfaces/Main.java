package Our_interfaces;

public class Main {
    /*
    Используя наши интерфейсы написать такие лямбда- выражения:
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

        Concatable concat = (a,b) -> String.valueOf(a)+ b;
        // Concatable concatable = (a,b) ->Integer.toString(a) + b;
        System.out.println(concat.concat(1,2));// 12

        Checkable ch = str -> str.length() ==3;
        System.out.println(ch.check("Sommer")); // false

        Checkable ch1 = str -> str.length()%2 ==0;
        System.out.println(ch1.check("Sommer")); // true

        Transformable tr = str -> str.toUpperCase();
        System.out.println(tr.modify("mama"));// MAMA

        Transformable tr1 = str -> (str.length() == 4 ) ? "****" : str;
        System.out.println(tr1.modify("mama")); // ****
        System.out.println(tr1.modify("maman")); // maman

        Printable pr = str -> System.out.println('!' + str + '!');
        pr.print("Hallo"); // !Hallo!

        Producable prod = () -> "Hello World";
        System.out.println(prod.produce());

    }
}
