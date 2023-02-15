package opgaver.opgave3;

public class Stars_4 {
    public static void main(String[] args) {
        exA(99);
    }

    public static void exA(int rowCount) {
        int whenStar = 0;
        boolean isFirstHalf = true;

        for (int row = 1; row <= rowCount; row++) {
            // print row number
            System.out.printf("%2d: ", row);



            if (rowCount/2 == whenStar)
                isFirstHalf = false;

            // First half
            if (isFirstHalf) {
                for (int i = 1; i <= rowCount; i++) {
                    if (i >= (rowCount/2+1)-whenStar && i <= (rowCount/2+1)+whenStar)
                        System.out.print("*");
                    else {
                        System.out.print(" ");
                    }

                }
                whenStar++;
            }

            else {
                // Second half
                for (int i = 1; i <= rowCount; i++) {
                    if (i >= (rowCount/2+1)-whenStar && i <= (rowCount/2+1)+whenStar)
                        System.out.print("*");
                    else {
                        System.out.print(" ");
                    }

                }
                whenStar--;
            }




            System.out.println();


        }

    }
}
