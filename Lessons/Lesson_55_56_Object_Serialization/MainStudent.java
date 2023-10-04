import java.io.*;

public class MainStudent {

    public static void main(String[] args) {
        Student student = new Student("John", 20, 005, "Boston", false);


        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("students.ser"));

            outputStream.writeObject(student);
            outputStream.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Student johnDecerialized = null;

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("students.ser"));
            johnDecerialized = (Student) inputStream.readObject();
            inputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return;

        }

        System.out.println(johnDecerialized.getAddress()); //  так как в настройках этого поля указали 'transient'
        // это поле не сериализируется // null
        System.out.println(johnDecerialized.getName()); // John


    }
}
