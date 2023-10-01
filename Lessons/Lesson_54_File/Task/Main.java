package Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
    Пусть есть текстовый файл такого вида:
    1
    2
    3
    4
    5
    Нужно написать метод, принимающий  файл и возвращающий  сумму всех значений
     */

    public static int sumOfValues(String fileName){
        int resSum = 0;

        try( BufferedReader br = new BufferedReader(new FileReader(fileName)) ){
            String line; // строка, в которую мы бутем считывать из файла
            while ((line = br.readLine()) != null){
                int number = Integer.parseInt(line);

                resSum += number;

            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return resSum;


    }
/*
    2. Написать метод, принимающий текстовый файл, состоящий из нескольких строчек
    разной длины и возвращающий самую длинную строчку
    Пример:
    файл
            aaa
    bbbbbbbbbb
            cc
    вернет метод  bbbbbbbbbb*/

    public static String langStr(File fileName){
        String longest = null;

        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))){
            String line;

            int maxLine = 0;
            while ((line = bf.readLine()) != null)
                if (line.length() > maxLine){
                    maxLine = line.length();
                    longest = line;

                }


        }catch (IOException e){
            System.out.println(e.getMessage());
        } return longest;
    }







}
