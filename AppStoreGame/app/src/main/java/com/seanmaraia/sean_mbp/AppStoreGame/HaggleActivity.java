package com.seanmaraia.sean_mbp.AppStoreGame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HaggleActivity extends AppCompatActivity {

    TextView mHundredsText, mTensText, mOnesText, mTenthsText, mHundredthsText;
    Button mHundredsPlusButton, mHundredsMinusButton,
            mTensPlusButton, mTensMinusButton,
            mOnesPlusButton, mOnesMinusButton,
            mTenthsPlusButton, mTenthsMinusButton,
            mHundredthsPlusButton, mHundredthsMinusButton;
    ImageButton mAcceptButton, mDeclineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haggle);

        mHundredsText = (TextView)findViewById(R.id.hundredsText);
        mTensText = (TextView)findViewById(R.id.tensText);
        mOnesText = (TextView)findViewById(R.id.onesText);
        mTenthsText = (TextView)findViewById(R.id.tenthsText);
        mHundredthsText = (TextView)findViewById(R.id.hundredthsText);

        mHundredsPlusButton = (Button)findViewById(R.id.hundredsPlusButton);
        mHundredsPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mHundredsText.getText().toString());
                if (i < 9) { i++; }
                mHundredsText.setText(""+i);
            }
        });

        mHundredsMinusButton = (Button)findViewById(R.id.hundredsMinusButton);
        mHundredsMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mHundredsText.getText().toString());
                if (i > 0) { i--; }
                mHundredsText.setText(""+i);
            }
        });

        mTensPlusButton = (Button)findViewById(R.id.tensPlusButton);
        mTensPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mTensText.getText().toString());
                if (i < 9) { i++; }
                mTensText.setText(""+i);
            }
        });

        mTensMinusButton = (Button)findViewById(R.id.tensMinusButton);
        mTensMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mTensText.getText().toString());
                if (i > 0) { i--; }
                mTensText.setText(""+i);
            }
        });

        mOnesPlusButton = (Button)findViewById(R.id.onesPlusButton);
        mOnesPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mOnesText.getText().toString());
                if (i < 9) { i++; }
                mOnesText.setText(""+i);
            }
        });

        mOnesMinusButton = (Button)findViewById(R.id.onesMinusButton);
        mOnesMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mOnesText.getText().toString());
                if (i > 0) { i--; }
                mOnesText.setText(""+i);
            }
        });

        mTenthsPlusButton = (Button)findViewById(R.id.tenthsPlusButton);
        mTenthsPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mTenthsText.getText().toString());
                if (i < 9) { i++; }
                mTenthsText.setText(""+i);
            }
        });

        mTenthsMinusButton = (Button)findViewById(R.id.tenthsMinusButton);
        mTenthsMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mTenthsText.getText().toString());
                if (i > 0) { i--; }
                mTenthsText.setText(""+i);
            }
        });

        mHundredthsPlusButton = (Button)findViewById(R.id.hundredthsPlusButton);
        mHundredthsPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mHundredthsText.getText().toString());
                if (i < 9) { i++; }
                mHundredthsText.setText(""+i);
            }
        });

        mHundredthsMinusButton = (Button)findViewById(R.id.hundredthsMinusButton);
        mHundredthsMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(mHundredthsText.getText().toString());
                if (i > 0) { i--; }
                mHundredthsText.setText(""+i);
            }
        });

        mAcceptButton = (ImageButton)findViewById(R.id.acceptButton);
        mAcceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float value = (Integer.parseInt(mHundredsText.getText().toString()) * 100) +
                        (Integer.parseInt(mTensText.getText().toString()) * 10) +
                        (Integer.parseInt(mOnesText.getText().toString()) * 1)+
                        (Integer.parseInt(mTenthsText.getText().toString()) * 0.1f) +
                        (Integer.parseInt(mHundredthsText.getText().toString()) * .01f);

                Intent intent = new Intent(HaggleActivity.this, ListActivity.class);
                //Pass data back to parent activity
                intent.putExtra(ListActivity.GOLD_DATA, value);
                setResult(ListActivity.RESULT_OK, intent);
                finish();
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
}
