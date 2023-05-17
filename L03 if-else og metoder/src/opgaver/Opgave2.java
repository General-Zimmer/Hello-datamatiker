package opgaver;

import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("gib 3 numbers with spaces between");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        if ((num1 < num2 && num1 < num3) && num2 < num3)
            System.out.println("Voksende");
        else if ((num1 > num2 && num1 > num3) && num2 > num3)
            System.out.println("aftagende");
        else
            System.out.println("Hverken-eller");

    }
}
