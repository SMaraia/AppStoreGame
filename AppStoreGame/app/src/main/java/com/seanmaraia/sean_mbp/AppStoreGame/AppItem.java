package com.seanmaraia.sean_mbp.AppStoreGame;

/**
 * Created by Sean-MBP on 9/18/15.
 */
public class AppItem {
    public int index, birthDay;
    public double price;
    public String theme, type, style;

    public AppItem(){
        index = -1;
        theme = "THEME";
        type = "TYPE";
        style = "STYLE";
        price = 0.00;
        birthDay = -1;
    }

}
