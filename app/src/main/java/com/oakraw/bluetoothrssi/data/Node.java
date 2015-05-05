package com.oakraw.bluetoothrssi.data;

import android.util.Pair;

/**
 * Created by Rawipol on 4/30/15 AD.
 */
public class Node {
    private Pair<Integer, Integer> coor;
    private int soundRes;

    public Node(Pair<Integer, Integer> coor, int soundRes) {
        this.coor = coor;
        this.soundRes = soundRes;
    }

    public Pair<Integer, Integer> getCoor() {
        return coor;
    }

    public int getSound() {
        return soundRes;
    }
}
