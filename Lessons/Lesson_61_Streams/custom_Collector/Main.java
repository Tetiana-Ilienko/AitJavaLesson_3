package custom_Collector;

import Task_3.Person;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Main {

     /*
    Пусть есть класс Employee с переменными String name и int salary.
    Нужно написать свой коллектор, считающий суммарную зарплату всех сотрудников.
     */

    public static void main(String[] args) {
        Employee e1 = new Employee("John", 1500);
        Employee e2 = new Employee("Peter", 1800);
        Employee e3 = new Employee("Mary", 2600);
        Employee e4 = new Employee("Helen", 1000);


        //создаем поставщика (Supplier), который, когда вызывается, выводит сообщение в консоль
        // и возвращает новый объект Box с начальным значением 0.
        Supplier<Box> supp = () -> {
            System.out.println("Supplying starting value");
            return new Box(0);
        };
         // пишем метод, который будет аккумулировать(накапливать значения)
        BiConsumer<Box, Employee> accumulator = (result, employee) -> {
            result.setValue(result.getValue()+ employee.getSalary());
            System.out.println(result.getValue() + " " + employee.getName());
        };

        // принимает два результата и соединяет их
        BinaryOperator<Box> combiner = (res1, res2) -> {
            System.out.println("Combining results");
           res1.setValue(res1.getValue() + res2.getValue());
           return res1;
        };

        Collector<Employee,Box,Box> salaryCollector = Collector.of(
                supp,
                accumulator,
                combiner
        );

       Box box = Stream.of(e1,e2,e3,e4)
                .parallel()
                .collect(salaryCollector);

        System.out.println("Total salary " + box);





    }
}
