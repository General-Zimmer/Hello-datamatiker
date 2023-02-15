package opgaver.opgave3;

public class Stars_4 {
    public static void main(String[] args) {
        exA(99);
    }

    public static void exA(int rowCount) {

        if (rowCount % 2 != 1) {
            System.out.println("Not an odd number, please gib odd number");
            return;
        }

        int whenStar = 0;
        boolean isFirstHalf = true;

        for (int row = 1; row <= rowCount; row++) {
            // print row number
            System.out.printf("%2d: ", row);

            // Makes sure star placement is reversed
            if (rowCount/2 == whenStar)
                isFirstHalf = false;

            // Places stars in the middle, and + and minus whenStar. Gets reversed halfway
            for (int i = 1; i <= rowCount; i++) {
                if (i >= (rowCount / 2 + 1) - whenStar && i <= (rowCount / 2 + 1) + whenStar)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            // Responsible for whenStar, which makes sure x out from the middle has stars
            if (isFirstHalf)
                whenStar++;
            else
                whenStar--;

            // Next line since row should be done
            System.out.println();
        }

    }
}