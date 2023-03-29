package opgaver.opgave1;

import java.util.Scanner;

public class KristianZApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Indtast navn: ");
        String name = scan.nextLine();

        System.out.println("Indtast løn: ");
        double salery = scan.nextDouble();

        System.out.println("Indtast alder: ");
        int age = scan.nextInt();

        if (age >= 50) {
            double newSalery = salery*1.1;
            System.out.println(name + " din nye løn er: " + newSalery);
        }

        else if (age <= 35) {
            double newSalery = salery*1.05;
            System.out.println(name + " din nye løn er: " + newSalery);
        }
        else {
            double newSalery = salery*1.08;
            System.out.println(name + " din nye løn er: " + newSalery);
        }
    }
}
