public class Loan {
    private double loanAmount;
    private double interestRate;
    private int loanTerm;
    protected Loan() {
        this(0, 0, 0);
    }
    protected Loan(double loanAmount, double interestRate, int loanTerm) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
    }
    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public double calcMonthlyPayment() {
        double pv = loanAmount;
        double i = interestRate / 12;
        double n = loanTerm * 12;

        double monthlyPayment = 0.0;

        monthlyPayment = ((pv * i)*(Math.pow(1+i,n))) / (Math.pow(1+i, n) - 1);

        return monthlyPayment;
    }

    public void displayInfo() {
        System.out.println("Loan Amount: "+loanAmount);
        System.out.println("Annual Interest Rate: "+interestRate);
        System.out.println("Loan Term: "+loanTerm+" years");
        System.out.println("Monthly Payment: "+calcMonthlyPayment());
    }
}


