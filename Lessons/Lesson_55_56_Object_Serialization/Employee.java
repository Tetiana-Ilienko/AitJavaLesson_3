import java.io.Serializable;

public class Employee implements Serializable {

    public  String name;
    public int age;
    public double salary;
    public boolean isManager;

    public Employee(String name, int age, double salary, boolean isManager) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.isManager = isManager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", isManager=" + isManager +
                '}';
    }
}
