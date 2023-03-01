package projekter.pigsgame;

import java.util.Scanner;

public class Pigs {
    public static void main(String[] args) {
        printRules();

        playPig();

    }
    public static void printRules() {
        System.out.println("Players take turns with a die.");
        System.out.println("On a player's turn they can roll a die as many times as they like.");
        System.out.println("If a roll is a 2, 3, 4, 5, or 6, the player adds that many points to their score for the turn.");
        System.out.println("A player may choose to end their turn at any time and “bank” their points.");
        System.out.println("If a player rolls a 1, they lose all their unbanked points and their turn is over.");

    }


    public static void playPig() {

        int[] playerPoints = new int[2];
        int PointsToWin = 100;

        while (true) {

            // God ide vil være at flytte dem her ind i en metode og lave en array med player classes som holder styr på alt.
            System.out.println("Player 1 plays");
            playerPoints[0] += playRound();
            if (playerPoints[0] >= PointsToWin) {
                System.out.println("Player 1 wins!");
                return;
            }

            System.out.println("Player 2 plays");
            playerPoints[1] += playRound();
            if (playerPoints[1] >= PointsToWin) {
                System.out.println("Player 2 wins!");
                return;
            }

            for (int i = 0; i < playerPoints.length; i++) {
                System.out.println("Player " + (i+1) + " has " + playerPoints[i] + "/" + PointsToWin + " points" );
            }

            System.out.println();

        }
    }

    public static int playRound() {

        Scanner scan = new Scanner(System.in);
        System.out.println("roll? ('no' stops) this will repeat");
        String answer = scan.nextLine();

        int points = 0;

        while (!answer.equals("no")) {

            int roll = rollDie();


            if (roll != 1)
                points += roll;
            else {
                System.out.println("You rolled 1, you lost your points :c \n");
                return 0;
            }

            System.out.println("You rolled " + roll + " Total is now " + points);


            answer = scan.nextLine();
        }
        return points;

    }

    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }
}
