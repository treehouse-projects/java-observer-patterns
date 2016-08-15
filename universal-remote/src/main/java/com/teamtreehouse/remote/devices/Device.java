package com.teamtreehouse.remote.devices;

public abstract class Device {
    private boolean isPoweredOn;

    public void announce(String message, Object... args) {
        System.out.printf(getClass().getSimpleName() + ": " + message + "%n", args);
    }

    public void togglePower() {
        isPoweredOn = !isPoweredOn;
        announce("Powered %s", isPoweredOn ? "on" : "off");
    }

}
