package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Mainscreen extends AppCompatActivity {
    ImageButton cam,acc,calc,med,text,ibutton,sens,all,sens2,vibapp,scjapp,lout;
    Button scrollup;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        mAuth=FirebaseAuth.getInstance();
        cam=(ImageButton)findViewById(R.id.imageButton3);
        acc=(ImageButton)findViewById(R.id.imageButton15);
        calc=(ImageButton)findViewById(R.id.imageButton16);
        med=(ImageButton)findViewById(R.id.imageButton18);
        text=(ImageButton)findViewById(R.id.imageButton21);
        ibutton=(ImageButton)findViewById(R.id.imageButton24);
        sens=(ImageButton)findViewById(R.id.imageButton27);
        all=(ImageButton)findViewById(R.id.imageButton30);
        sens2=(ImageButton)findViewById(R.id.imageButton33);
        vibapp=(ImageButton)findViewById(R.id.imageButton35);
        scjapp=(ImageButton)findViewById(R.id.imageButton38);
        lout=(ImageButton)findViewById(R.id.imageButton43);


        scrollup=(Button)findViewById(R.id.button);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainscreen.this, Camera.class);
                startActivity(i);
                finish();
            }
        });
        scrollup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainscreen.this, Utilitites.class);
                startActivity(i);
                finish();
            }
        });
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainscreen.this, Accelerometer.class);
                startActivity(i);
                finish();
            }
        });
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainscreen.this, Calculator.class);
                startActivity(i);
                finish();
            }
        });
        med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainscreen.this, MediaPlay.class);
                startActivity(i);
                finish();
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainscreen.this, Texttospeak.class);
                startActivity(i);
                finish();
            }
        });
        ibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainscreen.this, ImgButton.class);
                startActivity(i);
                finish();
            }
        });
        sens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainscreen.this, Sense.class);
                startActivity(i);
                finish();
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainscreen.this, AllinOne.class);
                startActivity(i);
                finish();
            }
        });
        sens2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainscreen.this, Sensor2.class);
                startActivity(i);
                finish();
            }
        });
        vibapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainscreen.this, VibratorApp.class);
                startActivity(i);
                finish();
            }
        });
        scjapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainscreen.this, ScreenJump.class);
                startActivity(i);
                finish();
            }
        });
        lout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Toast.makeText(Mainscreen.this, "Log Out Successful", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Mainscreen.this, Login.class);
                startActivity(i);
                finish();

            }
        });


    }
}