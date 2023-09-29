import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MainCharSreams {

    /**  ввод-вывод текстовой информации*//*
    /*
    Reader, Writer -  абстрактные классы, лежащие в основе иерархии классов работающих
     с вводом-выводом символьной информации*/

    /** Reader - отвечает за чтение*//*

    int read() -  возвращает текущий символ потока ( целочисленное его представление).
                    и -1 если символов нет

    int read( char[] data) -  считывает в массив data  символы из потока и возвращает количество
                             считанных символов. В конце возвращает -1

    int read( char[]data, int index, int number)

    close()
    skip( long count) - пропускает количество символов count*/


    /**Writer -  базовый класс всех символьных потоков работающих на вывод*//*

    методы:

    void write( int ch)

    void write(char[] chars)

    abstract void write( char[] chars, int index, int number)

    close()

    append( char ch) -  в конец выходного потока добавляет символ (ch)

    append( CharSequence chars) - добавляет набор символов chars*/


    public static void main(String[] args) {
        /****** класс FileWriter запись в файл ********//*
      конструкторы:
         FileWriter( String fileName)
         FileWriter( String fileName, boolean append)
         FileWriter( File fileName)
         FileWriter( File fileName,boolean append)

     */

        try(FileWriter writer = new FileWriter("exampleChar.txt",true))
        {
            String word = " hello everybody!";
            writer.write(word); //  вызываем метод, записывающий строку
            writer.append('\n'); // добавляем в файл символы...
            writer.append('J');
            writer.append('a');

            writer.flush(); // принудительно сбросить все, что осталось в потоке

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

       /**   класс FileReader чтение текстовых файлов ****//*
        конструкторы:
        FileReader( String fileName)
        FileReader ( File file)
        */

        try(FileReader reader = new FileReader("exampleChar.txt"))
        {
            int ch;
            while ((ch = reader.read()) != -1){
                System.out.print((char)ch);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }


        /*****  with array  ******/

        try( FileReader reader = new FileReader("exampleChar.txt"))
        {
            char[] data = new char[512];

            int counter;

            while((counter = reader.read(data)) > 0){

                if(counter < 512){
                    data = Arrays.copyOf(data,counter);
                }
                System.out.print(data);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
