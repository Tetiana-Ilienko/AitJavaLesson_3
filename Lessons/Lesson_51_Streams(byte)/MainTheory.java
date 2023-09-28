import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainTheory {


    /** IO Streams (Ввод-вывод)*/
    /* Понятие потока (абстракция) является в данном случае ключевым.Обьект, из которого считываются данные -
    это поток ввода, а обьект в который записываются данные - поток вывода.

    Все классы, работающие с вводом-выводом делятся на две большие группы - классы, работающие с байтами и классы, работающие
    с символами.
    В основе всех классов, работающих с байтами лежат два абстрактных класса - InputStream  и OutputStream,
    а классов, которые работают с символами - Reader, Writer


     /*В Java есть два основных базовых класса для работы с потоками ввода-вывода:*/

    /**Reader и Writer:*/
     /*Эти классы также предоставляют абстракцию для чтения и записи данных, но они работают с
     символами вместо байтов. Это удобно при работе с текстовыми данными, такими как файлы с кодировками, или при
     работе с символьным вводом-выводом.*/


    /**InputStream и OutputStream:*/
     /*Эти классы предоставляют базовый функционал для чтения и записи байтовых данных.
     Они являются абстрактными классами и имеют различные конкретные реализации для работы с разными источниками и
     приемниками данных, такими как файлы, массивы байтов, сетевые соединения и другие.*/
    /************  методы InputStream: (байтовые потоки ввода (чтения))   ****************//*
     void close()  - закрывает поток

     int read() - возвращает текущий байт из потока (целочисленное представление)
                  когда байтов в потоке не остается, метод вернет -1
     int read ( byte[] buffer ) - считывает байты из потока в буферный массив.*/
              /** Возвращает число считанных байтов*//*. если ничего не считано - вернет -1
     int read ( byte[] buffer, int index, number ) -
            buffer - это массив байтов, в который записываются считанные байты
            index  - индекс массива byte[] buffer, начиная с которого записываются байты
            number - количество байтов, которое нужно записать
     skip ( long number ) - пропускает при чтении количество байтов равное number
     available () - возвращает количество байтов, доступных для чтения

     */
    /************* методы OutputStream: (байтовые потоки вывода (записи))  **************************//*
    void close()  - закрывает поток

    void flush() - сбрасывает содержимое буфера вывода в поток

    void write( int byte) -  записывает в выходной поток один байт
    void write( byte [] buffer) -  записывает в выходной поток массив buffer
    void write( byte [] buffer, int index, number ) -
            buffer - это массив байтов
            index  - индекс массива byte[] buffer, начиная с которого записываются байты
            number - количество байтов, которое нужно записать
    */
    /** FileOutputStream*//*  - не абстрактный класс, используется для записи байтов в файл. Наследует класс OutputStream.

     Подключается через конструкторы:
     FileOutputStream (String fileName ) - может принимать также путь файля

     FileOutputStream (File file) может принимать объект класса файл
            //File newFile = new File("text.txt");

     FileOutputStream (String fileName, boolean append)
      если append = true , данные добавляются в конец файла
      append = false , файл перезаписывается полностью
     */

    /**
     * FileInputStream
     *//* - используется для чтения файлов
        FileInputStream ( String fileName) -  конструктор
    */
    public static void main(String[] args) {


        /************ Пример FileOutputStream  ******************/

        String str = "Hello Java";
        try (FileOutputStream fileOutputStream = new FileOutputStream("output.txt")) { // конструктор +
            // блок обрабатывающий ошибки

            byte[] buffer = str.getBytes();// превращаем нашу строку в массив байтов buffer, в который записывается кодировка
            // строки "Hello Java" (обычно UTF-8). Этот массив будет использоваться для записи данных в файл.

            fileOutputStream.write(buffer, 0, buffer.length);
            System.out.println("Wir haben das gemacht!");
            // при такой записи - поток закрывается автоматически
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /************ Пример FileInputStream  ***************/

        try (FileInputStream fileInputStream = new FileInputStream("output.txt")) {
            int i;// переменная в которую мы считываем байт
            while ((i = fileInputStream.read()) != -1) {
                System.out.print((char) i);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /************ Пример чтение в буферный массив  ***************/
        System.out.println();
        System.out.println(" Reading in buffer array:");

        try (FileInputStream fin = new FileInputStream("output.txt")) {
            byte[] buffer = new byte[512]; // создаем буферный массив

            int counter; // переменная в которую мы считываем байты
            while ((counter = fin.read(buffer)) != -1){ // количество байтов записывается в
                // counter, а а сам файл в buffer
                for (int i = 0; i < counter; i++) { // чтобы не считывать пустые байты
                    // делаем еще один цикл, который считает записанный массив до counter
                    System.out.print((char)buffer[i]);

                }
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        /************ Пример чтение  и запись   ***************/
        // Создаем два объкта - один будет читать из файла output.txt и записывать в новый файл

        try(FileInputStream fileInputStream = new FileInputStream("output.txt"); // считывает
            FileOutputStream fileOutputStream = new FileOutputStream("newOutput.txt")) { // записывает
            byte[] buffer = new byte[512];

            int counter;
            while ((counter = fileInputStream.read(buffer)) != -1){ // считываем байты в массив buffer
                fileOutputStream.write(buffer,0,counter); // записываем этот массив от 0 до counter (сколько удалось считать)
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }






}
