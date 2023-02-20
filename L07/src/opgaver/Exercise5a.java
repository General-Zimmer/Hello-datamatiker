package opgaver;

public class Exercise5a {
    public static void main(String[] args) {

        int[] oddAndEven = evenAndOddNumbers(new int[]{1, 2, 3, 2, 1, 6, 3, 4, 5, 2, 3, 6, 8, 9, 9});
        System.out.println("Amount of odd numbers are: " + oddAndEven[0]);
        System.out.println("Amount of even numbers are: " + oddAndEven[1]);
    }

    public static int[] evenAndOddNumbers(int[] t) {
        int odd = 0;
        int even = 0;

        for (int j : t) {
            if (j % 2 == 0)
                even += 1;
            else
                odd += 1;
        }
        return new int[]{odd, even};
    }
}
