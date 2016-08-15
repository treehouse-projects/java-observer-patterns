package com.teamtreehouse.goldwatcher.tools;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LedLight {

    public void flashColors(String... colors) {
        System.out.println("LedLight:  Flashing " +
                Stream.of(colors).collect(Collectors.joining(", ")));
    }
}
