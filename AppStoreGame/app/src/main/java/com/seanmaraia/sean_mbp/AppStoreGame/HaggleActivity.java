package com.seanmaraia.sean_mbp.AppStoreGame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class HaggleActivity extends AppCompatActivity {

    TextView mDialogueText, mHundredsText, mTensText, mOnesText, mTenthsText, mHundredthsText, mPercentText;
    Button mHundredsPlusButton, mHundredsMinusButton,
            mTensPlusButton, mTensMinusButton,
            mOnesPlusButton, mOnesMinusButton,
            mTenthsPlusButton, mTenthsMinusButton,
            mHundredthsPlusButton, mHundredthsMinusButton;
    ImageButton mAcceptButton, mDeclineButton;

    CustomerData customerData = new CustomerData();
    CustomerStruct customer;

    ArrayList<AppItem> data;

    float basePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haggle);

        DataStore datastore = DataStore.get(this);
        data = datastore.getData();

        Random r = new Random();
        int i = r.nextInt(data.size());
        //basePrice = (float)data.get(i).price;
        basePrice = 200.00f;

        customer = customerData.getRandomCustomer();

        mDialogueText = (TextView)findViewById(R.id.dialogueText);
        String text =   "Name: " + customer.name + "\n" +
                        "Age: " + customer.age + "\n" +
                        "Occupation: " + customer.occupation + "\n\n" +
                        "Introduction dialogue stuff here";
        mDialogueText.setText(text);

        float tempValue = basePrice;

        mHundredsText = (TextView)findViewById(R.id.hundredsText);
        mHundredsText.setText("" + (int)Math.floor(tempValue / 100));

        tempValue -= (float)Math.floor(tempValue / 100) * 100;

        mTensText = (TextView)findViewById(R.id.tensText);
        mTensText.setText("" + (int)Math.floor(tempValue / 10));

        tempValue -= (float)Math.floor(tempValue / 10) * 10;

        mOnesText = (TextView)findViewById(R.id.onesText);
        mOnesText.setText("" + (int)Math.floor(tempValue));

        tempValue -= (float)Math.floor(tempValue);

        mTenthsText = (TextView)findViewById(R.id.tenthsText);
        mTenthsText.setText("" + (int)Math.floor(tempValue / 0.1f));

        tempValue -= (float)Math.floor(tempValue / 0.1f) * 0.1f;

        mHundredthsText = (TextView)findViewById(R.id.hundredthsText);
        mHundredthsText.setText("" + (int)Math.floor(tempValue / 0.01f));

        mHundredsPlusButton = (Button)findViewById(R.id.hundredsPlusButton);
        mHundredsPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mHundredsText.getText().toString());
                if (i < 9) { i++; }
                mHundredsText.setText("" + i);
                updatePercent();
            }
        });

        mHundredsMinusButton = (Button)findViewById(R.id.hundredsMinusButton);
        mHundredsMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mHundredsText.getText().toString());
                if (i > 0) { i--; }
                mHundredsText.setText("" + i);
                updatePercent();
            }
        });

        mTensPlusButton = (Button)findViewById(R.id.tensPlusButton);
        mTensPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mTensText.getText().toString());
                if (i < 9) { i++; }
                mTensText.setText("" + i);
                updatePercent();
            }
        });

        mTensMinusButton = (Button)findViewById(R.id.tensMinusButton);
        mTensMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mTensText.getText().toString());
                if (i > 0) { i--; }
                mTensText.setText("" + i);
                updatePercent();
            }
        });

        mOnesPlusButton = (Button)findViewById(R.id.onesPlusButton);
        mOnesPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mOnesText.getText().toString());
                if (i < 9) { i++; }
                mOnesText.setText("" + i);
                updatePercent();
            }
        });

        mOnesMinusButton = (Button)findViewById(R.id.onesMinusButton);
        mOnesMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mOnesText.getText().toString());
                if (i > 0) { i--; }
                mOnesText.setText("" + i);
                updatePercent();
            }
        });

        mTenthsPlusButton = (Button)findViewById(R.id.tenthsPlusButton);
        mTenthsPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mTenthsText.getText().toString());
                if (i < 9) { i++; }
                mTenthsText.setText("" + i);
                updatePercent();
            }
        });

        mTenthsMinusButton = (Button)findViewById(R.id.tenthsMinusButton);
        mTenthsMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mTenthsText.getText().toString());
                if (i > 0) { i--; }
                mTenthsText.setText("" + i);
                updatePercent();
            }
        });

        mHundredthsPlusButton = (Button)findViewById(R.id.hundredthsPlusButton);
        mHundredthsPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mHundredthsText.getText().toString());
                if (i < 9) { i++; }
                mHundredthsText.setText("" + i);
                updatePercent();
            }
        });

        mHundredthsMinusButton = (Button)findViewById(R.id.hundredthsMinusButton);
        mHundredthsMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mHundredthsText.getText().toString());
                if (i > 0) { i--; }
                mHundredthsText.setText("" + i);
                updatePercent();
            }
        });

        mPercentText = (TextView)findViewById(R.id.percentText);


        mAcceptButton = (ImageButton)findViewById(R.id.acceptButton);
        mAcceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float value = (Integer.parseInt(mHundredsText.getText().toString()) * 100) +
                        (Integer.parseInt(mTensText.getText().toString()) * 10) +
                        (Integer.parseInt(mOnesText.getText().toString()) * 1)+
                        (Integer.parseInt(mTenthsText.getText().toString()) * 0.1f) +
                        (Integer.parseInt(mHundredthsText.getText().toString()) * .01f);

                if (value > customer.maxGold) {
                    String text =   "Name: " + customer.name + "\n" +
                            "Age: " + customer.age + "\n" +
                            "Occupation: " + customer.occupation + "\n\n" +
                            "Price too high";
                    mDialogueText.setText(text);
                }
                else {
                    Intent intent = new Intent(HaggleActivity.this, ListActivity.class);
                    //Pass data back to parent activity
                    intent.putExtra(ListActivity.GOLD_DATA, value);
                    setResult(ListActivity.RESULT_OK, intent);
                    finish();
                }
            }
        });

        mDeclineButton = (ImageButton)findViewById(R.id.declineButton);
        mDeclineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //future code goes here
                finish();
            }
        });
    }

    void updatePercent() {
        float value = (Integer.parseInt(mHundredsText.getText().toString()) * 100) +
                (Integer.parseInt(mTensText.getText().toString()) * 10) +
                (Integer.parseInt(mOnesText.getText().toString()) * 1)+
                (Integer.parseInt(mTenthsText.getText().toString()) * 0.1f) +
                (Integer.parseInt(mHundredthsText.getText().toString()) * .01f);

        value = Math.round(value / basePrice * 100);

        mPercentText.setText("" + value + "%");
    }
}
