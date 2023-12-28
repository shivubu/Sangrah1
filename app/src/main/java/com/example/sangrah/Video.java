package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    ImageButton cam,vid,ret;
    CameraManager cm;
    VideoView v1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        cam=(ImageButton)findViewById(R.id.imageButton8);
        vid=(ImageButton)findViewById(R.id.imageButton7);
        ret=(ImageButton)findViewById(R.id.imageButton9);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        v1=(VideoView)findViewById(R.id.videoView);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Video.this, Camera.class);
                startActivity(i);
                finish();
            }
        });
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Video.this, Mainscreen.class);
                startActivity(i);
                finish();
            }
        });
        vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,101);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==101)
        {
            v1.setVideoURI(data.getData());
            v1.start();
        }
        else
        {
            Toast.makeText(Video.this, "Your Camera is not Working !", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(Video.this, Mainscreen.class);
        startActivity(i);
        finish();
    }
}