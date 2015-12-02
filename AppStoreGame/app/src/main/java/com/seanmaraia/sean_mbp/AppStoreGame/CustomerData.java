package com.seanmaraia.sean_mbp.AppStoreGame;

import java.util.List;

/**
 * Created by Haplicity on 11/26/2015.
 */
public class CustomerData {
    CustomerStruct john = new CustomerStruct("John", "Office Worker", 35, 499.99f, 1.2f);
    CustomerStruct jane = new CustomerStruct("Jane", "Secretary", 32, 499.99f, 1.15f);
    CustomerStruct timmy = new CustomerStruct("Timmy", "Student", 14, 499.99f, 1.05f);

    CustomerStruct getRandomCustomer() {
        int i = (int) Math.random() * 3;

        switch(i) {
            case 0: return john;
            case 1: return jane;
            case 2: return timmy;
        }

        return john;
    }
}
