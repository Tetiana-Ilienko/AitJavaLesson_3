package Task_Price;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Task_55 {
    /*
    Пусть есть файл содержащий следующую информацию
    name,surname (могут повторяться), equipment, price
    Нужно написать метод, который принимает в качестве параметра имя этого файла и записывает информацию в другой файл
    в таком виде:
    name surname sumPrice

    Входной файл:
    Eugene,Black,Notebook,1000
    Peter,White,Mac,800
    Eugene,Black,Keyboard,25
    John,Green,Mauspad,5
    Peter,White,Mobile,600

    Выходной фалй:
    Eugene Black 1025;
    Peter White 1400;
    John Green 5

     */

    public static void writeFileSumPrice(String infile, String outFile) {
        Map<String, Double> persones = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(infile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] fullInfo = line.split(",");//  записываем сразу в массив, разделяя по запятой

                String name = fullInfo[0].trim().concat(" ").concat(fullInfo[1].trim()); // создаем ключ для мапы
                // который будет состоять из двух ячеек массива 0 и 1 (имяб фамилия)
                Double price = Double.parseDouble(fullInfo[3].trim()); // переводим строку в Double

                /*-----  в циклкле обходим мапу
                if (persones.containsKey(name)) { // если такой ключ уже содержиться
                    persones.put(name, price + persones.get(name)); // то к старой цене прибавляем новую
                } else
                    persones.put(name, price); // делаем новый ключ и значение
                 -------------   */

                // та же часть с помощью оператора getOrDefault()
                 double currentValue = persones.getOrDefault(name,0.00); // вызваем по ключу значние, если оно
                // есть - вернется, иначе вернется 0,00
                 double newValue = currentValue + price; // к текущему значению прибавляем новое
                persones.put(name,newValue); // ложем в мапу по ключу новое значение


            } // записываем информацию в файл
            for (Map.Entry<String, Double> me : persones.entrySet()) { // проходим по мапе,
                // так как она не итеребел, по ней идти нельзя используем внутренний класс
                // Map.Entry , предназначенный для представления записей (пар ключ-значение) в Map
                //persones.entrySet(): Это вызов метода entrySet() на persones. entrySet() возвращает множество (набор)
                // записей из persones. Эти записи представляют собой пары ключ-значение из Мар
                bw.write(me.getKey() + ' ' + me.getValue()); // записываем строчку в выходной файл
                bw.newLine();

            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void main(String[] args) {
        String inFile = "inputlist.csv";
        String outFile = "outputlist.csv";

        writeFileSumPrice(inFile,outFile);

    }
}
