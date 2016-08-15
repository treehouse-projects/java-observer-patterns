package com.teamtreehouse.remote;

import com.teamtreehouse.remote.devices.BluRayPlayer;
import com.teamtreehouse.remote.devices.Stereo;

public class RemoteControl {
    private BluRayPlayer bluRayPlayer;
    private Stereo stereo;

    public RemoteControl(BluRayPlayer bluRayPlayer, Stereo stereo) {
        this.bluRayPlayer = bluRayPlayer;
        this.stereo = stereo;
    }

    public void pressPowerButton() {
        bluRayPlayer.togglePower();
        stereo.togglePower();
    }

}
