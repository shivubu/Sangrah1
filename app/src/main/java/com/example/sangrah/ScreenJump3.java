package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ScreenJump3 extends AppCompatActivity {
    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_jump3);
        ib=(ImageButton)findViewById(R.id.imageButton41);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScreenJump3.this, ScreenJump.class);
                startActivity(i);
                finish();

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(ScreenJump3.this, Mainscreen.class);
        startActivity(i);
        finish();
    }
}