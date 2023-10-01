package Tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task_1 {
    /*
    Пусть есть файл с информацией о товарах в виде строк, например:
    Молоко,2.99
    Хлеб,1.49
    Яйца,1.99
    Напишите метод, который читает этот файл, фильтрует товары с ценой выше определенной суммы (например, 2.0) и
    возвращает список таких товаров, отсортированный по цене.

     */
    public static void main(String[] args) throws IOException {
        File file = new File("product.txt");
        file.createNewFile();
        System.out.println(file.isFile());
        System.out.println(sortProducts("product.txt"));


    }


    public static List<Products> sortProducts(String filename) {
        List<Products> products = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                temp.add(line);

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        for (String str : temp) {
            String[] namePrice = str.split(",");
            double price = Double.parseDouble(namePrice[1].trim());
            if (price>2.0){
                products.add(new Products(namePrice[0],price ));
            }

        }
        Collections.sort(products);
        return products;

    }


}
