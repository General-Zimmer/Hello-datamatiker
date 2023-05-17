package model.bookcapter1;

public class Opgave11 {
    public static void main(String[] args) {
        int birth = 7;
        int death = 13;
        int immigrant = 45;
        int currentPop = 312032486;
        double yearSeconds = 31536000.0;

        double birthYear = yearSeconds/birth;
        double deathYear = yearSeconds/death;
        double immiYear = yearSeconds/immigrant;

        double newyear;
        double oldyear = currentPop+birthYear+immiYear-deathYear;
        System.out.print("Year 1: ");
        System.out.printf("%,.0f\n", oldyear);

        for (int i = 0; i < 5; i++) {
            newyear = oldyear+birthYear+immiYear-deathYear;
            System.out.print("Year "+ (i+2) +": ");
            System.out.printf("%,.0f\n", newyear);
            oldyear = newyear;
        }

    }
}
