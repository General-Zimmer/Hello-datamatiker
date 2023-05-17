package opgaver.opgave3;

public class Stars_3 {
    public static void main(String[] args) {
        exA(10);
    }

    public static void exA(int rowCount) {
        for (int row = rowCount; row >= 1; row--) {
            // print row number
            System.out.printf("%2d: ", row);

            // print dashes
            int dashCount = rowCount - row;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print(" ");
            }

            // print stars
            int StarCount = rowCount + 1 - dashCount;
            for (int i = 1; i <= StarCount; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
