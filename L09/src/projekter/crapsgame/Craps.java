package projekter.crapsgame;

import java.util.Scanner;

public class Craps {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("play? ('no' stops) ");
        String answer = scanner.nextLine();
        if (!answer.equals("no"))
            playCraps(scanner);



    }

    public static boolean rollForPoint(Scanner scanner, int point) {


        for (String answer = scanner.nextLine(); !answer.equals("no"); answer = scanner.nextLine()) {
            int roll = sumDice(rollDice());

            if (roll == point)
                return true;
            else if (roll == 7)
                return false;
            System.out.println("You rolled " + roll);

            System.out.println("roll again? ('no' stops)");
        }
        return false;
    }

    public static boolean playCraps(Scanner scanner) {
        int[] faces = rollDice();
        int point = sumDice(faces);


        switch (firstRoll(point)) {
            case 0 -> {
                System.out.println("You rolled " + point + ". You won!");
                return true;
            }
            case 1 -> {
                System.out.println("You rolled " + point + ". So you lost :c");
                return true;
            }
            case 2 -> {
                System.out.println("You rolled " + point + ". Roll it again and you win, roll 7 and you lose");
                System.out.println("roll again? ('no' stops)");
                if (rollForPoint(scanner, point))
                    System.out.println("You rolled " + point + " again! You won!");
                else
                    System.out.println("You rolled " + 7 + ", So you lost :c");

            }
        }
        return false;

    }

    private static int firstRoll(int sum) {

        return switch (sum) {
            case 11, 7 -> 0;
            case 2, 3, 12 -> 1;
            default -> 2;
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
