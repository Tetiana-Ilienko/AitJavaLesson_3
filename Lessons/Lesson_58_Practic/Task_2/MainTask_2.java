package Task_2;

public class MainTask_2 {
    /*
    2. Дана строка, состоящая из слов, разделенных пробелом. Написать метод, позволяющий изменять слова в строке
      таким образом:
     1. При длине слова = 3 изменить все буквы этого слова на заглавные и вернуть измененную строку
     Пример: "aaa BBBB deF vbghR bbb" -> "AAA BBBB DEF vbghR BBB"
     2. При длине слова = 4 изменить все буквы этого слова на строчные(маленькие) и вернуть измененную строку
     Пример: "aaa BBBB deF vbghR bbb" -> aaa bbbb deF vbghR bbb
     3. При длине слова = 5 изменить все буквы слова на звездочки  и вернуть измененную строку
     Пример: "aaa BBBB deF vbghR bbb" -> aaa BBBB deF ***** bbb
      Слова состоят только из букв латинского алфавита
      Использовать свойства наследования классов
      Протестировать.
     */

    public static String transformString1(String input, WordsTransformer object){
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(object.check(words[i])){
                words[i] = object.transform(words[i]);
            }

        }
      return String.join(" ",words);
    }

    public static void main(String[] args) {
        String str = "Ich wunsche Ihnen alles Gute !";

        System.out.println(transformString1(str, new WordsTransformerToUpperCase()));
        System.out.println(transformString1(str, new WordsTransformerLowerCase()));
        System.out.println(transformString1(str, new WordsTransformerStar()));
    }
}
