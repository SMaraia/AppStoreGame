package com.seanmaraia.sean_mbp.AppStoreGame;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by Sean-MBP on 9/14/15.
 */
public class DataStore {
    private static DataStore sDataStore;
    private ArrayList<AppItem> mData;
    private int mNumTimesRun;
    private PlayerData player;

    public static final String PREFS_NAME = "DATA_STORE_PREFERENCES";
    public static final String KEY_NUM_TIMES_RUN = "NUM_TIMES_RUN";
    public static final String KEY_ITEMS_STRING = "ITEMS_STRING";
    public static final String PLAYER_DATA_DAY_STRING = "DAY_STRING";
    public static final String PLAYER_DATA_GOLD_STRING = "GOLD_STRING";
    //getter
    public static DataStore get(Context context) {
        if(sDataStore == null) {
            sDataStore = new DataStore(context);
        }
        return sDataStore;
    }

    private DataStore(Context context){
        mData = new ArrayList<>();
        player = new PlayerData();
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        mNumTimesRun = settings.getInt(KEY_NUM_TIMES_RUN, 0);

        String arrayListAsJson = settings.getString(KEY_ITEMS_STRING, "[]");
        Gson gson = new Gson();
        int day = settings.getInt(PLAYER_DATA_DAY_STRING, 0);
        float gold = settings.getFloat(PLAYER_DATA_GOLD_STRING, 200.0f);
        ArrayList<AppItem> array = gson.fromJson(arrayListAsJson, new TypeToken<ArrayList<AppItem>>(){}.getType());
        Log.d("DataStore", "reading string - arrayListToJson" + arrayListAsJson);
        mData = array;
        player.gold = gold;
        player.day = day;

    }

    public boolean commitChanges(Context context){
        SharedPreferences pref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = pref.edit();

        editor.putInt(KEY_NUM_TIMES_RUN, mNumTimesRun);

        Gson gson = new GsonBuilder().create();

        String arrayListToJson = gson.toJson(mData);
        Log.d("DataStore", "Saving string - arrayListToJson=" + arrayListToJson);

        editor.putString(KEY_ITEMS_STRING, arrayListToJson);

        editor.putInt(PLAYER_DATA_DAY_STRING, player.day);
        editor.putFloat(PLAYER_DATA_GOLD_STRING, player.gold);

        boolean success = editor.commit();
        return success;
    }

    public int getNumTimesRun() {
        return mNumTimesRun;
    }

    public void setNumTimesRun(int numTimesRun) {
        mNumTimesRun = numTimesRun;
    }

    public ArrayList<AppItem> getData() {
        return mData;
    }

    public PlayerData getPlayer() {return player;}
}
