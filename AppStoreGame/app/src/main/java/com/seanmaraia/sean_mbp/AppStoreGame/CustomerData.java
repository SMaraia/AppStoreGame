package com.seanmaraia.sean_mbp.AppStoreGame;

import java.util.List;

/**
 * Created by Haplicity on 11/26/2015.
 */
public class CustomerData {
    CustomerStruct john = new CustomerStruct("John", "Office Worker", 35, 350.00f, 1.2f);
    CustomerStruct jane = new CustomerStruct("Jane", "Secretary", 32, 300.00f, 1.15f);
    CustomerStruct jimmy = new CustomerStruct("Jimmy", "Student", 14, 200.00f, 1.05f);
    CustomerStruct james = new CustomerStruct("James", "Student", 17, 250.00f, 1.10f);
    CustomerStruct jesse = new CustomerStruct("Jesse", "Housewife", 41, 350.00f, 1.10f);

    CustomerStruct getRandomCustomer() {
        int i = (int) (Math.random() * 5);

        switch(i) {
            case 0: return john;
            case 1: return jane;
            case 2: return jimmy;
            case 3: return james;
            case 4: return jesse;
        }

        return john;
    }
}
