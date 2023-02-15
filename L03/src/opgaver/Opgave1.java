package opgaver;

import java.util.Scanner;

public class Opgave1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib numbah");
        double number = scanner.nextDouble();

        if (number < 0)
            System.out.println("Negative");
        else if (number == 0)
            System.out.println("0");
        else if (number > 0)
        System.out.println("Postive");
    }
}
