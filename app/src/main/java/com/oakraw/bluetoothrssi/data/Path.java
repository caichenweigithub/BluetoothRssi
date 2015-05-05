package com.oakraw.bluetoothrssi.data;

import android.util.Pair;

import com.oakraw.bluetoothrssi.R;

import java.util.ArrayList;

/**
 * Created by Rawipol on 4/30/15 AD.
 */
public class Path {
    public static ArrayList<Node> selectedRoute;
    public static ArrayList<Node> route1;
    public static ArrayList<Node> route2;
    static{
        route1 = new ArrayList<>();

        route1.add(new Node(new Pair<Integer, Integer>(7,3), R.raw.right));
        route1.add(new Node(new Pair<Integer, Integer>(5,3), R.raw.straight));
        route1.add(new Node(new Pair<Integer, Integer>(3,3), R.raw.left));
        route1.add(new Node(new Pair<Integer, Integer>(3,1), R.raw.end));

        route2 = new ArrayList<>();

        route2.add(new Node(new Pair<Integer, Integer>(3,1), R.raw.tworight));
        route2.add(new Node(new Pair<Integer, Integer>(3,3), R.raw.right));
        route2.add(new Node(new Pair<Integer, Integer>(5,3), R.raw.straight));
        route2.add(new Node(new Pair<Integer, Integer>(7,3), R.raw.end));

    }
}
