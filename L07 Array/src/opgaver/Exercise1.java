package opgaver;

import java.util.Arrays;

public class Exercise1 {
    public static void main(String[] args) {


        // a.
        int[] a = new int[10];

        // b
        int[] b = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30};

        // c
        int[] c = new int[10];
        for (int i = 0; i < 10; i++)
            c[i] = i;

        // d
        int[] d = new int[10];
        for (int i = 1; i < 10; i++)
            d[i] = (i+1)*2;

        // e
        int[] e = new int[10];
        for (int i = 0; i < 10; i++)
            e[i] = ((i+1)*(i+1));

        // f
        int[] f = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1)
                f[i] = 1;
        }

        // g
        int[] g = new int[10];
        for (int i = 0; i < 10; i++) {

            if (i > 4)
                g[i] = i-5;
            else
                g[i] = i;
        }

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


        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(e));
        System.out.println(Arrays.toString(f));
        System.out.println(Arrays.toString(g));
        System.out.println(Arrays.toString(h));
    }
}
