package more_Collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    //  сосчитать количество элементов в листе
    public static long countElements(List<String> list){
        return list.stream()
                .collect(Collectors.counting()); // можно заменить методом .count()
    }

    //  найти максимальный элемент

    public static int maxElement(List<Integer> list){
        return list.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder())) // можно заменить методом .max()
                .get();
    }
// ----------------------------------------------------------------------------------------
    // joining() -  коллектор, который собирает элементы в строку

    // объединить имена в следующую строку
    // name1name2name3

    public static String convertToString (List<String> names){
        return names.stream()
                .collect(Collectors.joining());
    }
// -----------------------------------------------------------
    // объединить имена в следующую строку
    // name1, name2 ,name3

    public static String convertToStringComma (List<String> names){
        return names.stream()
                .collect(Collectors.joining(", "));
    }
    // -----------------------------------------------------------

    // обьединить имена из листа в следующую строку:
    //Students: name1, name2, name3 study Java

    public static String convertToStringWithPrefix (List<String> names){
        return names.stream()
                .collect(Collectors.joining(", ","Students: ", " study Java"));
    }


    public static void main(String[] args) {

        //*************  convertToString ******************
        List<String> names = Arrays.asList("Ann", "Kate", "Bill");
        System.out.println(convertToString(names)); // AnnKateBill

        // *************  convertToStringComma  ****************
        System.out.println(convertToStringComma(names)); // Ann, Kate, Bill

        // *************  convertToStringWithPrefix ****************
        System.out.println(convertToStringWithPrefix(names)); // Students: Ann, Kate, Bill study Java






    }
}
