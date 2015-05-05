package com.oakraw.bluetoothrssi;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.oakraw.bluetoothrssi.custom.GestureLayout;


public class HomeActivity extends Activity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        GestureLayout bg = (GestureLayout) findViewById(R.id.bg);
        mediaPlayer = MediaPlayer.create(this, R.raw.first);
        mediaPlayer.start();


        bg.setOnDoubleClickListener(new GestureLayout.OnDoubleClickListener() {
            @Override
            public void onDoubleClick(int type) {
                if(type == 1) {
                    Toast.makeText(getApplicationContext(), "เบือกเส้นทางที่ 1", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "เบือกเส้นทางที่ 2", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("route", type);
                mediaPlayer.stop();
                startActivity(intent);
            }
        });
    }

}
