package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;

import java.util.Locale;

public class AllinOne extends AppCompatActivity {
    WifiManager wm;
    BluetoothAdapter ba;
    CameraManager cm;
    ImageButton ib,ib2,ib3;
    TextToSpeech ts;
    MediaPlayer mp;
    private boolean flag=false ,flag1=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allin_one);
        ib=(ImageButton)findViewById(R.id.imageButton29);
        ib2=(ImageButton)findViewById(R.id.imageButton31);
        ib3=(ImageButton)findViewById(R.id.imageButton32);
        wm=(WifiManager)getSystemService(WIFI_SERVICE);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        mp=MediaPlayer.create(this , R.raw.r);
        ba=BluetoothAdapter.getDefaultAdapter();
        ts= new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(1.0f);
            }
        });
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(flag==false)
                {
                    try {
                        String s = cm.getCameraIdList()[0];
                        cm.setTorchMode(s,true);
                        ba.enable();
                        wm.setWifiEnabled(true);
                        flag=true;
                        ib.setImageResource(R.drawable.on2);
                        ts.speak("The features have been turned on",TextToSpeech.QUEUE_FLUSH,null);

                    }
                    catch(CameraAccessException e)
                    {

                    }


                }
                else if(flag == true)
                {
                    try {
                        String s = cm.getCameraIdList()[0];
                        cm.setTorchMode(s,false);
                        ba.disable();
                        wm.setWifiEnabled(false);
                        flag=false;
                        ib.setImageResource(R.drawable.of2);
                        ts.speak("The features have been turned off",TextToSpeech.QUEUE_FLUSH,null);

                    }
                    catch(CameraAccessException e)
                    {

                    }
                }



            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag1==false)
                {
                    mp.start();
                    ib2.setImageResource(R.drawable.pau);
                    flag1=true;
                }
                else if(flag1 == true)
                {
                    mp.pause();
                    ib2.setImageResource(R.drawable.ply);
                    flag1=false;
                }
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AllinOne.this,Mainscreen.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(AllinOne.this, Mainscreen.class);
        startActivity(i);
        finish();
    }
}