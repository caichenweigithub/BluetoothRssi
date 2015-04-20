package com.oakraw.bluetoothrssi.data;

import android.util.Pair;

import java.util.ArrayList;

/**
 * Created by Rawipol on 3/31/15 AD.
 */
public class RssiData {
    public static ArrayList<Pair<Integer, Double>> rssi1;
    public static ArrayList<Pair<Integer, Double>> rssi2;
    public static ArrayList<Pair<Integer, Double>> rssi3;
    static {
        rssi1 = new ArrayList<>();
        rssi1.add(new Pair<Integer, Double>(-66,0.5d));
        rssi1.add(new Pair<Integer, Double>(-67,0.9d));
        rssi1.add(new Pair<Integer, Double>(-68,1.2d));
        rssi1.add(new Pair<Integer, Double>(-69,1.5d));
        rssi1.add(new Pair<Integer, Double>(-70,1.9d));
        rssi1.add(new Pair<Integer, Double>(-71,2.2d));
        rssi1.add(new Pair<Integer, Double>(-72,2.5d));
        rssi1.add(new Pair<Integer, Double>(-73,2.8d));
        rssi1.add(new Pair<Integer, Double>(-74,3.2d));
        rssi1.add(new Pair<Integer, Double>(-75,3.5d));
        rssi1.add(new Pair<Integer, Double>(-76,3.8d));
        rssi1.add(new Pair<Integer, Double>(-77,4.2d));
        rssi1.add(new Pair<Integer, Double>(-78,4.5d));
        rssi1.add(new Pair<Integer, Double>(-79,4.8d));
        rssi1.add(new Pair<Integer, Double>(-80,5.1d));
        rssi1.add(new Pair<Integer, Double>(-81,5.5d));
        rssi1.add(new Pair<Integer, Double>(-82,5.8d));
        rssi1.add(new Pair<Integer, Double>(-83,6.1d));
        rssi1.add(new Pair<Integer, Double>(-84,6.4d));
        rssi1.add(new Pair<Integer, Double>(-85,6.7d));
        rssi1.add(new Pair<Integer, Double>(-86,7.0d));
        rssi1.add(new Pair<Integer, Double>(-87,7.3d));
        rssi1.add(new Pair<Integer, Double>(-88,7.6d));
        rssi1.add(new Pair<Integer, Double>(-89,7.9d));
        rssi1.add(new Pair<Integer, Double>(-90,8.2d));
        rssi1.add(new Pair<Integer, Double>(-91,8.5d));
        rssi1.add(new Pair<Integer, Double>(-92,8.8d));


        rssi2 = new ArrayList<>();
        rssi2.add(new Pair<Integer, Double>(-71,1.2d));
        rssi2.add(new Pair<Integer, Double>(-72,1.6d));
        rssi2.add(new Pair<Integer, Double>(-73,1.9d));
        rssi2.add(new Pair<Integer, Double>(-74,2.2d));
        rssi2.add(new Pair<Integer, Double>(-75,2.5d));
        rssi2.add(new Pair<Integer, Double>(-76,2.8d));
        rssi2.add(new Pair<Integer, Double>(-77,3.0d));
        rssi2.add(new Pair<Integer, Double>(-78,3.3d));
        rssi2.add(new Pair<Integer, Double>(-79,3.5d));
        rssi2.add(new Pair<Integer, Double>(-80,3.7d));
        rssi2.add(new Pair<Integer, Double>(-81,4.0d));
        rssi2.add(new Pair<Integer, Double>(-82,4.1d));
        rssi2.add(new Pair<Integer, Double>(-83,4.3d));
        rssi2.add(new Pair<Integer, Double>(-84,4.5d));
        rssi2.add(new Pair<Integer, Double>(-85,4.6d));
        rssi2.add(new Pair<Integer, Double>(-86,4.8d));
        rssi2.add(new Pair<Integer, Double>(-87,4.9d));
        rssi2.add(new Pair<Integer, Double>(-88,5.0d));
        rssi2.add(new Pair<Integer, Double>(-89,5.1d));
        rssi2.add(new Pair<Integer, Double>(-90,5.2d));
        rssi2.add(new Pair<Integer, Double>(-91,5.3d));


        rssi3 = new ArrayList<>();
        rssi3.add(new Pair<Integer, Double>(-66,0.8d));
        rssi3.add(new Pair<Integer, Double>(-67,1.2d));
        rssi3.add(new Pair<Integer, Double>(-68,1.7d));
        rssi3.add(new Pair<Integer, Double>(-69,2.0d));
        rssi3.add(new Pair<Integer, Double>(-70,2.3d));
        rssi3.add(new Pair<Integer, Double>(-71,2.6d));
        rssi3.add(new Pair<Integer, Double>(-72,2.8d));
        rssi3.add(new Pair<Integer, Double>(-73,2.9d));
        rssi3.add(new Pair<Integer, Double>(-74,3.0d));
        rssi3.add(new Pair<Integer, Double>(-75,3.1d));
        rssi3.add(new Pair<Integer, Double>(-76,3.2d));
        rssi3.add(new Pair<Integer, Double>(-77,3.3d));
        rssi3.add(new Pair<Integer, Double>(-78,3.3d));
        rssi3.add(new Pair<Integer, Double>(-79,3.4d));
        rssi3.add(new Pair<Integer, Double>(-80,3.5d));
        rssi3.add(new Pair<Integer, Double>(-81,3.5d));
        rssi3.add(new Pair<Integer, Double>(-82,3.6d));
        rssi3.add(new Pair<Integer, Double>(-83,3.7d));
        rssi3.add(new Pair<Integer, Double>(-84,3.9d));
        rssi3.add(new Pair<Integer, Double>(-85,4.0d));
        rssi3.add(new Pair<Integer, Double>(-86,4.2d));
        rssi3.add(new Pair<Integer, Double>(-87,4.5d));
        rssi3.add(new Pair<Integer, Double>(-88,4.8d));
        rssi3.add(new Pair<Integer, Double>(-89,5.2d));
        rssi3.add(new Pair<Integer, Double>(-90,5.6d));
        rssi3.add(new Pair<Integer, Double>(-91,6.1d));
        rssi3.add(new Pair<Integer, Double>(-92,6.7d));
        rssi3.add(new Pair<Integer, Double>(-93,7.3d));
        rssi3.add(new Pair<Integer, Double>(-94,8.1d));
        rssi3.add(new Pair<Integer, Double>(-95,9.0d));

    }

    public static double findDistance(int no, int rssi){
        ArrayList<Pair<Integer, Double>> rssies;
        double distance = -1;
        switch (no)
        {
            case 1:
                rssies = rssi1;
                break;
            case 2:
                rssies = rssi2;
                break;
            default:
                rssies = rssi3;
        }

        for(int i=0; i<rssies.size();i++){
            if(rssies.get(i).first == rssi){
                distance = rssies.get(i).second;
                break;
            }
        }

        return distance;
    }
}
