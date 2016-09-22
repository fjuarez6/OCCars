package edu.orangecoastcollege.cs273.fjuarez6.occars;

/**
 * Created by frddy on 9/15/2016.
 */
public class Car {

    private double mDownPayment;
    private int mLoanTerm;
    private double mPrice;
    private static final double TAX_RATE = 0.08;
    private static final double APR_3_YEARS = 0.0462;
    private static final double APR_4_YEARS = 0.0419;
    private static final double APR_5_YEARS = 0.0416;

    public Car() {
        mDownPayment = 0.0;
        mLoanTerm = 0;
        mPrice = 0.0;
    }

    public double getDownPayment() {
        return mDownPayment;
    }

    public void setDownPayment(double downPayment) {
        mDownPayment = downPayment;
    }

    public int getLoanTerm() {
        return mLoanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        mLoanTerm = loanTerm;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public double calculateBorrowedAmount()
    {
        return calculateTotalCost() - mDownPayment;
    }

    public double calculateInterestAmount()
    {
        if (mLoanTerm == 3)
            return (calculateBorrowedAmount() * (((APR_3_YEARS / 12) * Math.pow((1 +  (APR_3_YEARS / 12)), 12)) / (Math.pow((1 + (APR_3_YEARS / 12)), 12) - 1)));
        else if (mLoanTerm == 4)
            return (calculateBorrowedAmount() * (((APR_4_YEARS / 12) * Math.pow((1 +  (APR_4_YEARS / 12)), 12)) / (Math.pow((1 + (APR_4_YEARS / 12)), 12) - 1)));
        else
            return (calculateBorrowedAmount() * (((APR_5_YEARS / 12) * Math.pow((1 +  (APR_5_YEARS / 12)), 12)) / (Math.pow((1 + (APR_5_YEARS / 12)), 12) - 1)));

    }

    public double calculateMonthlyPayment()
    {
        return ((calculateBorrowedAmount() + calculateInterestAmount()) / (12 * mLoanTerm));
    }

    public double calculateTaxAmount()
    {
        return (mPrice * TAX_RATE);
    }

    public double calculateTotalCost()
    {
        return mPrice + calculateTaxAmount();
    }
}
