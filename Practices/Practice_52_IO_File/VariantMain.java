

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class VariantMain {

    /*
    есть файл "output.txt" записать в список хранящуюся там информацию
 */

    public static void main(String[] args) throws IOException {
        System.out.println(writeList("output.txt"));


    }
    public static List<Person> writeList(String file) throws IOException {
        List<Person> persons = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {

            String[] temp = line.split(";");

            //Jack,10;John,20;Ann,30;
            for (String s : temp) {
                persons.add(new Person(s));
            }

        } return persons;
    }

}
