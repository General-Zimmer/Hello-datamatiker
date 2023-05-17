package demo23y;

import java.util.Arrays;
import java.util.Scanner;

public class AnalyzeNumbersMlch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of items (>= 1): ");
        int n = input.nextInt();

        // create array
        double[] numbers = new double[n];
        // print array
        System.out.println("\tnumbers is " + Arrays.toString(numbers));

        // fill array with numbers
        System.out.print("Enter " + n + " numbers: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextDouble();
        }
        // print array
        System.out.println("\tnumbers is " + Arrays.toString(numbers));

        // compute sum of numbers in array
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("\tsum is " + sum);

        double average = sum / n;
        System.out.println("Average is " + average);

        // count of elements in array about average
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] > average) count++;
        }
        System.out.println("Number of elements above the average is " + count);

        // The 'numbers' variable does not contain numbers,
        // it contains a REFERENCE to the array with numbers.
    }
}