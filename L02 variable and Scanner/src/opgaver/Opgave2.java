package opgaver;

import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {
        /*
        Make a program, that inputs a loan amount, the annual interest rate
        and the number of years, and calculates the monthly payment and
        the total payment.
        Monthly payment = loan amount * interest rate pr month / denumerator
        where denumerator = 1 - 1 / (1 + interest rate pr month) ^ number of
        months).
        Use Math.pow(a, b) to calculate a ^ b (example: 2 ^ 3 = 8).
        */

        /*
        Prompt user for loan amount, annual interest rate, and the payback period in years.
        Calculate the monthly payment
        Return monthly payment
         */

        Scanner input = new Scanner(System.in);


        System.out.println("Type your loan amount");
        double loanAmount = input.nextDouble();
        System.out.println("Type your annual interest rate");
        double interestRate = input.nextInt()/12.0/100.0;
        System.out.println("Type your payback period in years");
        double years = input.nextInt();

        double denumerator = 1-1/Math.pow(interestRate + 1, years*12);
        double monthlyPayment = (loanAmount*interestRate)/denumerator;

        System.out.printf("Your payment per month is %.3f\n", monthlyPayment);
    }
}
