package com.seanmaraia.sean_mbp.AppStoreGame;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ResourceBundle;

public class CreatorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner themeSpinner, typeSpinner, styleSpinner;
    TextView priceView;
    ImageButton submitButton;
    int appPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator);

        priceView = (TextView) findViewById(R.id.costToMakeApp);


        themeSpinner = (Spinner) findViewById(R.id.theme_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.theme_spinner_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        themeSpinner.setAdapter(adapter);
        themeSpinner.setOnItemSelectedListener(this);

        typeSpinner = (Spinner) findViewById(R.id.type_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.type_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter2);
        typeSpinner.setOnItemSelectedListener(this);

        styleSpinner = (Spinner) findViewById(R.id.style_spinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.style_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        styleSpinner.setAdapter(adapter3);
        styleSpinner.setOnItemSelectedListener(this);

        submitButton = (ImageButton)findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreatorActivity.this, ListActivity.class);
                //Pass data back to parent activity
                intent.putExtra(ListActivity.THEME_DATA, themeSpinner.getSelectedItem().toString());
                intent.putExtra(ListActivity.TYPE_DATA, typeSpinner.getSelectedItem().toString());
                intent.putExtra(ListActivity.STYLE_DATA, styleSpinner.getSelectedItem().toString());
                intent.putExtra(ListActivity.APP_COST, appPrice);
                setResult(ListActivity.RESULT_OK, intent);
                finish();
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        Resources res = getResources();
        Log.d("AppStoreGame","Hi");
        int themePrice = res.getIntArray(R.array.themePriceArray)[themeSpinner.getSelectedItemPosition()];
        int typePrice = res.getIntArray(R.array.typePriceArray)[typeSpinner.getSelectedItemPosition()];
        int stylePrice = res.getIntArray(R.array.stylePriceArray)[styleSpinner.getSelectedItemPosition()];
        appPrice = themePrice + typePrice + stylePrice;
        priceView.setText( appPrice + "g");
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
