package com.seanmaraia.sean_mbp.listdemospm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.View;
import android.widget.RelativeLayout;

import java.text.SimpleDateFormat;
=======

>>>>>>> 3b56c04ecccf62bbd32a4469ad39fceed641ee71
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

<<<<<<< HEAD
    Button testcreateButton;
=======
    RecyclerView mRecyclerView;
    AppItemAdapter mAdapter;
    ArrayList<AppItem> mData;
>>>>>>> 3b56c04ecccf62bbd32a4469ad39fceed641ee71

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity);

<<<<<<< HEAD
        testcreateButton = (Button)findViewById(R.id.testcreate_button);
        testcreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, CreatorActivity.class);
                startActivity(intent);
            }
        });
=======
        DataStore dataStore = DataStore.get(this);
        mData = dataStore.getData();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new AppItemAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);

>>>>>>> 3b56c04ecccf62bbd32a4469ad39fceed641ee71
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
