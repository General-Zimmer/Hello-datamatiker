package chapterbook6;

public class Opgave11 {
    public static void main(String[] args) {


        makeTable();
    }

    public static double calcCommission(int salesAmount) {
        double commission = 0;
        if (salesAmount <= 5000)
            commission = 0.06*salesAmount;
        else if (salesAmount <= 10000) {
            salesAmount -= 5000;
            commission += 0.06*5000;

            commission += 0.08*salesAmount;

        }
        else {
            salesAmount -= 5000;
            commission += 0.06*5000;

            salesAmount -= 5000;
            commission += 0.08*5000;

            commission += 0.1*salesAmount;


        }

        return commission;

    }

    public static void makeTable() {
        System.out.println("Sales Amount    Commission" );

        int salesAmount = 10000;
        for (int i = 0; i < 20; i++) {
            System.out.println(salesAmount+ "            " + calcCommission(salesAmount));
            salesAmount += 5000;

        }
    }
}
