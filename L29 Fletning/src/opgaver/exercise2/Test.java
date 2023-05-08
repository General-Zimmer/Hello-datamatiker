package opgaver.exercise2;

import opgaver.Util;

public class Test {
    public static void main(String[] args) {
        int[] l1 = {2,4,6,8,10,12,14};
        int[] l2 = {1,2,4,5,6,9,12,17};

        int[] arr = Util.sharedNumbers(l1, l2);

        for (int i : arr)
            System.out.println(i);
    }
}
