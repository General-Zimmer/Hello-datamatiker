package bookchapter2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Listing2 {

    public static void main(String[] args) {

        boolean run = true;
        while (run) {
            Scanner input = new Scanner(System.in);


            System.out.println("Give me numbah");
            double number;

            try {
                number = input.nextDouble();

            } catch (InputMismatchException e) {
                System.out.println("no workie");
                continue;
            }

            if (number == 0.0)
                run = false;
            else
                System.out.println(number);

        }
    }

}
