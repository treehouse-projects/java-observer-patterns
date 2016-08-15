package com.teamtreehouse.goldwatcher;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class GoldMedalReporter {
    private Map<String, Consumer<String>> observers = new HashMap<>();


    public void addObserver(String key, Consumer<String> observer) {
        observers.put(key, observer);
    }

    public void removeObserver(String key) {
        observers.remove(key);
    }

    public void notifyObservers(String country) {
        observers.values().forEach(fn -> fn.accept(country));
    }


    public void reportWin(String country) {
        System.out.println("Gold medal awarded to " + country);
        notifyObservers(country);
    }



}
