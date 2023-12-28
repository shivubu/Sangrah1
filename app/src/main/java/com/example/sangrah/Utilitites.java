package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


import java.lang.reflect.Method;
import java.util.Locale;

public class Utilitites extends AppCompatActivity {
    Button b2;
    ImageButton wifi, bt, fl, air, aud, hot;
    WifiManager wm;
    BluetoothAdapter ba;
    TextToSpeech ts;
    CameraManager cm;
    AudioManager am;
    WebView w;


    private float flag = 0, flag1 = 0, flag2 = 0, flag3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilitites);
        w = (WebView) findViewById(R.id.webview);
        w.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        w.getSettings().setLoadsImagesAutomatically(true);
        w.getSettings().setJavaScriptEnabled(true);
        w.loadUrl("file:///android_asset/gr.gif");
        b2 = (Button) findViewById(R.id.button2);
        wifi = (ImageButton) findViewById(R.id.imageButton10);
        bt = (ImageButton) findViewById(R.id.imageButton11);
        fl = (ImageButton) findViewById(R.id.imageButton12);
        air = (ImageButton) findViewById(R.id.imageButton13);
        aud = (ImageButton) findViewById(R.id.imageButton14);
        bt.setImageResource(R.drawable.bof);
        wifi.setImageResource(R.drawable.w2);
        fl.setImageResource(R.drawable.fof);
        aud.setImageResource(R.drawable.snd);
        wm = (WifiManager) getSystemService(WIFI_SERVICE);
        cm = (CameraManager) getSystemService(CAMERA_SERVICE);
        ba = BluetoothAdapter.getDefaultAdapter();
        am = (AudioManager) getBaseContext().getSystemService(AUDIO_SERVICE);

        ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(1.0f);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Utilitites.this, Mainscreen.class);
                startActivity(i);
                finish();
            }
        });
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    wm.setWifiEnabled(true);
                    wifi.setImageResource(R.drawable.w1);
                    flag = 1;
                    Toast.makeText(Utilitites.this, "Wifi Enabled", Toast.LENGTH_SHORT).show();
                    ts.speak("Wifi Enabled", TextToSpeech.QUEUE_FLUSH, null);
                } else {
                    wm.setWifiEnabled(false);
                    wifi.setImageResource(R.drawable.w2);
                    flag = 0;
                    Toast.makeText(Utilitites.this, "Wifi Disabled", Toast.LENGTH_SHORT).show();
                    ts.speak("Wifi Disabled", TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag1 == 0) {
                    bt.setImageResource(R.drawable.bon);
                    Toast.makeText(Utilitites.this, "Bluetooth Enabled", Toast.LENGTH_SHORT).show();
                    ts.speak("Bluetooth Enabled", TextToSpeech.QUEUE_FLUSH, null);
                    flag1 = 1;
                    if (ActivityCompat.checkSelfPermission(Utilitites.this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    ba.enable();

                } else {
                    bt.setImageResource(R.drawable.bof);
                    Toast.makeText(Utilitites.this, "Bluetooth Disabled", Toast.LENGTH_SHORT).show();
                    ts.speak("Bluetooth Disabled", TextToSpeech.QUEUE_FLUSH, null);
                    flag1 = 0;
                    if (ActivityCompat.checkSelfPermission(Utilitites.this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    ba.disable();

                }

            }
        });
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (flag2 == 0) {
                        String s = cm.getCameraIdList()[0];
                        cm.setTorchMode(s, true);
                        fl.setImageResource(R.drawable.fon);
                        Toast.makeText(Utilitites.this, "Flash Enabled", Toast.LENGTH_SHORT).show();
                        ts.speak("Flash Enabled", TextToSpeech.QUEUE_FLUSH, null);
                        flag2 = 1;
                    } else {
                        String s = cm.getCameraIdList()[0];
                        cm.setTorchMode(s, false);
                        fl.setImageResource(R.drawable.fof);
                        Toast.makeText(Utilitites.this, "Flash Disabled", Toast.LENGTH_SHORT).show();
                        ts.speak("Flash Disabled", TextToSpeech.QUEUE_FLUSH, null);
                        flag2 = 0;
                    }
                } catch (CameraAccessException e) {

                }
            }
        });
        air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag3 == 0) {
                    wm.setWifiEnabled(false);
                    air.setImageResource(R.drawable.aon);
                    flag3=1;
                    Toast.makeText(Utilitites.this, "Airplane Mode Enabled", Toast.LENGTH_SHORT).show();
                    ts.speak("Airplane Mode Enabled",TextToSpeech.QUEUE_FLUSH,null);
                    if (ActivityCompat.checkSelfPermission(Utilitites.this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    ba.disable();


                }
                else {
                    wm.setWifiEnabled(true);
                    ba.enable();
                    air.setImageResource(R.drawable.aof);
                    flag3=0;
                    Toast.makeText(Utilitites.this, "Airplane Mode Disabled", Toast.LENGTH_SHORT).show();
                    ts.speak("Airplane Mode Disabled",TextToSpeech.QUEUE_FLUSH,null);
                }

            }
        });
        aud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(am.getRingerMode()==2)
                {
                    am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                    aud.setImageResource(R.drawable.vib);

                    Toast.makeText(Utilitites.this, "Vibrate Mode Enabled", Toast.LENGTH_SHORT).show();
                    ts.speak("Vibrate Mode Enabled",TextToSpeech.QUEUE_FLUSH,null);


                }
                else if(am.getRingerMode()==1)
                {
                    am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    aud.setImageResource(R.drawable.snd);
                    Toast.makeText(Utilitites.this, "Sound Mode Enabled", Toast.LENGTH_SHORT).show();
                    ts.speak("Sound Mode Enabled",TextToSpeech.QUEUE_FLUSH,null);

                }

            }
        });


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(Utilitites.this, Mainscreen.class);
        startActivity(i);
        finish();
    }

}