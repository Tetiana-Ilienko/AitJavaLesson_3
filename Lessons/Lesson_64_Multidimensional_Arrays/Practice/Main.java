package Practice;

public class Main {


    public static void main(String[] args) {
        System.out.println("Task 1");
        int[][] arr1 = {
                //0  1  2
                {11, 22, 33}, //arr[0]
                {44, 55}, //arr[1]
                {77, 88, 99, 45, 67, 8, 9}  // arr[2]
        };

        System.out.println(findSumOfNsubArray(arr1, 1));

        System.out.println("Task 2");
        int[][] table = {{1, 4, -5}, {-1, -1, -1, 2, 1}, {-1, 10}};
        summNull(table);

        System.out.println("Task 3");
        int[][] table1 = { {1,4,5},{-1,-1,-1,2,1},{-1,10},{0,2,5}};
        System.out.println(withoutMinus(table1));

        System.out.println("Task 4");
        int[][] table2 = { {3,4,5,8},{6,7},{3,10}};
        System.out.println(evenNumbers(table2));


    }

    /* 1.Написать метод, находящий сумму всех значений заданного подмассива n двумерного массива целых чисел.
     public int findSumOfNsubArray( int[][]ints, int n)

     */
    public static int findSumOfNsubArray(int[][] ints, int n) {
        int summ = 0;

        for (int i = 0; i < ints[n].length; i++) {
            summ += ints[n][i];

        }
        return summ;

    }

    /*
     2. Написать метод, принимающий двумерный массив целых чисел и  выводящий на экран номер строки (подмассива),
        сумма всех элементов которого рана нулю
        int[][] table = { {1,4,-5},{-1,-1,-1,2,1},{-1,10}} -> 0,1
     */

    public static void summNull(int[][] ints) {

        for (int i = 0; i < ints.length; i++) {

            if (findSumOfNsubArray(ints, i) == 0) { // использую метод из первой задачи
                System.out.print(i + " ");
                ;
            }
        }
        System.out.println();


    }
    /*
    3.  Написать метод, принимающий двумерный массив целых чисел и возвращающий количество строк( подмассивов), в которых
     нет отрицательных элементов
     int[][] table = { {1,4,5},{-1,-1,-1,2,1},{-1,10}} -> 1
     */

    public static int withoutMinus(int[][] ints) {

        int counter = 0;

        for (int i = 0; i < ints.length; i++) {
            int inCounter = 0;
            for (int j = 0; j < ints[i].length; j++) {
                if(ints[i][j] < 0){
                    inCounter++;

                }

            }  if(inCounter==0) counter++;

        }
        return counter;

    }

     /*
     4. Написать метод, принимающий двумерный массив целых чисел и возвращающий количество четных чисел в нем
            int[][] table = { {3,4,5},{6,7},{3,10}} -> 3
     */

    public static int evenNumbers(int[][] ints){
        int counter = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {

                if(ints[i][j]%2==0) counter++;

            }

        } return counter;
    }


}
