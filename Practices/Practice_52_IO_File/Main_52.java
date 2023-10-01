import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
 есть файл "output.txt" записать в список хранящуюся там информацию
 */


public class Main_52 {
    public static void main(String[] args) {

        String data = read();
        List<Person> people = getPeople(data);

        System.out.println(people);

    }

    public static List<Person> getPeople(String data) {
        List<Person> people = new ArrayList<>();

        String[] dataArray = data.split(";");
        for (String st : dataArray) {
            try {
                people.add(new Person(st));
            }catch (PersonCreateException e){
                System.out.println("Error parsing " + st);
            }
        }
        return people;
    }


    public static String read(){
        try(FileReader fr = new FileReader("output.txt")){
            int data;
            StringBuilder sb= new StringBuilder();

            while ((data = fr.read() )!= -1){
                sb.append((char) data);}
            return sb.toString();


    } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }









}
