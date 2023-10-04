import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private int age;
    private  int id;
    private transient String address; //  если мы не хотим сериализировать данное поле - используем  'transient' adresse

    private transient boolean previousEducation;


    public Student(String name, int age, int id, String address, boolean previousEducation) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.address = address;
        this.previousEducation = previousEducation;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public boolean isPreviousEducation() {
        return previousEducation;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", address='" + address + '\'' +
                ", previousEducation='" + previousEducation + '\'' +
                '}';
    }
}
