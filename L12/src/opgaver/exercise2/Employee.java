package opgaver.exercise2;

public class Employee {
    // The name of the employee.
    String name;
    // Whether the employee is a trainee or not.
    boolean trainee;

    int age;

    /** Create an employee. */
    public Employee(String name, boolean trainee, int age) {
        this.name = name;
        this.trainee = trainee;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Employee(%s, %s, %d)", name, trainee, age);
    }

    /** Print a description of the employee. */
    public void printEmployee() {
        System.out.println("*******************");
        System.out.println("First name: " + name.split(" ")[0]);
        System.out.println("Last name: " + name.substring(name.lastIndexOf(" ")+1));
        System.out.println("Trainee: " + trainee);
        System.out.println("Age: " + age);
        System.out.println("*******************");
    }

    public void birthday() {
        age++;
    }
}
