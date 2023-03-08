package opgaver.exercise2;

import java.time.LocalDate;

public class RentalApp {
    public static void main(String[] args) {


        Rental ren1 = new Rental(1, 30, 10, LocalDate.of(2023, 4, 1));
        Rental ren2 = new Rental(2, 30, 10, LocalDate.now().plusMonths(10));

        System.out.println(ren1);
        System.out.println(ren1.getTotalPrice());
        System.out.println(ren1.getEndDate());
        System.out.println(ren1.getStartDate().minusDays(1));
        System.out.println(ren2);
        System.out.println(ren2.getTotalPrice());
        System.out.println(ren2.getEndDate());
        System.out.println(ren2.getStartDate().minusDays(1));

        long epochDays = ren2.getStartDate().toEpochDay()-ren1.getEndDate().toEpochDay();
        int years = (int) (epochDays/365);
        double tempEpochDays = epochDays%365;
        long months = (long) (tempEpochDays/30);
        tempEpochDays %= 30;
        long days = (long) tempEpochDays;
        System.out.println("Year: " + years + " month: " + months + " days: " + days);
        System.out.println("Total number of days between rentals: " + epochDays);
    }
}
