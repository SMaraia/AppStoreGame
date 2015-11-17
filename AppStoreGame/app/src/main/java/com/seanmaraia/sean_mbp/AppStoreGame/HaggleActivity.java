package com.seanmaraia.sean_mbp.AppStoreGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HaggleActivity extends AppCompatActivity {

    EditText hundredsText, tensText, onesText, tenthsText, hundredthsText;
    Button hundredsPlusButton, hundredsMinusButton,
            tensPlusButton, tensMinusButton,
            onesPlusButton, onesMinusButton,
            tenthsPlusButton, tenthsMinusButton,
            hundredthsPlusButton, hundredthsMinusButton,
            acceptButton, declineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haggle);

        hundredsText = (EditText)findViewById(R.id.hundredsText);
        tensText = (EditText)findViewById(R.id.tensText);
        onesText = (EditText)findViewById(R.id.onesText);
        tenthsText = (EditText)findViewById(R.id.tenthsText);
        hundredthsText = (EditText)findViewById(R.id.hundredthsText);

        hundredsPlusButton = (Button)findViewById(R.id.hundredsPlusButton);
        hundredsPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(hundredsText.getText().toString());
                if (i < 9) { i++; }
                hundredsText.setText(i);
            }
        });

        hundredsMinusButton = (Button)findViewById(R.id.hundredsMinusButton);
        hundredsMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(hundredsText.getText().toString());
                if (i > 0) { i--; }
                hundredsText.setText(i);
            }
        });

        tensPlusButton = (Button)findViewById(R.id.tensPlusButton);
        tensPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(tensText.getText().toString());
                if (i < 9) { i++; }
                tensText.setText(i);
            }
        });

        tensMinusButton = (Button)findViewById(R.id.tensMinusButton);
        tensMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(tensText.getText().toString());
                if (i > 0) { i--; }
                tensText.setText(i);
            }
        });

        onesPlusButton = (Button)findViewById(R.id.onesPlusButton);
        onesPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(onesText.getText().toString());
                if (i < 9) { i++; }
                onesText.setText(i);
            }
        });

        onesMinusButton = (Button)findViewById(R.id.onesMinusButton);
        onesMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(onesText.getText().toString());
                if (i > 0) { i--; }
                onesText.setText(i);
            }
        });

        tenthsPlusButton = (Button)findViewById(R.id.tenthsPlusButton);
        tenthsPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(tenthsText.getText().toString());
                if (i < 9) { i++; }
                tenthsText.setText(i);
            }
        });

        tenthsMinusButton = (Button)findViewById(R.id.tenthsMinusButton);
        tenthsMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(tenthsText.getText().toString());
                if (i > 0) { i--; }
                tenthsText.setText(i);
            }
        });

        hundredthsPlusButton = (Button)findViewById(R.id.hundredthsPlusButton);
        hundredthsPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(hundredthsText.getText().toString());
                if (i < 9) { i++; }
                hundredthsText.setText(i);
            }
        });

        hundredthsMinusButton = (Button)findViewById(R.id.hundredthsMinusButton);
        hundredthsMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(hundredthsText.getText().toString());
                if (i > 0) { i--; }
                hundredthsText.setText(i);
            }
        });

        acceptButton = (Button)findViewById(R.id.acceptButton);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //future code goes here
                finish();
            }
        });

        declineButton = (Button)findViewById(R.id.declineButton);
        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //future code goes here
                finish();
            }
        });
    }
}
