package Opgaver;

import java.util.Scanner;

public class Opgave1 {
    public static void main(String[] args) {
        /*
        Prompt user for amount
        Calculate tax (0.06) amount from amount
        return amount
         */

        Scanner input = new Scanner(System.in);
        double taxRate = 0.06;

        System.out.println("Type your purchase amount");
        double amount = input.nextDouble();
        double tax = amount*(taxRate);
        System.out.printf("Your purchase included %.2f as tax", tax);

    }
}
