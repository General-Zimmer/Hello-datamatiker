package opgaver;

public class Opgave3 {
    public static void main(String[] args) {

        System.out.println(sumOddDigits(234));
    }


    public static int sumOddDigits(int number) {
        int length = Integer.toString(number).length();

        int tal = 0;

        for (int i = 0; i <= length; i++) {
            int digit = number % 10;
            number /= 10;


            if (digit % 2 == 1)
                tal += digit;
        }
        return tal;

    }
}
