package opgaver.first3.exercise1;

public class Dog {
    private int number;
    private String name;
    private Person owner;

    public Dog(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", owner=" + owner.getName() +
                '}';
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
