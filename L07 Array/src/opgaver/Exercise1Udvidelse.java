package opgaver;

import java.util.Arrays;

public class Exercise1Udvidelse {

    public static void main(String[] args) {
        // h
        int sum = 0;
        int[] h = new int[10];
        for (int i = 0; i < 10; i++) {

            if (i == 0)
                continue;

            if (i % 2 == 1) {
                h[i] = sum+3;
                sum += 3;
            }

            else {
                h[i] = sum+1;
                sum += 1;
            }

        }

        System.out.println(Arrays.toString(h));
    }
}
