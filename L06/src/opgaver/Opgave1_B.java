package opgaver;

import java.util.Scanner;

public class Opgave1_B {
    public static void main(String[] args) {

        a();

    }

    public static void a() {

        Scanner scan = new Scanner(System.in);

        System.out.println("type your dataset and use 0 to indicate it's done");

        int biggest = 0;
        int smallest = 999999999;
        int even = 0;
        int odd = 0;

        for (int number = scan.nextInt();number != 0; number = scan.nextInt()) {

            if (biggest < number)
                biggest = number;

            if (smallest > number)
                smallest = number;

            if (number % 2 == 0)
                even++;

            if (number % 2 != 0)
                odd++;

        }

        System.out.println("Biggest number is " + biggest);
        System.out.println("smallest number is " + smallest);
        System.out.println("there were " + even + " even numbers");
        System.out.println("there were " + odd + " odd numbers");

    }
}
