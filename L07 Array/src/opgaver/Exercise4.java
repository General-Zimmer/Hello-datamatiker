package opgaver;

public class Exercise4 {
    public static void main(String[] args) {

        System.out.println(hasUneven(new int[]{4, 6, 7, 2, 3}));
        System.out.println(hasUneven(new int[]{4, 6, 8, 2, 6}));
    }

    public static boolean hasUneven(int[] t) {
        boolean hasUneven = false;

        for (int j : t) {
            if (j % 2 == 1) {
                hasUneven = true;
                break;
            }
        }
        return hasUneven;
    }
}
