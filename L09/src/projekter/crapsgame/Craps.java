package projekter.crapsgame;

import java.util.Scanner;

enum Outcome {
    win, loss, tieBreaker;
}
public class Craps {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("play? ('no' stops) ");
        String answer = scanner.nextLine();
        if (!answer.equals("no"))
            playCraps(scanner);

    }


    public static void playCraps(Scanner scanner) {
        int[] faces = rollDice();
        int point = sumDice(faces);


        switch (firstRoll(point)) {
            case win -> System.out.println("You rolled " + point + ". You won!");
            case loss -> System.out.println("You rolled " + point + ". So you lost :c");
            case tieBreaker -> {
                System.out.println("You rolled " + point + ". Roll it again and you win, roll 7 and you lose");
                System.out.println("roll again? ('no' stops)");
                if (rollForPoint(scanner, point))
                    System.out.println("You rolled " + point + " again! You won!");
                else
                    System.out.println("You rolled " + 7 + ", So you lost :c");

            }
        }


    }

    public static boolean rollForPoint(Scanner scanner, int point) {


        for (String answer = scanner.nextLine(); !answer.equals("no"); answer = scanner.nextLine()) {
            int roll = sumDice(rollDice());

            // Win
            if (roll == point)
                return true;
            // Loss
            else if (roll == 7)
                return false;

            // Reroll
            System.out.println("You rolled " + roll);

            System.out.println("roll again? ('no' stops)");
        }
        return false;
    }

    private static Outcome firstRoll(int sum) {

        return switch (sum) {
            // win
            case 11, 7 -> Outcome.win;
            // loss
            case 2, 3, 12 -> Outcome.loss;
            // Tiebreaker
            default -> Outcome.tieBreaker;
        };

    }

    private static int[] rollDice() {
        int[] numb = new int[2];
        numb[0] = (int) (Math.random() * 6 + 1);
        numb[1] = (int) (Math.random() * 6 + 1);

        return numb;
    }
    private static int sumDice(int[] dice) {
        int sum = 0;
        for (int die : dice) {
            sum += die;
        }
        return sum;
    }
}
