package edu.orangecoastcollege.cs273.fjuarez6.occars;

/**
 * Created by frddy on 9/15/2016.
 */
public class Car {

    private double mDownPayment;
    private int mLoanTerm;
    private double mPrice;
    private static final double TAX_RATE = 0.075;

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
        return 0.0;
    }

    public double calculateInterestAmount()
    {
        return 0.0;
    }

    public double calculateMonthlyPayment()
    {
        return 0.0;
    }

    public double calculateTaxAmount()
    {
        return 0.0;
    }

    public double calculateTotalCost()
    {
        return 0.0;
    }
}
