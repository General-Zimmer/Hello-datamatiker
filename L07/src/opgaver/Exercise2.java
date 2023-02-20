package opgaver;

public class Exercise2 {
    public static void main(String[] args) {

        System.out.println(sum(new int[]{4, 6, 7, 2, 3}));
    }

    public static int sum(int[] t) {
        int sum = 0;

        for (int j : t)
            sum += j;

        return sum;
    }
}
