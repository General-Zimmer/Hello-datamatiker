package projekter.twodice;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int sum = 0;
    private static int sameEyesCount = 0;
    private static int highestRoll = 0;
    private static final int[] eyes = new int[6];

    public static void main(String[] args) {
        System.out.println("Welcome to the game of RollOneDie");
        printRules();
        System.out.println();

        playTwoDie();

        System.out.println();
        System.out.println("Thank you for playing RollOneDie");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollTwoDice:");
        System.out.println("The player throws two dice as long as he/she wants.");
        System.out.println("=====================================================");
    }

    private static void playTwoDie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll? ('no' stops) ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] faces = rollDice();
            for (int face : faces) {
                System.out.println("Eyes: " + face);
            }
            sumDice(faces);
            System.out.println();



            System.out.print("Roll? ('no' stops) ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        int[] numb = new int[2];
        numb[0] = (int) (Math.random() * 6 + 1);
        numb[1] = (int) (Math.random() * 6 + 1);

        return numb;
    }


    private static void updateStatistics(int[] faces, int tempSum) {
        rollCount++;
        if (faces[0] == faces[1]) sameEyesCount++;
        if (sum > highestRoll) highestRoll = sum;

        for (int face : faces) {
            eyes[face-1]++;
        }

        sum += tempSum;


    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "sum of eyes:", sum);
        System.out.printf("%17s %4d\n", "Roll count:", rollCount);
        System.out.printf("%17s %4d\n", "Same roll count:", sameEyesCount);
        System.out.printf("%17s %4d\n", "Highest Roll:", highestRoll);
        System.out.println("amount of each eye that occured \n        1  2  3  4  5  6");
        System.out.print("amount  ");
        for (int eye : eyes)
            System.out.print(eye + "  ");
        System.out.println();

    }

    private static int sumDice(int[] dice) {
        int sum = 0;
        for (int die : dice) {
            sum += die;
        }
        // Update statistics
        updateStatistics(dice, sum);
        return sum;
    }

}
