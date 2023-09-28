public class Person {

    private String name;



    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String personString){
        String[] personData = personString.split(",");
        if(personData.length<2){
            throw new PersonCreateException();
        }else {
            try{
            this.age = Integer.parseInt(personData[1]);
            this.name = personData[0];
        }catch (Exception e){
                throw new PersonCreateException();
            }
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
