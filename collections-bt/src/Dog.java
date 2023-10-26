enum Breed {
    DACHSHUND, MONGREL, HUSKY;
}

public class Dog implements Comparable<Dog> {
    private double mass;
    private Breed breed;
    private String name;

    public void getMoreMass() {
        mass += 1;
    }

    public double mass() {
        return mass;
    }

    public Breed breed() {
        return breed;
    }

    public String name() {
        return name;
    }

    public Dog(String name, Breed breed, double mass) {
        this.name = name;
        this.breed = breed;
        this.mass = mass;
    }

    @Override
    public String toString() {
        return name + "(" + breed.name() + ", " + mass + "kg)";
    }

    @Override
    public int compareTo(Dog o) {
        return Double.compare(mass, o.mass);
    }
}