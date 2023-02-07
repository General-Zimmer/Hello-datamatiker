package Opgaver;

import java.util.Scanner;

public class Opgave4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type the child's age");
        int age = scanner.nextInt();
        System.out.println(institution(age));

    }

    public static String institution(int age) {

        if (age == 0)
            return "Home";
        else if (age == 1 || age == 2)
            return "Nursery";
        else if (age >= 3 && age <= 5)
            return "Kindergarten";
        else if (age >= 6 && age <= 16)
            return "School";
        else if (age >= 17)
            return "Out of school";
        else
            return "Something went wrong";
    }
}
