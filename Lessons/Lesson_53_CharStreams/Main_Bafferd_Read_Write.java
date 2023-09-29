import java.io.*;

public class Main_Bafferd_Read_Write {
    /*
        BufferedReader
        BufferedWriter
        -  классы, используемые для буферизвции символьных потоков

                  */
    public static void main(String[] args) {

       /** BufferedWriter -  класс, записывающий символы в поток, буфферизуя их предварительно.

        конструкторы (конструктор принимает поток  )
        BufferedWriter( Writer out) -
        BufferedWriter( Writer out, int size)*/


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bufferedEx.txt",true)))
        {
            String sentence = " Hello java and everyone!";
            bufferedWriter.write(sentence);

        }
        catch (IOException exception){
            exception.getMessage();
        }


        /**   BufferedReader -  чтение текста с буферизацией

        BufferedReader(Reader in)
        BufferedReader(Reader in, int size)
         */
        System.out.println("Buffered reader - read");
        try(BufferedReader bufferedReader = new BufferedReader( new FileReader("bufferedEx.txt")))
        {
            int ch;
            while((ch = bufferedReader.read()) != -1){
                System.out.print((char)ch);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        /**  метод readLine() - собственный метод класса BufferedReader  позволяет считывать
         информацию построчно*/

        System.out.println();
        System.out.println("Buffered reader with readLine()");

        try( BufferedReader br = new BufferedReader(new FileReader("bufferedEx.txt"))){

            String str;
            while ((str = br.readLine()) != null){ // читаем сразу строку

                System.out.println(str);
            }

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        /**  чтение с консоли с помощью bufferedReader  и запись этой информации в файл с помощью BufferedWriter*/

        try( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fromConsole.txt")))
        {
            String line;
            while(!(line = bufferedReader.readLine()).equalsIgnoreCase("EXIT")){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
