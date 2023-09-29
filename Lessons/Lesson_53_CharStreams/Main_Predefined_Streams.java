import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Main_Predefined_Streams {
    public static void main(String[] args) throws IOException {

        /** Стандартные стримы ( predefined streams)*/
        // В классе System определены три объекта стримов  - in, out,err
        /*
        эти объекты public, final, static
        System.out - это объект типа output stream  и по умолчанию это консоль
        System.in - стандартный ввод, по умолчанию  консоль ( объект типа InputStream)
        System.err - стандартный вывод для ошибок , по умолчанию консоль

        System.out  и  System.err -  это объекты класса PrintStream
        System.in - объект типа InputStream

        Это байтовые символы*/
        /******   System.in  *****//*
        int read()    -> throws IOException
        int read(byte[] data) ->  throws IOException
        int read ( byte[] data, int start, int max)  -> throws IOException

         */

        // вместо сканера будем пользоваться -> методом read()
        char ch;
        System.out.println("press a key and then ENTER");
        ch = (char) System.in.read();
        System.out.println("you entered " + ch);
        //  это метод не совершенный.

        // 2 вариант
        byte[] data = new byte[10];
        System.out.println("Enter several characters");
        System.in.read(data);
        System.out.println("You entered the following:");
        for( int i = 0; i < data.length;i++)
            System.out.print((char) data[i]);

        /******** System.out   *******/
        //System.out -  обьект класса PrintStream
        System.out.println();

        /*
        некоторые конструкторы класса PrintStream:

        PrintStream(OutputStream output)

        PrintStream(OutputStream output, boolean autoFlush)

        PrintStream(String fileName)

        PrintStream(File fileName)

         методы:
         println()
         print()

         printf()
         Спецификаторы формата в методе printf() используются для определения того,
         какие типы данных будут вставлены в строку-шаблон и как они будут отформатированы. Вот наиболее часто
         используемые спецификаторы формата в Java:*/

         /**  %s: Спецификатор для строк (String)*//*. Вставляет строку в указанное место в форматированной строке.
                    String name = "Alice";
                    int age = 30;

        System.out.printf("Привет, меня зовут %s и мне %d лет.%n", name, age);
        // вывод на консоль
                           Привет, меня зовут Alice и мне 30 лет.*/

         /**  %d: Спецификатор для целых чисел (int).*//* Вставляет целое число в указанное место в форматированной строке.

         */
        // запись не в консоль, а в файл
        String hello = "Hello Java!";

        try(PrintStream printStream = new PrintStream(new FileOutputStream("exemple.txt"))) {
            printStream.println(hello);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        try(PrintStream printStream = new PrintStream("exemple1.txt")) {
            printStream.print("Hello java!");
            printStream.println("Hello java!");

            String word = "print";
            byte[] wordToBytes = word.getBytes();
            printStream.write(wordToBytes);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        }










    }


