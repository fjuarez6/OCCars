package edu.orangecoastcollege.cs273.fjuarez6.occars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoanSummaryActivity extends Activity {

    private Button goToDataEntryButton;
    private TextView monthlyPaymentTextView;
    private TextView loanSummaryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        goToDataEntryButton = (Button) findViewById(R.id.goToDataEntryButton);
        monthlyPaymentTextView = (TextView) findViewById(R.id.monthlyPaymentTextView);
        loanSummaryTextView = (TextView) findViewById(R.id.loanSummaryTextView);

        Intent  intentFromPurchaseActivity = getIntent();
        String monthlyPaymentText = intentFromPurchaseActivity.getStringExtra("MonthlyPayment");
        String loanSummaryText = intentFromPurchaseActivity.getStringExtra("LoanSummary");
        monthlyPaymentTextView.setText(monthlyPaymentText);
        loanSummaryTextView.setText(loanSummaryText);


        goToDataEntryButton.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {
                                                       returnToDataEntry(v);
                                                   }
                                               }
        );
    }

    public void returnToDataEntry(View v)
    {
        this.finish();
    }
}
