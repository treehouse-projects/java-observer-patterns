package com.teamtreehouse.restaurant.core;

import java.util.concurrent.TimeUnit;


public class Utilities {

    public static void passTime(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
