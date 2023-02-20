package opgaver;

import java.util.Arrays;

public class Exercise3 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(sumArrays(new int[]{4, 6, 7, 2, 3}, new int[]{4, 6, 8, 2, 6})));
    }

    public static int[] sumArrays(int[] a, int[] b) {
        int[] sum = new int[a.length];

        for (int i = 0; i < a.length; i++)
            sum[i] += a[i]+b[i];

        return sum;
    }

}
