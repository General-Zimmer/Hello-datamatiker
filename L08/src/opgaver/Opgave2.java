package opgaver;

import java.util.Arrays;

public class Opgave2 {
    private static final int[][] tal = {
            {0, 4, 3, 9, 6},
            {1, 3, 5, 2, 2},
            {3, 3, 1, 0, 1},
            {0, 0, 9, 7, 1}
    };

    public static void main(String[] args) {
        printArray();
        System.out.println("All Five");
        allFive();
        printArray();
        System.out.println("EvenRows");
        evenOddRow();
        printArray();
        System.out.println("EvenColumns");
        evenOddColumn();
        printArray();
        System.out.println("ChessPattern");
        chessPattern();
        printArray();
        System.out.println("BoxPattern");
        boxPattern();
        printArray();
    }
    public static void printArray() {
        for (int[] row : tal) {
            for (int j : row) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void allFive() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < tal[0].length; j++) {
                tal[i][j] = 5;
            }
        }
    }

    public static void evenOddRow() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < tal[0].length; j++) {
                if (i % 2 == 0)
                    tal[i][j] = 2;
                else
                    tal[i][j] = 3;

            }
        }
    }

    public static void evenOddColumn() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < tal[0].length; j++) {
                if (j % 2 == 0)
                    tal[i][j] = 2;
                else
                    tal[i][j] = 3;

            }
        }
    }

    public static void chessPattern() {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < tal[0].length; j++) {
                tal[i][j] = temp;
                if (temp == 0)
                    temp = 1;
                else temp = 0;
            }
        }
    }

    public static void boxPattern() {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < tal[0].length; j++) {

                if (j == 0 || j == tal[0].length-1)
                    tal[i][j] = 5;
                else if (i == 0 || i == Arrays.stream(tal).count()-1)
                    tal[i][j] = 5;
                else tal[i][j] = 2;
            }
        }
    }
}
