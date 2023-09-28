import java.io.FileInputStream;
import java.io.IOException;



public class MainTask {
    /*
    Написать программу, сравнивающую два файла. Программа должна считывать файлы и затем сравнивать содержимое.
    Если найдено отличие, значит файлы не равны и программа выводит на экран соответствующее сообщение.
    Если конец обоих файлов достигается одновременно и отличий не найдено - значит файлы одинаковы

     */

    public static void main(String[] args) {

        String string1 = "C:\\AIT\\Idea\\AitJavaLesson_3\\HomeWorks\\HomeWork_51\\textFirst.txt";
        String string2 = "C:\\AIT\\Idea\\AitJavaLesson_3\\HomeWorks\\HomeWork_51\\textSecond.txt";
        compareFiles(string1,string2);

    }

    public static void compareFiles(String file1, String file2){
        int i,j;

        try(FileInputStream  f1 = new FileInputStream(file1);
            FileInputStream  f2 = new FileInputStream(file2)){
            //  читаем побайтово оба файла - если они не равны, возвращаем false
            do {
                i= f1.read();
                j = f2.read();
                if (i!=j){
                    break;
                }

            }while (i!=-1 && j!=-1);
            if (i!=j){
                System.out.println("Files are different");
            } else {
                System.out.println("Files are equal");
            }


            }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }



}
