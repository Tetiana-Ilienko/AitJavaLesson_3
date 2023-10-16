package Exempl;

public class Bus {

    /*
    Написать программу, которая будет хранить количество пассажиров автобуса, курсирующего между терминалом аэропорта
    и самолетом. Пусть автобус ходит по рабочим дням 10 раз в день а выходные 2 раза

     */
    public static void main(String[] args) {
        /*
         создаем такой двумерный массив, в котором количество строк(первый индекс) соответствует  количеству дней
         недели когда ходит автобус, а второй индекс( количество элементов каждого массива) соответствует количеству
         поездок в день. В будние дни -10, в выходные 2

         */

        int [][] rides = new int[7][];
        rides[0] = new int[10];
        rides[1] = new int[10];
        rides[2] = new int[10];
        rides[3] = new int[10];
        rides[4] = new int[10];
        rides[5] = new int[2];
        rides[6] = new int[2];



// заполнить массив данными( количество пассажиров на каждом рейсе)
        for (int i = 0; i < 5; i++){
            for(int j = 0; j < 10;j++){
                rides[i][j] = i + j +10; //  количество пассажиров на каждом рейсе, заданное случайным образом
            }
        }

        for (int i = 5; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                rides[i][j] = i+ j + 10;

            }

        }
        System.out.println("Passengers per trip during weekdays");
        for (int i = 0; i < 5; i++){
            for(int j = 0; j < 10;j++){
                System.out.print(rides[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Passengers per trip on weekends");

        for (int i = 5; i < 7;i++){
            for(int j = 0; j < 2;j++){
                System.out.print(rides[i][j] + " ");
            }
            System.out.println();
        }











    }
}
