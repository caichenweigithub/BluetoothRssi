package com.oakraw.bluetoothrssi;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.database.SQLException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.oakraw.bluetoothrssi.adapters.LeDeviceListAdapter;
import com.oakraw.bluetoothrssi.containers.BluetoothLeDeviceStore;
import com.oakraw.bluetoothrssi.data.CoordinateData;
import com.oakraw.bluetoothrssi.data.DataBaseHelper;
import com.oakraw.bluetoothrssi.data.Distance;
import com.oakraw.bluetoothrssi.data.Path;
import com.oakraw.bluetoothrssi.util.BluetoothLeScanner;
import com.oakraw.bluetoothrssi.util.BluetoothUtils;

import java.io.IOException;

import uk.co.alt236.bluetoothlelib.device.BluetoothLeDevice;
import uk.co.alt236.easycursor.objectcursor.EasyObjectCursor;


public class MainActivity extends ListActivity {

    private TextView mTvBluetoothLeStatus;
    private TextView mTvBluetoothStatus;
    private TextView mTvItemCount;
    private BluetoothLeDeviceStore mDeviceStore;
    private BluetoothUtils mBluetoothUtils;
    private BluetoothLeScanner mScanner;
    private LeDeviceListAdapter mLeDeviceListAdapter;
    private CoordinateData coorData;
    private final int DELAY_TIME = 3000;

    final Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        private boolean isInArea(Pair<Integer, Integer> dest, Pair<Integer, Integer> coor){
            if(coor.first >= dest.first - 1 && coor.first <= dest.first + 1 &&
                    coor.second >= dest.second - 1 && coor.second <= dest.second + 1){
                return true;
            }
            return false;
        }

        @Override
        public void run() {
            // Do something after 5s = 5000ms
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String da = Distance.d1+"";
                    String db = Distance.d2+"";
                    String dc = Distance.d3+"";
                    if(Distance.d1 == -1){
                        da = "ออกจากจุด 1";
                    }
                    if(Distance.d2 == -1){
                        db = "ออกจากจุด 2";
                    }
                    if(Distance.d3 == -1){
                        dc = "ออกจากจุด 3";
                    }

                    if(Distance.d1 == -1 && Distance.d2 == -1 && Distance.d3 == -1){
                        coordinateTv.setText("");
                    }else{
                        Pair<Integer,Integer> coor = calculate(Distance.d1, Distance.d2, Distance.d3);
                        coordinateTv.setText(da + " " + db + " " + dc + " coor| " + "x: "+coor.first+" y: "+coor.second);
                        if(Path.selectedRoute.size() != 0) {
                            if (isInArea(Path.selectedRoute.get(0).getCoor(), coor)) {
                                if (mediaPlayer.isPlaying()) {
                                    mediaPlayer.stop();
                                }
                                mediaPlayer = MediaPlayer.create(getApplicationContext(), Path.selectedRoute.get(0).getSound());
                                mediaPlayer.start();
                                Path.selectedRoute.remove(0);
                                coordinateTv.setText(coordinateTv.getText() + " detected");
                            }

                        }
                    }
                    if(mScanner != null) {
                        mScanner.scanLeDevice(-1, false);
                    }
                    invalidateOptionsMenu();

                    startScan();

                    handler.postDelayed(runnable, DELAY_TIME);
                }
            });
        }
    };
    private MediaPlayer mediaPlayer;

    //private Pair<Integer, Double> minimumD;

    private Pair<Integer,Integer> calculate(double da, double db, double dc){
        Pair<Integer, Double> minimumD = new Pair<>(100, 10000000d);
        for(int i=0 ; i< coorData.coor.size(); i++){
            double d1 = coorData.coor.get(i).distance1;
            double d2 = coorData.coor.get(i).distance2;
            double d3 = coorData.coor.get(i).distance3;

            double da1 = Math.pow(da - d1, 2);
            double db2 = Math.pow(db - d2, 2);
            double dc3 = Math.pow(dc - d3, 2);
            double d = Math.sqrt(da1 + db2 + dc3);

            if(d < minimumD.second){
                minimumD = new Pair<>(i, d);
            }
        }

        return new Pair<Integer,Integer>(coorData.coor.get(minimumD.first).x, coorData.coor.get(minimumD.first).y);
    }

    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {

            final BluetoothLeDevice deviceLe = new BluetoothLeDevice(device, rssi, scanRecord, System.currentTimeMillis());
            mDeviceStore.addDevice(deviceLe);
            final EasyObjectCursor<BluetoothLeDevice> c = mDeviceStore.getDeviceCursor();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLeDeviceListAdapter.swapCursor(c);
                    updateItemCount(mLeDeviceListAdapter.getCount());
                }
            });
        }
    };
    private TextView coordinateTv;

    private void updateItemCount(int count){
        mTvItemCount.setText(
                getString(
                        R.string.formatter_item_count,
                        String.valueOf(count)));
    }

    private void displayAboutDialog(){
        // REALLY REALLY LAZY LINKIFIED DIALOG
        final int paddingSizeDp = 5;
        final float scale = getResources().getDisplayMetrics().density;
        final int dpAsPixels = (int) (paddingSizeDp * scale + 0.5f);

        final TextView textView=new TextView(this);
        final SpannableString text = new SpannableString(getString(R.string.about_dialog_text));

        textView.setText(text);
        textView.setAutoLinkMask(RESULT_OK);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setPadding(dpAsPixels, dpAsPixels, dpAsPixels, dpAsPixels);

        Linkify.addLinks(text, Linkify.ALL);
        new AlertDialog.Builder(this)
                .setTitle(R.string.menu_about)
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {}
                })
                .setView(textView)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int type = getIntent().getIntExtra("route",0);
        if(type == 1){
            Path.selectedRoute = Path.route1;
            mediaPlayer = MediaPlayer.create(this, R.raw.routeone);
        }else{
            Path.selectedRoute = Path.route2;
            mediaPlayer = MediaPlayer.create(this, R.raw.routetwo);
        }

        coorData =  new CoordinateData();

        mTvBluetoothLeStatus = (TextView)findViewById(R.id.tvBluetoothLe);
        mTvBluetoothStatus = (TextView)findViewById(R.id.tvBluetoothStatus);
        mTvItemCount = (TextView)findViewById(R.id.tvItemCount);
        coordinateTv = (TextView)findViewById(R.id.coor);

        mDeviceStore = new BluetoothLeDeviceStore();
        mBluetoothUtils = new BluetoothUtils(this);
        mScanner = new BluetoothLeScanner(mLeScanCallback, mBluetoothUtils);
        updateItemCount(0);

        DataBaseHelper myDbHelper;
        myDbHelper = new DataBaseHelper(this);

        mediaPlayer.start();

        try {

            myDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            myDbHelper.openDataBase();

        }catch(SQLException sqle){

            throw sqle;

        }

        startScan();

        handler.postDelayed(runnable, DELAY_TIME);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        if (!mScanner.isScanning()) {
            menu.findItem(R.id.menu_stop).setVisible(false);
            menu.findItem(R.id.menu_scan).setVisible(true);
            menu.findItem(R.id.menu_refresh).setActionView(null);
        } else {
            menu.findItem(R.id.menu_stop).setVisible(true);
            menu.findItem(R.id.menu_scan).setVisible(false);
            menu.findItem(R.id.menu_refresh).setActionView(R.layout.actionbar_progress_indeterminate);
        }

        if(getListView().getCount() > 0){
            menu.findItem(R.id.menu_share).setVisible(true);
        } else {
            menu.findItem(R.id.menu_share).setVisible(false);
        }

        return true;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        final BluetoothLeDevice device = (BluetoothLeDevice) mLeDeviceListAdapter.getItem(position);
        if (device == null) return;

/*
        final Intent intent = new Intent(this, DeviceDetailsActivity.class);
        intent.putExtra(DeviceDetailsActivity.EXTRA_DEVICE, device);

        startActivity(intent);*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_scan:
                startScan();
                break;
            case R.id.menu_stop:
                mScanner.scanLeDevice(-1, false);
                invalidateOptionsMenu();
                break;
            case R.id.menu_about:
                displayAboutDialog();
                break;
            case R.id.menu_share:
                mDeviceStore.shareDataAsEmail(this);
        }
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScanner.scanLeDevice(-1, false);
    }

    @Override
    public void onResume(){
        super.onResume();
        final boolean mIsBluetoothOn = mBluetoothUtils.isBluetoothOn();
        final boolean mIsBluetoothLePresent = mBluetoothUtils.isBluetoothLeSupported();

        if(mIsBluetoothOn){
            mTvBluetoothStatus.setText(R.string.on);
        } else {
            mTvBluetoothStatus.setText(R.string.off);
        }

        if(mIsBluetoothLePresent){
            mTvBluetoothLeStatus.setText(R.string.supported);
        } else {
            mTvBluetoothLeStatus.setText(R.string.not_supported);
        }

        invalidateOptionsMenu();
    }

    private void startScan(){
        final boolean mIsBluetoothOn = mBluetoothUtils.isBluetoothOn();
        final boolean mIsBluetoothLePresent = mBluetoothUtils.isBluetoothLeSupported();
        mDeviceStore.clear();
        updateItemCount(0);

        mLeDeviceListAdapter = new LeDeviceListAdapter(this, mDeviceStore.getDeviceCursor());
        setListAdapter(mLeDeviceListAdapter);

        mBluetoothUtils.askUserToEnableBluetoothIfNeeded();
        if(mIsBluetoothOn && mIsBluetoothLePresent){
            mScanner.scanLeDevice(-1, true);
            invalidateOptionsMenu();
        }
    }
}
