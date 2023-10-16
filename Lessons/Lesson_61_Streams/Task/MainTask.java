package Task;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainTask {

    // 1. Есть классы Person и BankAccount нужно написать метод, принимающий лист BankAccounts и возвращающий
    // мапу, где Person будет ключом, а лист его\ ее счетов значением

    public static Map<Person, List<BankAccount>> mapAccountsToPerson(List<BankAccount> input){
       return input.stream()
                .collect(Collectors.groupingBy(BankAccount::getOwner)); //
    }

    // groupingBy collector -  используется для группировки элементов потока по определенному критерию
    // и сбора их в виде карты (Map), где ключами являются критерии группировки, а значениями - списки элементов,
    // удовлетворяющих каждому критерию.

//_________________________________________
    // 2. Есть класс BankAccount. Нужно написать метод, принимающий лист BankAccounts и
    // возвращающий лист IBANNs со звездочкой после третьего символа
    // DE4****************,DE5*******************,


    public static List<String> getListIBAN (List<BankAccount> accounts){
        return accounts.stream()
                .map(a -> replaceWithStars(a.getIBAN()))
                .collect(Collectors.toList());
    }

    private  static String replaceWithStars(String input){
        char[] chars = input.toCharArray();
        for (int i = 3; i < input.length(); i++) {
            chars[i] = '*';
                    }
        return new String(chars);
    }

    public static void main(String[] args) {
        Person person1 = new Person("Jonn");
        Person person2 = new Person("Kate");
        Person person3 = new Person("Ann");

        BankAccount account1 = new BankAccount("DE123445674321345699",person1);
        BankAccount account2 = new BankAccount("DE123445674321345623",person2);
        BankAccount account3 = new BankAccount("DE123445674321345600",person3);
        BankAccount account4 = new BankAccount("DE123445674321341234",person1);
        BankAccount account5 = new BankAccount("DE123445674321345633",person3);

        List<BankAccount>  accounts= Arrays.asList(account1,account2,account3,account4,account5);
        mapAccountsToPerson(accounts).forEach((k,v) -> System.out.println(k + " -> " + v));

        System.out.println(getListIBAN(accounts));


    }


}
