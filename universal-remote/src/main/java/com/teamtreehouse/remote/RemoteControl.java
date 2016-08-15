package com.teamtreehouse.remote;

import com.teamtreehouse.remote.devices.BluRayPlayer;
import com.teamtreehouse.remote.devices.Device;
import com.teamtreehouse.remote.devices.Stereo;

import java.util.ArrayList;
import java.util.List;

public class RemoteControl {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void pressPowerButton() {
        for (Device device : devices) {
            device.togglePower();
        }
    }

}
