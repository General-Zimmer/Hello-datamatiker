package opgaver;

import java.util.Scanner;

public class Opgave3_c {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("type your dataset and use 0 to indicate it's done");
        int number = scan.nextInt();
        int biggest = 0;
        int count = 0;

        while (number != 0) {

            if (biggest < number) {
                biggest = number;
                count = 0;
            }

            if (biggest == number)
                count++;



            number = scan.nextInt();
        }

        System.out.println("Biggest number is " + biggest + " and it occured " + count);

    }
}
