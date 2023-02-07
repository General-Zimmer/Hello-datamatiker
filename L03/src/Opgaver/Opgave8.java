package Opgaver;

import java.util.Scanner;

public class Opgave8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv måned og dag med et mellemrum");
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        System.out.println(getSeason(month, day));


    }

    public static String getSeason(int month, int day) {
        String season = "efterår";
        if (month == 12 || month == 1 || month == 2)
            season = "vinter";
        else if (month == 3 || month == 4 || month == 5)
            season = "forår";
        else if (month == 6 || month == 7 || month == 8)
            season = "Sommer";

        if ((month == 2 || month == 5 || month == 8 || month == 11) && day >= 21)
            season = switch (season) {
                case "vinter" -> "forår";
                case "forår" -> "Sommer";
                case "Sommer" -> "Efterår";
                default -> "vinter";
            };
        return season;
    }
}
