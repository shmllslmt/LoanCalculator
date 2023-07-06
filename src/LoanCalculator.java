import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double inLoanAmount, inInterestRate, inPropertyValue;
        int inLoanTerm, inCreditScore;
        char inLoanType;
        String inPropertyType;

        System.out.print("How much is the loan? ");
        inLoanAmount = input.nextDouble();
        System.out.print("What is the interest rate (in floating point)? ");
        inInterestRate = input.nextDouble();
        System.out.print("How long is the loan term (in years)? ");
        inLoanTerm = input.nextInt();
        System.out.print("Is it a personal loan (P) or home loan (H)? ");
        inLoanType = input.next().charAt(0);

        Loan loan;

        if(inLoanType == 'P' || inLoanType == 'p') {
            System.out.print("What is your estimated credit score? ");
            inCreditScore = input.nextInt();

            loan = new PersonalLoan(inLoanAmount, inInterestRate, inLoanTerm, inCreditScore);
        } else {
            System.out.print("What is your property type? ");
            inPropertyType = input.next();
            System.out.println("What is your property value? ");
            inPropertyValue = input.nextDouble();

            loan = new HomeLoan(inLoanAmount, inInterestRate, inLoanTerm, inPropertyType, inPropertyValue);
        }

        loan.displayInfo();
    }
}

