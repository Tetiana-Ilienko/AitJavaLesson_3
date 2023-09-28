import java.io.*;

public class Theory_BufferedInputStream {

    /*
    BufferedInputStream
    BufferedOutputStream
    -  буферизованные потоки
     */

    public static void main(String[] args) {

        /**********  пример BufferedInputStream  *****/
        /*
        BufferedInputStream -   накапливает данные в дополнительном специальном буфере, что позволяет реже обращаться
    к устройству ввода

    Конструкторы :

       BufferedInputStream( InputStream input) //  принимает другой поток, его нельзя подключить
       напрямую к файлу

       BufferedInputStream( InputStream input, int bufferSize)
         */

        String string = "Hello java!";
        byte[] stringBytes = string.getBytes();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(stringBytes);

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream)) {

            int i;
            while (( i = bufferedInputStream.read()) != -1) {
                //     System.out.print((char) i);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /**********  пример BufferedOutputStream  *****/

        //BufferedOutputStream
        //BufferedOutputStream( OutputStream output)
        //BufferedOutputStream( OutputStream output,int size)

        String hello = "Hello123";
        byte[] helloBytes = hello.getBytes();

        //  FileOutputStream fos = new FileOutputStream("test.txt"); ->  делаем в одну строчку
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.txt"))) {

            bos.write(helloBytes);

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }













    }


}
