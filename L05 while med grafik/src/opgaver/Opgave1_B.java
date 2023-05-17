package opgaver;

import java.util.Scanner;

public class Opgave1_B {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("type your dataset and use 0 to indicate it's done");
        int number = scan.nextInt();
        int total = 0;
        while (number != 0) {

            total += number;
            System.out.print(total + " ");

            number = scan.nextInt();
        }
        System.out.println();
    }
}
