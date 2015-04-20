package com.oakraw.bluetoothrssi.data;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Rawipol on 3/31/15 AD.
 */
public class CoordinateData {
    public class Dataset{
        public int x;
        public int y;
        public double distance1;
        public double distance2;
        public double distance3;

        public Dataset(int x, int y, double distance1, double distance2, double distance3) {
            this.x = x;
            this.y = y;
            this.distance1 = distance1;
            this.distance2 = distance2;
            this.distance3 = distance3;
        }
    }

    public ArrayList<Dataset> coor;

    public CoordinateData(){
        coor = new ArrayList<>();
        coor.add(new Dataset(1,1,1,7.1,9.1));
        coor.add(new Dataset(1,2,2,6.4,9.2));
        coor.add(new Dataset(1,3,3,5.8,9.5));
        coor.add(new Dataset(1,4,4,5.4,9.8));
        coor.add(new Dataset(1,5,5,5.1,10.3));

        coor.add(new Dataset(2,1,1.4,6.4,8.1));
        coor.add(new Dataset(2,2,2.2,5.7,8.2));
        coor.add(new Dataset(2,3,3.2,5,8.5));
        coor.add(new Dataset(2,4,4.1,4.5,8.9));
        coor.add(new Dataset(2,5,5.1,4.1,9.4));

        coor.add(new Dataset(3,1,2.2,5.8,7.1));
        coor.add(new Dataset(3,2,2.8,5.0,7.3));
        coor.add(new Dataset(3,3,3.6,4.2,7.6));
        coor.add(new Dataset(3,4,4.5,3.6,8.1));
        coor.add(new Dataset(3,5,5.4,3.2,8.6));

        coor.add(new Dataset(4,1,3.2,5.4,6.1));
        coor.add(new Dataset(4,2,3.6,4.5,6.3));
        coor.add(new Dataset(4,3,4.2,3.6,6.7));
        coor.add(new Dataset(4,4,5.0,2.8,7.2));
        coor.add(new Dataset(4,5,5.8,2.2,7.8));

        coor.add(new Dataset(5,1,4.1,5.1,5.1));
        coor.add(new Dataset(5,2,4.5,4.1,5.4));
        coor.add(new Dataset(5,3,5.0,3.2,5.8));
        coor.add(new Dataset(5,4,5.7,2.2,6.4));
        coor.add(new Dataset(5,5,6.4,1.4,7.1));

        coor.add(new Dataset(6,1,5.1,5,4.1));
        coor.add(new Dataset(6,2,5.4,4,4.5));
        coor.add(new Dataset(6,3,5.8,3,5.0));
        coor.add(new Dataset(6,4,6.4,2,5.7));
        coor.add(new Dataset(6,5,7.1,1,6.4));

        coor.add(new Dataset(7,1,6.1,5.1,3.2));
        coor.add(new Dataset(7,2,6.3,4.1,4.6));
        coor.add(new Dataset(7,3,6.7,3.2,3.2));
        coor.add(new Dataset(7,4,7.2,2.2,5.0));
        coor.add(new Dataset(7,5,7.8,1.4,5.8));

        coor.add(new Dataset(8,1,7.1,5.4,2.2));
        coor.add(new Dataset(8,2,7.3,4.5,2.8));
        coor.add(new Dataset(8,3,7.6,3.6,3.6));
        coor.add(new Dataset(8,4,8.1,2.8,4.5));
        coor.add(new Dataset(8,5,8.6,2.2,5.4));

        coor.add(new Dataset(9,1,8.1,5.8,1.4));
        coor.add(new Dataset(9,2,8.2,5.0,2.2));
        coor.add(new Dataset(9,3,8.5,4.2,3.2));
        coor.add(new Dataset(9,4,8.9,3.6,4.1));
        coor.add(new Dataset(9,5,9.4,3.2,5.1));

        coor.add(new Dataset(10,1,9.1,6.4,1.0));
        coor.add(new Dataset(10,2,9.2,5.7,2.0));
        coor.add(new Dataset(10,3,9.5,5.0,3.0));
        coor.add(new Dataset(10,4,9.8,4.5,4.0));
        coor.add(new Dataset(10,5,10.3,4.1,5.0));
    }
}
