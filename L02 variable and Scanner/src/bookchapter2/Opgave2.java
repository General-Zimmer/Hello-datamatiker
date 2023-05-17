package bookchapter2;

import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {
        /*
        Prompt user for length
        Calculate area and volume
         */

        Scanner input = new Scanner(System.in);

        System.out.println("Give length of the equilateral triangle sides");
        double sideLength = input.nextDouble();

        double area = (Math.sqrt(3)/4)*sideLength;
        double volume = area*sideLength;

        System.out.println("The area of the triangle is: " + area);
        System.out.println("The volume of the prism is: " + volume);
    }
}
