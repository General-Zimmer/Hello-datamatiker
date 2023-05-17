package opgaver.first3.exercise1;

import java.util.ArrayList;

public class Person {
    private String name;
    private final String cpr;
    private String phone;
    private ArrayList<Dog> dogs = new ArrayList<>();

    public Person(String name, String cpr, String phone) {
        this.name = name;
        this.cpr = cpr;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cpr='" + cpr + '\'' +
                ", phone='" + phone + '\'' +
                ", dogs=" + dogs +
                '}';
    }

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    public void setDog(Dog dog) {
        this.dogs.add(dog);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpr() {
        return cpr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
