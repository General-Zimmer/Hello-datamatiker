package opgaver;

public class Opgave2 {
    public static void main(String[] args) {

        printPowersOfTwos();
        System.out.println("Sum total " + sumEvenInts(7,24));
    }

    public static void printPowersOfTwos() {

        int tal = 2;
        for (int i = 0; i < 20; i++) {
            System.out.println("PowerOfTWO " + tal);
            tal *= 2;
        }

    }
    public static int sumEvenInts(int a, int b) {
        int tal = 0;
        for (int i = a; i <= b; i++) {
            if (i % 2 == 0)
                tal += i;

        }
        return tal;
    }
}
