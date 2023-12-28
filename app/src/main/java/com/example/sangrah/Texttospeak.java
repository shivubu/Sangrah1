package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;

public class Texttospeak extends AppCompatActivity {
    EditText text;
    ImageButton speak,re;
    TextToSpeech ts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        text=(EditText)findViewById(R.id.editTextText9);
        speak=(ImageButton)findViewById(R.id.imageButton22);
        re=(ImageButton)findViewById(R.id.imageButton23);
        ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(1.0f);

            }
        });
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Texttospeak.this,Mainscreen.class);
                startActivity(i);
                finish();
            }
        });
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=text.getText().toString();
                ts.speak(s,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(Texttospeak.this, Mainscreen.class);
        startActivity(i);
        finish();
    }
}