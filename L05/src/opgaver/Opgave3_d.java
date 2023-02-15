package opgaver;

import java.util.Scanner;

public class Opgave3_d {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("type your dataset and use 0 to indicate it's done");
        int number = scan.nextInt();
        String storage = "";
        int tempNumb = 0;
        int lastSolution = 0;

        while (number != 0) {

            if (number == tempNumb && lastSolution != number) {

                storage += number + " ";
                lastSolution = number;
            }
            tempNumb = number;

            number = scan.nextInt();
        }

        System.out.println("recurring numbers are " + storage);

    }
}
