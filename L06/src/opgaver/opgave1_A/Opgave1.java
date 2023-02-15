package opgaver.opgave1_A;

public class Opgave1 {
    public static void main(String[] args) {

        System.out.println("Opgave a: " + a());
        System.out.println("Opgave b: " + b());
    }

    public static int a() {
        int tal = 0;
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0)
                tal += i;

        }
        return tal;
    }
    public static int b() {

        int tal = 0;
        for (int i = 1; i < 101; i++) {
            if (i*i <= 100)
                tal += i*i;
        }
        return tal;
    }
}
