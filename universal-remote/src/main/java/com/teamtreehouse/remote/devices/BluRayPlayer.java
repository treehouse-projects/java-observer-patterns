package com.teamtreehouse.remote.devices;

public class BluRayPlayer extends Device {

    public void play() {
        announce("bzzzz...playing your video now");
    }

    public void pause() {
        announce("click....pausing your video");
    }

}
