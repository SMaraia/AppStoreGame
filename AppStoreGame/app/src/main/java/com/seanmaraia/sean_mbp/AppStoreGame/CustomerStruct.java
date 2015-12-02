package com.seanmaraia.sean_mbp.AppStoreGame;

/**
 * Created by Haplicity on 11/26/2015.
 */
public class CustomerStruct {
    String name;
    String occupation;
    int age;
    float maxGold;
    float maxMarkup;
    String introduction;
    String highPriceResponse;
    String highMarkupResponse;
    String purchaseResponse;

    public CustomerStruct(String n, String o, int a, float mG, float mM) {
        name = n;
        occupation = o;
        age = a;
        maxGold = mG;
        maxMarkup = mM;
    }
}
