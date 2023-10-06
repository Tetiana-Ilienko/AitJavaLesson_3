import Task_3.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainTask4 {


    /*
    4. Пусть есть класс Person c полями name  и age. Нужно написать метод, записывающий в файл обьекты
      класса Person в виде строк и одновременно выводящий их на экран
     */






    // перегрузка
    public static void readPerson(String fileName, List<Person> persons) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(System.out)) ) //  для вывода на экран
                                                   // OutputStreamWriter() - пишет информацию в выходной поток
         {
            for (Person person : persons) {
                bw.write("\"" + person.getName() + "\"" + "," + person.getAge() );
                bw1.write("\"" + person.getName() + "\"" + "," + person.getAge() );
                bw.newLine();
                bw1.newLine();
            }
        } catch (IOException e) {
           e.printStackTrace();
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


      readPerson("person.txt", persons);


    }
}

