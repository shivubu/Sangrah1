package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ImgButton extends AppCompatActivity {
    ImageButton ib,re;
    private float flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_button);
        ib=(ImageButton)findViewById(R.id.imageButton25);
        re=(ImageButton)findViewById(R.id.imageButton26);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0)
                {
                    ib.setImageResource(R.drawable.on2);
                    flag=1;
                    Toast.makeText(ImgButton.this, "Image Button On", Toast.LENGTH_SHORT).show();
                }
                else {
                    ib.setImageResource(R.drawable.of2);
                    flag=0;
                    Toast.makeText(ImgButton.this, "Image Button Off", Toast.LENGTH_SHORT).show();
                }

            }
        });
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ImgButton.this,Mainscreen.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(ImgButton.this, Mainscreen.class);
        startActivity(i);
        finish();
    }
}