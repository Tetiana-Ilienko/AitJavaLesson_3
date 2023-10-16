import java.util.Arrays;

public class MultidimensionalArraysMain {
     /*
    Multidimensional arrays -  многомерные массивы
    Two-dimensional arrays -  двумерные массивы
         */
     public static void main(String[] args) {

         int [][] table = new int[10][20];



         int[][] arr = {
                 {11,22,33},
                 {44,55,66},
                 {77,88,99}
         };

         System.out.println(arr[0][0]);
         System.out.println(arr[1][0]);

         System.out.println(Arrays.toString(arr[0]));// [11, 22, 33]
         int[] arrFirst = arr[1];

         // ********   печать массива в цикле  ****************


         for (int i = 0; i < 3; i++) { // внешний цикл от 0 до количества строк

             for (int j = 0; j < 3; j++) { //внутренний цикл от 0 до количества элементов
                 System.out.print(arr[i][j] + "\t");

             }
             System.out.println();


         }

         int [][] num = new int[3][];
         num[0] = new int[4];
         num[1] = new int[3];
         num[2] = new int[100];



         int[][] arr1 = {
                 //0  1  2
                 {11,22,33}, //arr[0]
                 {44,55}, //arr[1]
                 {77,88,99,45,67,8,9}  // arr[2]
         };

         System.out.println(arr1.length);
         System.out.println(arr1[0].length);
         System.out.println(arr1[1].length);
         System.out.println(arr1[2].length);

        print2Dim(arr1);

         //  альтернативное обьявление массива
         int[][] array1;
         int [][] array2;
         int arr3[][];
         int []arr4[];





     }
     public static void print2Dim(int[][] array){
         for (int i = 0; i < array.length; i++) {
             for (int j = 0; j < array[i].length; j++) {
                 System.out.print(array[i][j] +" \t");

             }
             System.out.println();

         }

     }







}
