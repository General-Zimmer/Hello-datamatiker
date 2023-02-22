package opgaver;

public class Exercise5b {
    public static void main(String[] args) {



        int[] hyppigheder = hyppigheder(new int[]{2, 5, 6, 5, 4, 3, 23, 43, 2, 0});
        for (int i = 0; i < 50; i++) {

            if (hyppigheder[i] > 0)
                System.out.println(i + " comes up " + hyppigheder[i] + " times");

        }
    }

    public static int[] hyppigheder(int[] t) {
        int[] hyppigheder = new int[50];

        for (int j : t) {
            hyppigheder[j]++;
        }
        return hyppigheder;
    }
}
