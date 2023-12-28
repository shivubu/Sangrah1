package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Sense extends AppCompatActivity implements SensorEventListener {
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;
    ImageView iv;
    ImageButton ret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        ret=(ImageButton)findViewById(R.id.imageButton28);
        iv=(ImageView)findViewById(R.id.imageView8);
        iv.setImageResource(R.drawable.of2);
        mp=MediaPlayer.create(Sense.this,R.raw.r);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
                sm.unregisterListener(Sense.this);
                Intent i = new Intent(Sense.this,Mainscreen.class);
                startActivity(i);
                finish();
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x=sensorEvent.values[0];
        int x1=(int) x;
        if(x1!=0)
        {
            mp.start();
            iv.setImageResource(R.drawable.on2);

        }
        else
        {
            mp.pause();
            iv.setImageResource(R.drawable.of2);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.pause();
        sm.unregisterListener(this);
        Intent i = new Intent(Sense.this, Mainscreen.class);
        startActivity(i);
        finish();
    }

    public void onPause()
    {
        super.onPause();
        sm.unregisterListener(this);
    }
    public void onResume()
    {
        super.onResume();
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
}