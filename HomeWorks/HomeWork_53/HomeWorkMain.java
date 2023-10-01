import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HomeWorkMain {

    /*
    Написать метод, читающий текстовый файл и возвращающий строку, состоящую из строчек этого файла.
     */
    public static String readFile (String fileName) {
        StringBuilder resStr = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
           String string;
            while ((string = br.readLine()) != null){
                resStr.append(string).append("\n");
            }/*  вместо метода  .append("\n"); перенос на новую строку можно сделать
                   resStr.append(System.lineSeparator()) -  перевод на новую строку
                   .newLine()
           */


        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return resStr.toString();

    }

    public static void main(String[] args) {

        System.out.println(readFile("example.txt"));


    }




}
