package opgaver;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise6 {
    public static void main(String[] args) {

        // switchLastAndFirst
        System.out.println(Arrays.toString(switchLastAndFirst(new int[]{1, 6, 3, 9})));
        // fuckEvenNumbers
        System.out.println(Arrays.toString(fuckEvenNumbers(new int[]{7, 5, 4, 2, 5, 9, 10})));
        // SecondHighestNumber
        System.out.println(SecondHighestNumber(new int[]{99, 3, 7, 2}));
        // isAscending
        System.out.println("Is the array ascending: " + isAscending(new int[]{99, 3, 7, 2}));
        System.out.println("Is the array ascending: " + isAscending(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println("Is the array ascending: " + isAscending(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8}));
        // shiftNumbers
        System.out.println(Arrays.toString(shiftNumbers(new int[]{1, 4, 9, 16, 25})));
        // hasDoublets
        System.out.println(hasDoublets(new int[]{1, 6, 4, 3, 7}));
        System.out.println(hasDoublets(new int[]{7, 3, 6, 4, 3, 7}));

    }

    public static int[] switchLastAndFirst(int[] t) {
        int tal = t[0];
        t[0] = t[t.length-1];
        t[t.length-1] = tal;

        return t;
    }

    public static int[] fuckEvenNumbers(int[] t) {

        for (int i = 0; i < t.length; i++)
            if (t[i] % 2 == 0)
                t[i] = 0;
        return t;
    }

    public static int SecondHighestNumber(int[] t) {
        int highest = -999999999;
        int secondHighest = -99999999;

        for (int j : t) {
            if (j > highest) {
                secondHighest = highest;
                highest = j;
            }
            else if (j > secondHighest)
                secondHighest = j;
        }
        return secondHighest;
    }


    public static boolean isAscending(int[] t) {
        int highest = -999999999;
        boolean isAscending = true;

        for (int j : t) {

            if (j > highest)
                highest = j;
            else
                isAscending = false;


        }
        return isAscending;
    }

    public static int[] shiftNumbers(int[] t) {
        int tal = t[t.length-1];

        for (int i = t.length-1; i >= 0; i--) {
            if (i != 0)
                t[i] = t[i-1];
            else
                t[0] = tal;
        }
        return t;
    }

    public static boolean hasDoublets(int[] t) {
        ArrayList<Integer> copy = new ArrayList<>(t.length);


        for (int j : t) {
            if (copy.contains(j))
                return true;
            else
                copy.add(j);
        }
        return false;
    }

}
