public class PersonalLoan extends Loan {
    private int creditScore;

    protected PersonalLoan() {
        this(0, 0, 0, 0);
    }
    protected PersonalLoan(double loanAmount, double interestRate, int loanTerm, int creditScore) {
        super(loanAmount, interestRate, loanTerm);
        this.creditScore = creditScore;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public double calcMonthlyPayment() {
        double pv = getLoanAmount();
        double i = 0.0;

        if(creditScore <= 696) { // Fair at maximum
            i = (getInterestRate()+0.01) / 12;
        } else { // Good at minimum
            i = (getInterestRate()-0.005) / 12;
        }

        double n = getLoanTerm() * 12;

        double monthlyPayment = 0.0;

        monthlyPayment = ((pv * i)*(Math.pow(1+i,n))) / (Math.pow(1+i, n) - 1);

        return monthlyPayment;
    }
}
