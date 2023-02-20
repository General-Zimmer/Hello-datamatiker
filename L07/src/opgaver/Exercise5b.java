package opgaver;

public class Exercise5b {
    public static void main(String[] args) {



        int[] hyppigheder = hyppigheder(new int[]{2, 5, 6, 5, 4, 3, 23, 43, 2, 0});
        for (int tal : hyppigheder) {

            if (tal > 0)
                System.out.println(tal);

        }
    }

    public static int[] hyppigheder(int[] t) {
        int[] hyppigheder = new int[50];

        for (int j : t) {
            hyppigheder[j] += 1;
        }
        return hyppigheder;
    }
}
