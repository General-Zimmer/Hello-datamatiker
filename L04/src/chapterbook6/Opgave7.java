package chapterbook6;

public class Opgave7 {
    public static void main(String[] args) {

        futureInvestmentValue(10000, 0.05, 30);
    }


    public static void futureInvestmentValue(double start, double interestRate, int years) {

        for (int i = 1; i <= years; i++) {
            start = start*(interestRate+1);
            System.out.println("year " + i + ": " + start);
        }
    }
}
