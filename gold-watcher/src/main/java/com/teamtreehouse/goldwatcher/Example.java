package com.teamtreehouse.goldwatcher;

import com.teamtreehouse.goldwatcher.tools.LedLight;
import com.teamtreehouse.goldwatcher.tools.MegaTron;
import com.teamtreehouse.goldwatcher.tools.Tweeter;

import java.util.HashMap;
import java.util.Map;

public class Example {



    public static void main(String[] args) {
        GoldMedalReporter reporter = new GoldMedalReporter();
        MegaTron megaTron = new MegaTron();
        LedLight light = new LedLight();
        Map<String, String[]> colorsByCountry = getColorsByCountry();

        reporter.addObserver("tweet",
                country -> Tweeter.tweet(country + " just won the Gold!  #olympics"));
        reporter.addObserver("megatron", megaTron::display);
        reporter.addObserver("lights", country -> light.flashColors(colorsByCountry.get(country)));

        reporter.reportWin("USA");
    }

    private static Map<String, String[]> getColorsByCountry() {
        Map<String, String[]> colorsByCountry = new HashMap<>();
        colorsByCountry.put("USA", new String[]{"Red", "White", "Blue"});
        colorsByCountry.put("Brazil", new String[]{"Dark Green", "Blue", "Yellow", "White"});
        // ...
        return colorsByCountry;
    }
}
