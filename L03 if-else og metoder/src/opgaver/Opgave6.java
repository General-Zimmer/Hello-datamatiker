package opgaver;

import java.util.Scanner;

public class Opgave6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib numbah");
        double number = scanner.nextDouble();

        System.out.println(sign(number));
    }

    public static String sign(double number) {
        if (number < 0)
            return "Negative";
        else if (number == 0)
            return "0";
        else if (number > 0)
            return "Postive";

        return "Something went wrong";
    }
}
