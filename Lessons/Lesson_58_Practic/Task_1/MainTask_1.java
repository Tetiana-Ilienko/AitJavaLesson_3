package Task_1;

import java.util.function.Function;
import java.util.function.Predicate;

public class MainTask_1 {

    /*
    Написать метод, принимающий строку, состоящую из слов разделенных пробелом и два функциональных интерфейса
     - function  и predicate.
     Метод должен предоставлять возможность реализации следующих действий:
     1. При длине слова = 3 изменить все буквы этого слова на заглавные и вернуть измененную строку
     Пример: "aaa BBBB deF vbghR bbb" -> "AAA BBBB DEF vbghR BBB"
     2. При длине слова = 4 изменить все буквы этого слова на строчные(маленькие) и вернуть измененную строку
     Пример: "aaa BBBB deF vbghR bbb" -> aaa bbbb deF vbghR bbb
     3. При длине слова = 5 изменить все буквы слова на звездочки  и вернуть измененную строку
     Пример: "aaa BBBB deF vbghR bbb" -> aaa BBBB deF ***** bbb
      Слова состоят только из букв латинского алфавита
      Протестировать.

      public String transformString(String input, Predicate<> predicate, Function<> function)
     */

    public static String transformString(String input, Predicate<String> predicate, Function<String,String> function){
        String[] strings = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String str: strings) {
            if(predicate.test(str)){
                result.append(function.apply(str)).append(" ");
            }
            else {
                result.append(str).append(" ");
            }

        }return result.toString().trim();
    }

    public static void main(String[] args) {



        Predicate<String> predicate3 = s -> s.length()==3;
        Predicate<String> predicate4 = s -> s.length() ==4;
        Predicate<String> predicate5 = s -> s.length() ==5;

        Function<String,String> function3 = String::toUpperCase;
        Function<String,String> function4 = String::toLowerCase;
        Function<String,String> function5 = s -> s.replaceAll(s,"*****");

        String str = "Ich wunsche Ihnen alles Gute !";

        System.out.println(transformString(str, predicate3, function3));
        System.out.println(transformString(str, predicate4, function4));
        System.out.println(transformString(str, predicate5, function5));

    }


}
