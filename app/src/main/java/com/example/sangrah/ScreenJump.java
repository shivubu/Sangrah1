package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ScreenJump extends AppCompatActivity {
    ImageButton ib,ret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_jump);
        ib=(ImageButton)findViewById(R.id.imageButton39);
        ret=(ImageButton)findViewById(R.id.imageButton42);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScreenJump.this, ScreenJump2.class);
                startActivity(i);
                finish();

            }
        });
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScreenJump.this,Mainscreen.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(ScreenJump.this, Mainscreen.class);
        startActivity(i);
        finish();
    }
}