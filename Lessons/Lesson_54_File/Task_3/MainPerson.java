package Task_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class MainPerson {

     /*
    3. Пусть есть текстовый файл такого вида:
        Peter,35
        Simon,5
        John,90
        Нужно написать метод, читающий этот файл и возвращающий список людей старше 18 лет,
        отсортированный по возрасту. Известно, что файл не пустой
     */

    public static List<Person> over18Years(File fileName){
        List<Person> persons = new ArrayList<>(); //  создаем результирующий лист

        // организуем процесс чтения
        List<String> temp = new ArrayList<>(); // создаем промежуточный лист, в который мы будем
        // предварительно считывать строчки информацию из файла

        String line; // сюда будем считывать показания нашего метода

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            while ((line = br.readLine()) != null){ // читаем в цикле построчно
                temp.add(line);// считали все строчки в лист
            }

        }catch (IOException e){
            e.printStackTrace(); // выводит информацию об этом исключении, включая его тип, сообщение об ошибке и
            // стек вызовов, который привел к возникновению ошибки.
        }
        for (String s: temp) { // берем наш записанный лист и в цикле
            String[] nameAge = s.split(","); // записывая его в массив, разделяем по запятой
            int age = Integer.parseInt(nameAge[1].trim());// в первой ячейки храниться возраст
            // переводим строку в int, если есть лишние пробелы - мы их убираем .trim()
            if (age > 18) { // если персоне >18
                persons.add(new Person(nameAge[0].trim(), age));// добавляем ее в наш результирующий лист
                // (new Person(nameAge[0],age ) - конструктор

            }
        }
            Collections.sort( persons); // так как наш класс implements Comparable<Person> -
                      // используем метод sort для сортировки

        return persons;


    }

    public static void main(String[] args) {

        System.out.println(over18Years(new File("classPerson.txt")));

    }

}
