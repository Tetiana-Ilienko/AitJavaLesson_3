import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main_Serialization {
    /** Сериализация*//* - это процесс преобразования объекта в поток байтов, который может быть сохранен в файле или
    передан через сеть, а затем восстановлен обратно в объект из этого потока байтов. Сериализация полезна, когда вам
    нужно сохранить состояние объекта, чтобы потом его восстановить или передать между разными приложениями.

     В Java сериализация выполняется с использованием интерфейса Serializable. Если класс реализует этот интерфейс,
     то объекты этого класса могут быть сериализованы и десериализованы. В Java объекты могут быть сериализованы в
     байтовый поток с помощью класса *//**ObjectOutputStream*//*, а затем десериализованы с помощью класса */
    /**ObjectInputStream.*//*

     Процесс сериализации и десериализации происходит автоматически, и вам не нужно заботиться о том, как именно это
     происходит. Вот как это выглядит на высоком уровне:

     Сериализация (запись объекта в поток):
     Создайте экземпляр ObjectOutputStream, связанный с потоком вывода (например, файлом или сокетом).
     Вызовите writeObject() для объекта, который вы хотите сериализовать.

     Десериализация (восстановление объекта из потока):
     Создайте экземпляр ObjectInputStream, связанный с потоком ввода (например, файлом или сокетом).
     Вызовите readObject() для восстановления объекта из потока.


     ObjectOutputStream (OutputStream output) -  конструктор

     void writeObject( Object object) - метод класса

     Обратите внимание, что класс Employee должен реализовывать интерфейс Serializable, и его поля также должны быть
     сериализуемыми (или помечены как transient, чтобы исключить их из сериализации).

     Сериализация полезна для сохранения состояния объектов, кэширования данных и передачи объектов через сеть.
     Однако, ее следует использовать осторожно, так как она может вызывать проблемы совместимости между версиями
     приложения, и она может быть не безопасной, если сериализуется ненадежный поток данных.
     */
    public static void main(String[] args) {

        // реализуем класс "public class Employee implements Serializable "

        //  записываем объекты класса в файл(сериализация)
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream ("employee.dat"))){

            Employee employee = new Employee("John",35,5000.0,true);
            outputStream.writeObject(employee);

        }
         catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // прочитаем записанный клас (десиаризация)
        /*
        Для десериализации используется класс ObjectInputStream
        ObjectInputStream (InputStream input) -  конструктор

        readObject(  Object object ) - метод

         */
        try(ObjectInputStream inputStream = new ObjectInputStream( new FileInputStream("employee.dat"))){

            Employee employee =(Employee) inputStream.readObject();
            System.out.println("name: " + employee.name + " age: " + employee.age + " salary: "
                    + employee.salary + " manager? " + employee.isManager);

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }



        //  можно так же делать с листом - записываем в файл(сериализация)

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 50, 2000.0, false));
        employees.add(new Employee("Ann", 25, 5000.0, true));

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            outputStream.writeObject(employees);// записываем лист

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // читаем лист (десериализация)
        List<Employee> newEmployees = new ArrayList<>();
        try(ObjectInputStream inputStream = new ObjectInputStream( new FileInputStream("person.dat"))){
            newEmployees =(ArrayList<Employee>) inputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(newEmployees);


    }
}
