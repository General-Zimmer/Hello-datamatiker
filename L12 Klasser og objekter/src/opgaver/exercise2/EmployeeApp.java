package opgaver.exercise2;

public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Hans Jensen", true, 25);
        System.out.println("Test: " + e1);
        System.out.println();

        System.out.println("Name: " + e1.name);
        System.out.println("Trainee? " + e1.trainee);
        System.out.println();

        e1.trainee = false;
        e1.printEmployee();
        System.out.println();
        e1.birthday();
        e1.printEmployee();
        System.out.println();
    }


}
