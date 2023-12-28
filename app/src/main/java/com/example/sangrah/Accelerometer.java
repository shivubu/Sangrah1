package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;
    ImageButton ret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelometer);
        ret=(ImageButton)findViewById(R.id.imageButton44);
        mp= MediaPlayer.create(Accelerometer.this ,R.raw.r);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener( this,s,SensorManager.SENSOR_DELAY_NORMAL);
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sm.unregisterListener(Accelerometer.this);
                mp.pause();
                Intent i = new Intent(Accelerometer.this,Mainscreen.class);
                startActivity(i);
                finish();
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];
        int x1=(int)x;
        int y1=(int)y;
        int z1=(int)z;
        if(x1!=0)
        {
            mp.start();
            Toast.makeText(this, "Movement Detected", Toast.LENGTH_SHORT).show();
        }
        else
        {
            mp.pause();
            Toast.makeText(this, "No Movement Detected", Toast.LENGTH_SHORT).show();
            mp=MediaPlayer.create(Accelerometer.this,R.raw.r);
        }



    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        sm.unregisterListener(Accelerometer.this);
        mp.pause();
        Intent i = new Intent(Accelerometer.this, Mainscreen.class);
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