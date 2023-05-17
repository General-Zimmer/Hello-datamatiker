package bookchapter2;

import java.util.Scanner;

public class Opgave6 {
    public static void main(String[] args) {
        /*
        Prompt for number
        use % 10 to extract the last digit and add them all together
        return number
        */
        Scanner input = new Scanner(System.in);

        System.out.println("Gib numbah");
        int number = (int) input.nextDouble();

        int length = Double.toString(number).length();

        int newNumber = 0;
        for (int i = 0; i < length; i++) {
            newNumber += number % 10;
            number /= 10;
        }

        System.out.println(newNumber);
    }
}
