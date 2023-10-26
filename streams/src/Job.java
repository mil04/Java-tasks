import java.io.Serializable;

public class Job implements Serializable {
    public String name;
    public double salary;

    public Job(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ", " + salary;
    }
    public Job(){

    }
}