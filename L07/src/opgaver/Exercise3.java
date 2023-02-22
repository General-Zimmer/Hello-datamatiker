package opgaver;

import java.util.Arrays;

public class Exercise3 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(sumArrays(new int[]{4, 6, 7, 2, 3}, new int[]{4, 6, 8, 2, 6})));
    }

    public static int[] sumArrays(int[] a, int[] b) {
        int length = Math.max(a.length, b.length);
        int[] sum = new int[length];


        for (int i = 0; i < length; i++) {
            if (i < a.length)
                sum[i] += a[i];
            if (i < b.length)
                sum[i] += b[i];
        }


        return sum;
    }

}
