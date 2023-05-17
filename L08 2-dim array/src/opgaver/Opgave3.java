package opgaver;

import java.util.Arrays;

public class Opgave3 {
    private static final double[][] tal1 = {
        {1, 2, 3, 4.0},
        {5, 6.5, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    private static final double[][] tal2 = {
            {23.5, 35, 2, 10},
            {4.5, 3, 45, 3.5},
            {35, 44, 5.5, 9.6}
    };


    public static void main(String[] args) {
        System.out.println(majorAverage());
        System.out.println(Arrays.toString(locateSmallest()));
    }

    public static double majorAverage() {
        double sum = 0;
        double count = 0;
        for (int i = 0; i < Arrays.stream(tal1).count(); i++) {
            for (int j = 0; j < tal1[0].length; j++) {
                if (i == j) {
                    sum += tal1[i][j];
                    count++;
                }
            }
        }
        return sum/count;
    }

    public static int[] locateSmallest() {
        double smallest = tal2[0][0];
        int[] location = {0, 0};
        for (int i = 0; i < Arrays.stream(tal2).count(); i++) {
            for (int j = 0; j < tal2.length; j++) {
                if (smallest > tal2[i][j]) {
                    smallest = tal2[i][j];
                    location = new int[]{i, j};
                }
            }
        }
        return location;
    }
}
