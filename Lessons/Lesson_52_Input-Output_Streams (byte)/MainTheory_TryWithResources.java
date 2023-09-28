import java.io.FileInputStream;
import java.io.IOException;

public class MainTheory_TryWithResources {
    /** Закрытие ресурса с помощью  try, catch и finally*
     *  без использования try-with-resources
     */


    public static void main(String[] args) {

        FileInputStream fileInputStream = null; // объявляем до блока try, чтоб был виден в блоке finally
        try {
            fileInputStream = new FileInputStream("output.txt");

            int i;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println((char) i);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fileInputStream != null) //   так как переменную нужно инициализировать
                    // возможен вариант, что она останеться = null. ПРописываем оператор if
                    fileInputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }


        /** try-with-resources -  при использовании - метод close вызывается автоматически*/

        try (FileInputStream fileInputStream1 = new FileInputStream("output.txt")) {

            int i;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println((char) i);
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
