package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class VibratorApp extends AppCompatActivity {
    ImageButton b1,ret;
    Vibrator v1;
    EditText et10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrator_app);
        b1=(ImageButton)findViewById(R.id.imageButton36);
        v1=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        ret=(ImageButton)findViewById(R.id.imageButton37);
        et10=(EditText)findViewById(R.id.editTextText10);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s= et10.getText().toString();
                Integer i = Integer.parseInt(s);
                if(Build.VERSION.SDK_INT>26)
                {

                    v1.vibrate(i);

                }
                else
                {
                    v1.vibrate(i);


                }
                Toast.makeText(VibratorApp.this, "Aa Gaya Swaad !", Toast.LENGTH_SHORT).show();
            }
        });
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VibratorApp.this,Mainscreen.class);
                startActivity(i);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(VibratorApp.this, Mainscreen.class);
        startActivity(i);
        finish();
    }
}