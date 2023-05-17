package opgaver;

public class Opgave1 {
    private static final int[][] tal = {
            {0, 4, 3, 9, 6},
            {1, 3, 5, 2, 2},
            {3, 3, 1, 0, 1},
            {0, 0, 9, 7, 1}
    };
    public static void main(String[] args) {


        System.out.println("2nd");
        printArray();
        System.out.println("3rd");
        sumRow(2);
        sumColumn(1);
        System.out.println(sumArray());
        System.out.println(getValueAt(1, 2));
        setValueAT(1, 2, 1);
        System.out.println(getValueAt(1, 2));
    }

    public static void printArray() {
        for (int[] row : tal) {
            for (int j : row) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void sumRow(int rowNum) {
        int sum = 0;

        for (int column : tal[rowNum]) {
            sum += column;
        }
        System.out.println("The sum of this row is: " + sum);
    }


    public static void sumColumn(int columnNum) {
        int sum = 0;

        for (int[] row : tal)
            sum += row[columnNum];
        System.out.println("The sum of this column is: " + sum);
    }

    public static int sumArray() {
        int sum = 0;
        for (int[] row : tal)
            for (int j : row)
                sum += j;
        return sum;
    }

    public static int getValueAt(int row, int column) {
        return tal[row][column];
    }

    public static void setValueAT(int row, int column, int value) {
        tal[row][column] = value;
    }




}
