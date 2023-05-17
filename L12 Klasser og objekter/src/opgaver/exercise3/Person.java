package opgaver.exercise3;

public class Person {
    private final String name;
    private String address;
    private int monthlySalary;

    public Person(String name) {
        this(name, null);
    }
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
        this.monthlySalary = 0;
    }

    public double calcYearlySalary() {
        return monthlySalary*12+monthlySalary*0.025;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", monthlySalary=" + monthlySalary +
                '}';
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }


}
