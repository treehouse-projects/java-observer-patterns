package com.teamtreehouse.remote;

import com.teamtreehouse.remote.devices.BluRayPlayer;
import com.teamtreehouse.remote.devices.Stereo;

public class Application {
    public static void main(String[] args) {
        BluRayPlayer bluRay = new BluRayPlayer();
        Stereo stereo = new Stereo();
        RemoteControl rc = new RemoteControl(bluRay, stereo);
        rc.pressPowerButton();
        rc.pressPowerButton();
    }
}
