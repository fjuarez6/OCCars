package edu.orangecoastcollege.cs273.fjuarez6.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.NumberFormat;

public class PurchaseActivity extends AppCompatActivity {

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    private String monthlyPaymentText;
    private String loanSummaryText;
    private String term;


    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioButton threeYearsRadioButton;
    private RadioButton fourYearsRadioButton;
    private RadioButton fiveYearsRadioButton;


     private Car mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        carPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        downPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        threeYearsRadioButton = (RadioButton) findViewById(R.id.threeYearsRadioButton);
        fourYearsRadioButton = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        fiveYearsRadioButton = (RadioButton) findViewById(R.id.fiveYearsRadioButton);

        mCar = new Car();
    }

    public void activateLoanReport(View view) {
        double price, downPayment;

        try {
            price = Double.parseDouble(carPriceEditText.getText().toString());
            downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
        }
        catch (NumberFormatException e)
        {
            price = 0.0;
            downPayment = 0.0;
        }

        int loanTerm;

        if (fiveYearsRadioButton.isChecked())
            loanTerm = 5;
        else if (fourYearsRadioButton.isChecked())
            loanTerm = 4;
        else
            loanTerm = 3;

        mCar.setPrice(price);
        mCar.setDownPayment(downPayment);
        mCar.setLoanTerm(loanTerm);

        Intent loanSummaryIntent = new Intent(this, LoanSummaryActivity.class);
        constructLoanSummaryText();
        loanSummaryIntent.putExtra("MonthlyPayment", monthlyPaymentText);
        loanSummaryIntent.putExtra("LoanSummary", loanSummaryText);
        startActivity(loanSummaryIntent);

    }

    private void constructLoanSummaryText()
    {
        monthlyPaymentText = getString(R.string.report_line1) + currency.format(mCar.calculateMonthlyPayment());

        loanSummaryText = getString(R.string.report_line2) + "             " + currency.format(mCar.getPrice())
                + getString(R.string.report_line3) + "            " + currency.format(mCar.getDownPayment())
                + getString(R.string.report_line5) + "                        " + currency.format(mCar.calculateTaxAmount())
                + getString(R.string.report_line6) + "                          " + currency.format(mCar.calculateTotalCost())
                + getString(R.string.report_line7) + "           " + currency.format(mCar.calculateBorrowedAmount())
                + getString(R.string.report_line8) + "               " + currency.format(mCar.calculateInterestAmount())
                + "\n" + getString(R.string.report_line4) + " " + loanTermText() + "\n" + getString(R.string.report_line9)
                + getString(R.string.report_line10)
                + getString(R.string.report_line11)
                + getString(R.string.report_line12);
    }

    private String loanTermText()
    {
        if (mCar.getLoanTerm() == 3)
            term = getString(R.string.years3);
        else if (mCar.getLoanTerm() == 4)
            term = getString(R.string.years4);
        else
            term = getString(R.string.years5);

        return term;
    }
}
