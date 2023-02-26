package opgaver;


import java.util.Arrays;

public class Opgave4 {
    public static int[][] tal = {
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
            {20, 30, 30, 40, 50, 50, 40, 30, 30, 20},
            {30, 40, 50, 50, 50, 50, 50, 50, 40, 30}
    };

    public static void main(String[] args) {

        for (int i = 0; i < 9; i++) {
            System.out.println("Status for random ticket purchase for 50: " + buyTicket(50));
        }
        System.out.println("Status for specific ticket purchase for 50: " + buyTicket(1,1));
        System.out.println("Status for specific ticket purchase for 50: " + buyTicket(1,1));
        printTheaterFloor();
    }

    public static boolean buyTicket(int price) {
        for (int i = 0; i < Arrays.stream(tal).count(); i++) {
            for (int j = 0; j < tal[0].length; j++) {

                if (price == tal[i][j]) {
                    tal[i][j] = 0;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean buyTicket(int row, int column) {

        row -= 1;
        column -= 1;
        if (tal[row][column] != 0) {
            tal[row][column] = 0;
            return true;
        }
        return false;
    }

    public static void printTheaterFloor() {
        System.out.println("De ledige pladser er angivet med deres pris");
        System.out.println("   sæde : 1   2   3   4   5   6   7   8   9   10");
        System.out.println("          --------------------------------------");
        for (int i = 0; i < tal.length; i++) {
            System.out.print("Række " + (i+1) + " : ");
            for (int j : tal[i]) {
                if (j == 0)
                    System.out.print("--" + ", ");
                else System.out.print(j + ", ");
            }
            System.out.println();
        }

    }
}
