package com.teamtreehouse.remote;

import com.teamtreehouse.remote.devices.AppleTv;
import com.teamtreehouse.remote.devices.BluRayPlayer;
import com.teamtreehouse.remote.devices.Stereo;

public class Application {
    public static void main(String[] args) {
        RemoteControl rc = new RemoteControl();
        BluRayPlayer bluRay = new BluRayPlayer();
        Stereo stereo = new Stereo();
        AppleTv tv = new AppleTv();
        rc.addDevice(bluRay);
        rc.addDevice(stereo);
        rc.addDevice(tv);

        rc.pressPowerButton();
        rc.pressPowerButton();
    }
}
