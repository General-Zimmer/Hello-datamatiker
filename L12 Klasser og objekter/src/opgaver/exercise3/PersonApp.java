package opgaver.exercise3;

public class PersonApp {
    public static void main(String[] args) {
        Person p1 = new Person("Dan Dansonsen");
        Person p2 = new Person("Mik Mikelsen", "Mikkelsvej");

        //Test
        System.out.println(p1);
        System.out.println(p2);

        // changing variables
        p1.setAddress("Stor Dannysvej");
        p1.setMonthlySalary(9001);
        p2.setMonthlySalary(69420);
        p2.setAddress("Gammel mandsvej");

        // Test
        System.out.println();
        System.out.println(p1);
        System.out.println(p2);


        p1.setMonthlySalary(10);
        p2.setMonthlySalary(100);
        System.out.println(p1.calcYearlySalary());
        System.out.println(p2.calcYearlySalary());

    }
}
