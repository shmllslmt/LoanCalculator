public class HomeLoan extends Loan {
    private String propertyType;
    private double propertyValue;

    protected HomeLoan() {
        this(0, 0, 0, "Apartment", 0);
    }
    protected HomeLoan(double loanAmount, double interestRate, int loanTerm, String propertyType, double propertyValue) {
        super(loanAmount, interestRate, loanTerm);
        this.propertyType = propertyType;
        this.propertyValue = propertyValue;
    }

    public double getPropertyValue() {
        return propertyValue;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyValue(double propertyValue) {
        this.propertyValue = propertyValue;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public double calcMonthlyPayment() {
        double pv = getLoanAmount();
        double i;

        if(propertyValue >= 2500000) {
            i = (getInterestRate()+0.025) / 12;
        } else {
            i = getInterestRate() / 12;
        }

        double n = getLoanTerm() * 12;

        double monthlyPayment = 0.0;

        monthlyPayment = ((pv * i)*(Math.pow(1+i,n))) / (Math.pow(1+i, n) - 1);

        return monthlyPayment;
    }
}
