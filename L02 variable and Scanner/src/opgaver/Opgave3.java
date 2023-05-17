package opgaver;

import java.util.Scanner;

public class Opgave3 {
    public static void main(String[] args) {
        // Prompt for 2 numbers
        // sort them in ascending order
        // Return numbers

        Scanner input = new Scanner(System.in);

        System.out.println("Give first number");
        double firstNum = input.nextDouble();
        System.out.println("Give second number");
        double secNum = input.nextDouble();

        if (firstNum > secNum)
            System.out.println(secNum + " " + firstNum);
        else
            System.out.println(firstNum + " " + secNum);

    }
}
