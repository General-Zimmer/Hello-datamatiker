package opgaver;

import java.util.Scanner;

public class Opgave7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("gib 3 numbers with spaces between");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        System.out.println(order(num1, num2, num3));
    }

    public static String order(int num1, int num2, int num3) {
        if ((num1 < num2 && num1 < num3) && num2 < num3)
            return "Voksende";
        else if ((num1 > num2 && num1 > num3) && num2 > num3)
            return "aftagende";
        else
            return "Hverken-eller";
    }
}
