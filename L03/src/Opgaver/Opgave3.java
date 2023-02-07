package Opgaver;

import java.util.Scanner;

public class Opgave3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Take a guess");
        int guess = scanner.nextInt();

        int lottery = (int) (Math.random()*100);
        System.out.println(lottery);

        if (lottery == 100)
            lottery = 99;

        int reverse = 0;
        reverse += (lottery % 10)*10;
        reverse += lottery / 10;



        if (guess == lottery)
            System.out.println("YOU WIN $10.000");
        else if (guess == reverse)
            System.out.println("YOU WIN $3.000");
        else if ((lottery / 10) == guess % 10 || (lottery / 10) == (guess / 10) ||
                (lottery % 10) == (guess % 10) || (lottery % 10) == (guess / 10))
            System.out.println("YOU WIN $1.000");
        else
            System.out.println("YOU WIN NOTHING!");



    }
}
