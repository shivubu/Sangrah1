package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Camera extends AppCompatActivity {
    ImageView iv6;
    ImageButton c1,v1,ret;
    CameraManager cm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        iv6=(ImageView)findViewById(R.id.imageView6);
        c1=(ImageButton)findViewById(R.id.imageButton4);
        v1=(ImageButton)findViewById(R.id.imageButton5);
        ret=(ImageButton)findViewById(R.id.imageButton6);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Camera.this,Mainscreen.class);
                startActivity(i);
                finish();
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,100);
            }
        });
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Camera.this, Video.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100)
        {
            Bitmap bm=(Bitmap)data.getExtras().get("data");
            iv6.setImageBitmap(bm);
        }
        else
        {
            Toast.makeText(Camera.this, "Your Camera is not Working !", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(Camera.this, Mainscreen.class);
        startActivity(i);
        finish();
    }
}