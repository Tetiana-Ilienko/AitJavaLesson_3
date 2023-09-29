import java.io.*;

public class TaskMain {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fileWriter = new FileWriter("readFromConsole.txt")) {
            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(line + "\n");
                fileWriter.flush();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        try (BufferedReader br = new BufferedReader(new FileReader("readFromConsole.txt"))) {

            String line;
            while ((line = br.readLine()) !=null){
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }


}
