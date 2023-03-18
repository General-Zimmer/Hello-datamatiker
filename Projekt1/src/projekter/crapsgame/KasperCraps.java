package projekter.crapsgame;

import java.util.Scanner;

public class KasperCraps {

    public static void main(String[] args) {
        System.out.println("Welcome to the game of CRAPS!");

        printRules();
        playCraps();

        System.out.println();
        System.out.println();
        System.out.println("Thank you for playing Craps you beautiful boy");


    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Craps:");
        System.out.println("The player throws two dice");
        System.out.println("if first roll: 7 or 11 = you win!");
        System.out.println("if first roll: 2, 3 or 12 = you lose!");
        System.out.println("If first roll: 4, 5, 6, 8, 9 or 10 = point");
        System.out.println("If secound roll: 7 = you lose!");
        System.out.println("If secound roll: same is your point = you win!");
        System.out.println("=====================================================");

    }

    public static void playCraps() {
        Scanner input = new Scanner(System.in);
        System.out.println("Roll the dice: ");
        input.nextLine();

        int point = sumDice(rollDice());
        System.out.println("Your roll is: " + point);

        if (point == 7 || point == 11) {
            System.out.println("YOU WIN!!!");
        }
        if (point == 2 || point == 3 || point == 12) {
            System.out.println("YOU LOSE!!!");

        } else if (point == 4 || point == 5 || point == 6 || point == 8 || point == 9 || point == 10) {
            System.out.println("YOU HIT POINTS!");

            rollforPoint(point);
        }




    }

    public static int sumDice(int[] dice) {
        int sum = 0;
        for (int die : dice) {
            sum += die;
        }
        return sum;
    }

    public static int[] rollDice() {

        int[] terning = new int[2];
        terning[0] = (int) (Math.random() * 6 + 1);
        terning[1] = (int) (Math.random() * 6 + 1);

        return terning;
    }


    public static boolean rollforPoint(int point) {

        boolean won = true;
        boolean keepGoing = true;

        while (keepGoing) {

            //rollDice();
            Scanner input = new Scanner(System.in);
            System.out.println("Roll the dice: ");

            input.nextLine();
            int score = sumDice(rollDice());
            System.out.println("Your roll is: " + score);

            if (score == point) {
                System.out.println("YOU WIN!!!");
                keepGoing = false;

            }
            else if (score == 7) {
                System.out.println("YOU LOSE!!!");
                keepGoing = false;
                won = false;



            }
        }

        return won;
    }
}