package projekter.twodice;

import java.util.Scanner;

public class MartinTwoDice {

    private static int rollCount = 0;

    private static int sum = 0;

    private static int biggestCount = 0;

    private static int sameEyesCount = 0;
    private static final int[] eyeAmount = new int[6];

    public static void main(String[] args) {
        System.out.println("Welcome to the game of RollTwoDice");
        printRules();
        System.out.println();

        playTwoDice();

        System.out.println();
        System.out.println("Thank you for playing RollTwoDice");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollTwoDice:");
        System.out.println("The player throws two dice as long as he/she wants.");
        System.out.println("=====================================================");
    }

    private static void playTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll? ('no' stops) ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] faces = rollDice();
            for (int face : faces) {
                System.out.println("Eyes: " + face);
            }
            System.out.println();
            sumD(faces);






            System.out.print("Roll? ('no' stops) ");
            answer = scanner.nextLine();
        }



        printStatistics();
        scanner.close();
    }

    public static int sumD(int[] dice) {
        int sum = 0;
        for (int number : dice) {
            sum += number;
        }
        updateStatistics(dice, sum);
        return sum;

    }


    private static int[] rollDice() {
        int[] Arr = new int[2];
        Arr[0] = (int) (Math.random() * 6 + 1);
        Arr[1] = (int) (Math.random() * 6 + 1);

        return Arr;
    }

    private static void updateStatistics(int[] face, int tempSum) {
        rollCount++;
        if (face[0] == face[1]) {
            sameEyesCount++;
        }

        tempSum = face[0] + face[1];
        if (tempSum > biggestCount) {
            biggestCount = tempSum;
        }

        for (int number : face) {
            eyeAmount[number - 1] += 1;
        }

        sum += tempSum;

    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Roll count:", rollCount);
        System.out.printf("%17s %4d\n", "Sum count:", sum);
        System.out.printf("%17s %4d\n", "Same Eye count:", sameEyesCount);
        System.out.printf("%17s %4d\n", "Biggest Count", biggestCount);
        System.out.println("1   2   3   4   5   6");
        for (int number : eyeAmount) {
            System.out.print(number + "   ");
        }
    }
}