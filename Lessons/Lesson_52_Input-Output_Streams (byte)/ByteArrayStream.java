import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStream {

    /**
     * ByteArrayInputStream
     * ByteArrayOutputStream
     * - это классы, которые используются при работе с массивами байтов
     * <p>
     * <p>
     * ByteArrayInputStream - источник данных массив байтов
     * <p>
     * конструкторы:
     * ByteArrayInputStream( byte[] array)
     * ByteArrayInputStream( byte[] array, int index, int number)
     */
    public static void main(String[] args) {
        byte[] bytes = new byte[]{1, 2, 3, 4};

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes); // чтение

        int by;
        while ((by = byteArrayInputStream.read()) != -1) {
            System.out.println(by);
        }

        /** ByteArrayOutputStream -  массив байтов в данном случае используется как приемник данных
         /*
         конструкторы:
         ByteArrayOutputStream()
         ByteArrayOutputStream(int size)
         */


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();// запись

        String str = "Hello Java ";
        byte[] strBytes = str.getBytes();

        try {
            byteArrayOutputStream.write(strBytes);
        } catch (IOException e){
            System.out.println(e.getMessage());

        }
        /** Работа с записанным массивом*/

        System.out.println(byteArrayOutputStream.toString()); // перевести в строку

        byte[] ourArr = byteArrayOutputStream.toByteArray(); // вывод посимвольно
        for (byte b : ourArr){
            System.out.println((char) b);
        }


        /** writeTo   с помощью этого метода можно вывести данные в другой поток*/

        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();

        String hello = "hello!"; //  строку
        byte [] helloBytes = hello.getBytes();// прекращаем в массив байтов

        try {
            byteArrayOutputStream1.write(helloBytes); // записывыем
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        // теперь мы хотим этот файл не вывести, а поместить во внешний файл
        try
            (FileOutputStream fos = new FileOutputStream("text.txt")){ // создаем файл
             //
                byteArrayOutputStream.writeTo(fos);
            }catch (IOException e){
            System.out.println(e.getMessage());
        }




    }


}
