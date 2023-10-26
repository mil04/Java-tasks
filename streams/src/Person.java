import java.io.Serializable;

public class Person implements Serializable {
    public String name;
    public String surname;
    public transient int age;
    public Job job;
    public Person(String name, String surname, int age, Job job) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.job = job;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + age + " years old)" + ". Job: " + job;
    }
    public Person(){

    }
}