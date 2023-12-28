package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Sensor2 extends AppCompatActivity implements SensorEventListener {
    ImageView iv;
    MediaPlayer mp;
    CameraManager cm;
    WifiManager wm;
    BluetoothAdapter bm;
    SensorManager sm;
    Sensor s;
    ImageButton ret;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor2);
        ret = (ImageButton) findViewById(R.id.imageButton34);
        iv = (ImageView) findViewById(R.id.imageView9);
        mp = MediaPlayer.create(Sensor2.this, R.raw.r);
        cm = (CameraManager)getSystemService(CAMERA_SERVICE);
        wm = (WifiManager)getSystemService(WIFI_SERVICE);
        bm = BluetoothAdapter.getDefaultAdapter();
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(Sensor2.this, s, SensorManager.SENSOR_DELAY_NORMAL);
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
                sm.unregisterListener(Sensor2.this);
                Intent i = new Intent(Sensor2.this, Mainscreen.class);
                startActivity(i);
                finish();
            }
        });


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];
        int x1 = (int) x;
        int y1 = (int) y;
        int z1 = (int) z;
        if (x1 !=0 ) {
            mp.start();
            wm.setWifiEnabled(true);
            iv.setImageResource(R.drawable.on2);
            Toast.makeText(Sensor2.this, "Tilt Kyun kiya ?", Toast.LENGTH_SHORT).show();
            try {
                String s = cm.getCameraIdList()[0];
                cm.setTorchMode(s, true);
            } catch (CameraAccessException e) {

            }
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }

            bm.enable();

        } else {
            mp.pause();
            wm.setWifiEnabled(false);
            iv.setImageResource(R.drawable.of2);
            Toast.makeText(Sensor2.this, "Seedha kyun kiya ?", Toast.LENGTH_SHORT).show();
            try
            {
                String s=cm.getCameraIdList()[0];
                cm.setTorchMode(s,false);
            }
            catch (CameraAccessException e)
            {

            }
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            bm.disable();
            mp = MediaPlayer.create(Sensor2.this, R.raw.r);

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
        Intent i = new Intent(Sensor2.this, Mainscreen.class);
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