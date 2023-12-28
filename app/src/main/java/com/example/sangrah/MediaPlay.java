package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MediaPlay extends AppCompatActivity {
    ImageButton play,re;
    MediaPlayer mp;
    private float flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        play=(ImageButton)findViewById(R.id.imageButton19);
        re=(ImageButton)findViewById(R.id.imageButton20);
        mp=MediaPlayer.create(MediaPlay.this,R.raw.r);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0)
                {
                    flag=1;
                    play.setImageResource(R.drawable.pau);
                    mp.start();
                    Toast.makeText(MediaPlay.this, "Media Player Start", Toast.LENGTH_SHORT).show();

                }
                else if(flag==1){
                    flag=0;
                    play.setImageResource(R.drawable.ply);
                    mp.stop();
                    mp=MediaPlayer.create(MediaPlay.this,R.raw.r);
                    Toast.makeText(MediaPlay.this, "Media Player Stop", Toast.LENGTH_SHORT).show();


                }


            }
        });
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaPlay.this, Mainscreen.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(MediaPlay.this, Mainscreen.class);
        startActivity(i);
        finish();
    }
}