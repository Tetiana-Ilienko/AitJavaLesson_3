package Data_IOS;

import java.io.*;

public class DataIOS_Theory {


    // DataOutputStream
    // DataInputStream  -
    // для работы с данными примитивных типов

    /**DataOutputStream*/
        /*
        writeBoolean()
        writeByte
        writeChar
        writeInt
        writeDouble
        writeShort
        writeFloat
        writeUTF(String string) - записывает строку в кодировке UTF-8*/

       /** DataInputStream*//*
         те же методы только  read

         */
       public static void main(String[] args) {

           Employee jack = new Employee("Jack", 45,2000.5,true);
           // записываем объект
           try(DataOutputStream dos = new DataOutputStream( new FileOutputStream("employee.txt"))){
               dos.writeUTF(jack.name);
               dos.writeInt(jack.age);
               dos.writeDouble(jack.salary);
               dos.writeBoolean(jack.isManager);
           } catch (IOException e){
               System.out.println(e.getMessage());
           }

           // считывание объекта

           try(DataInputStream dis = new DataInputStream(new FileInputStream("employee.txt"))) {

               String name = dis.readUTF();
               int age = dis.readInt();
               double salary = dis.readDouble();
               boolean isManager = dis.readBoolean();
               System.out.println("name: " + name + ", age: " + age + ", salary: " + salary + ", isManager " + true);



           }catch (IOException e){
               System.out.println(e.getMessage());
           }


       }

}
