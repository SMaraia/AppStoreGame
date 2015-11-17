package com.seanmaraia.sean_mbp.AppStoreGame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    static final int CREATOR_ACTIVITY_REQUEST = 1;
    static final int HAGGLE_ACTIVITY_REQUEST = 2;
    public final static String THEME_DATA = "THEME";
    public final static String TYPE_DATA = "TYPE";
    public final static String STYLE_DATA = "STYLE";
    public final static String GOLD_DATA = "GOLD";

    Button mTestCreateButton, mTestHaggleButton;

    RecyclerView mRecyclerView;
    AppItemAdapter mAdapter;
    ArrayList<AppItem> mData;

    PlayerData player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity);

        player = new PlayerData();

        mTestCreateButton = (Button)findViewById(R.id.testcreate_button);
        mTestCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, CreatorActivity.class);
                startActivityForResult(intent, CREATOR_ACTIVITY_REQUEST);
            }
        });

        mTestHaggleButton = (Button)findViewById(R.id.testhaggle_button);
        mTestHaggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, HaggleActivity.class);
                startActivityForResult(intent, HAGGLE_ACTIVITY_REQUEST);
            }
        });

        DataStore dataStore = DataStore.get(this);
        mData = dataStore.getData();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new AppItemAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void onPause(){
        super.onPause();
        DataStore dataStore = DataStore.get(this);
        dataStore.commitChanges(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == CREATOR_ACTIVITY_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // Retrieve the data
                String themeString = data.getStringExtra(THEME_DATA);
                String typeString = data.getStringExtra(TYPE_DATA);
                String styleString = data.getStringExtra(STYLE_DATA);

                AppItem tempItem = new AppItem();
                tempItem.index = mData.size();
                tempItem.theme = themeString;
                tempItem.type = typeString;
                tempItem.style = styleString;
                mData.add(tempItem);
            }
        }

        if (requestCode == HAGGLE_ACTIVITY_REQUEST) {
            if (resultCode == RESULT_OK) {
                float goldFloat = data.getFloatExtra(GOLD_DATA, 0);

                player.gold += goldFloat;

                //mTestHaggleButton.setText(""+player.gold);
            }
        }
    }
}