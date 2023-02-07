package Opgaver;

import java.util.Scanner;

public class Opgave3Udvidelse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Take a guess");
        int guess = scanner.nextInt();

        //int lottery = (int) (Math.random()*100) * (int) (Math.random()*100);
        int lottery = 689;
        System.out.println(lottery);

        int reverse = 0;
        int length = Integer.toString(lottery).length();
        int copyLottery = lottery;
        for (int i = length; i >= 1; i--) {

            int temp = (copyLottery % 10) * (int) Math.pow(10, i-1);
            copyLottery /= 10;

            reverse += temp;
        }


        if (guess == lottery)
            System.out.println("YOU WIN $10.000");
        else if (guess == reverse)
            System.out.println("YOU WIN $3.000");
        else if (isOneDigitIdentical(guess, lottery))
            System.out.println("YOU WIN $1.000");
        else
            System.out.println("YOU WIN NOTHING!");



    }

    public static boolean isOneDigitIdentical(int guess, int lottery) {

        int lotLength = Integer.toString(lottery).length();
        int guessLength = Integer.toString(guess).length();
        for (int x = 0; x < lotLength; x++) {
            int lotteryDigit = (lottery/(int)Math.pow(10, x)) % 10;

            for (int y = 0; y < guessLength; y++) {
                int guessDigit = (guess/(int)Math.pow(10, y)) % 10;
                if (lotteryDigit == guessDigit) return true;
            }


        }
        return false;
    }
}
