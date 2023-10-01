import Task_3.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainTask4 {


    /*
    4. Пусть есть класс Person c полями name  и age. Нужно написать метод, записывающий в файл обьекты
      класса Person в виде строк и одновременно выводящий их на экран
     */

    public static void readPerson(String fileName, Person person) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName, true))) {
            String str = person.toString();
            br.write(str);
            br.write(";");
            br.newLine();
            br.flush();
            System.out.println(str);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    /*
    переопределенный toString (import ; \\ Lesson_54\\Task_3.Person)
     @Override
    public String toString() {
        return name+","+age;
    }


     */

    // перегрузка
    public static void readPerson1(String fileName, List<Person> persons) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName))) {
            for (Person person : persons) {
               String str = person.toString();
                br.write(str);
                br.write(";");
                br.newLine();
                br.flush();
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        File file = new File("person.txt");
        Person person = new Person("Julia", 31);
        Person person1 = new Person("Nick", 40);
        Person person2 = new Person("Jack", 28);

        List<Person> persons = new ArrayList<>();
        persons.add(person);
        persons.add(person1);
        persons.add(person2);
//        System.out.println(persons);


//        readPerson("person.txt", person);
//        readPerson("person.txt", person1);
//        readPerson("person.txt", person2);

        readPerson1("person.txt", persons);


    }
}

