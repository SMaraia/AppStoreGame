package com.seanmaraia.sean_mbp.AppStoreGame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    Context context;

    static final int CREATOR_ACTIVITY_REQUEST = 1;
    static final int HAGGLE_ACTIVITY_REQUEST = 2;
    public final static String THEME_DATA = "THEME";
    public final static String TYPE_DATA = "TYPE";
    public final static String STYLE_DATA = "STYLE";
    public final static String GOLD_DATA = "GOLD";
    public final static String APP_COST = "COST";
    public final static String SUCCESS_DATA = "SUCCESS";

    Button mTestCreateButton, mStartDayButton;
    TextView mPlayerGoldText;
    RecyclerView mRecyclerView;
    AppItemAdapter mAdapter;
    ArrayList<AppItem> mData;

    PlayerData player;
    private Handler handler;
    private int runs;
    private Boolean waiting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity);

        context = getApplicationContext();

        handler = new Handler();
        player = new PlayerData();

        mPlayerGoldText = (TextView)findViewById(R.id.playerGold);


        mTestCreateButton = (Button)findViewById(R.id.testcreate_button);
        mTestCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!waiting) {
                    Intent intent = new Intent(ListActivity.this, CreatorActivity.class);
                    intent.putExtra("PLAYER_GOLD", player.gold);
                    Log.d("ListActivity", player.gold + "");
                    startActivityForResult(intent, CREATOR_ACTIVITY_REQUEST);
                }
            }
        });

        DataStore dataStore = DataStore.get(this);
        mData = dataStore.getData();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new AppItemAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);

        mPlayerGoldText.setText(player.gold + "g");

        mStartDayButton = (Button)findViewById(R.id.startday_button);
        mStartDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mData.size() > 0 && !waiting) {
                    runs = 0;
                    player.gold -= 50;
                    waiting = true;
                    handler.postDelayed(runnable, 300);
                }
            }
        });


    }

    public void onPause() {
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

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
             if(runs < 3) {

                 runs += 1;

                 Intent intent = new Intent(ListActivity.this, HaggleActivity.class);
                 startActivityForResult(intent, HAGGLE_ACTIVITY_REQUEST);
             }
            else
             {
                 waiting = false;
                 player.day += 1;
             }
        }
    };

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
                double appCost = data.getIntExtra(APP_COST, 0);

                AppItem tempItem = new AppItem();
                tempItem.index = mData.size();
                tempItem.theme = themeString;
                tempItem.type = typeString;
                tempItem.style = styleString;
                tempItem.birthDay = player.day;
                tempItem.price = appCost;
                player.gold -= appCost;
                mData.add(tempItem);
            }
        }

        if (requestCode == HAGGLE_ACTIVITY_REQUEST) {
            if (resultCode == RESULT_OK) {
                float goldFloat = data.getFloatExtra(GOLD_DATA, 0);
                boolean success = data.getBooleanExtra(SUCCESS_DATA, false);

                if (success) {
                    Toast toast = Toast.makeText(context, "Your app was purchased!", Toast.LENGTH_SHORT);
                    toast.show();
                    player.gold += goldFloat;
                } else {
                    Toast toast = Toast.makeText(context, "The customer left!", Toast.LENGTH_SHORT);
                    toast.show();
                }

                waiting = false;
                handler.postDelayed(runnable, 1500);
            }
        }

        mPlayerGoldText.setText(player.gold + "g");
    }
}