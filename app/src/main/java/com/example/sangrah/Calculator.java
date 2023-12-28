package com.example.sangrah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;

public class Calculator extends AppCompatActivity {
    Button add,sub,mul,div,mod,power;
    ImageButton re;
    EditText num1,num2;
    TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        re=(ImageButton)findViewById(R.id.imageButton17);
        add=(Button)findViewById(R.id.button4);
        sub=(Button)findViewById(R.id.button5);
        mul=(Button)findViewById(R.id.button6);
        div=(Button)findViewById(R.id.button7);
        mod=(Button)findViewById(R.id.button8);
        power=(Button)findViewById(R.id.button9);
        ans=(TextView)findViewById(R.id.textView15);
        num1=(EditText)findViewById(R.id.editTextText7);
        num2=(EditText)findViewById(R.id.editTextText8);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=num1.getText().toString();
                String s2=num2.getText().toString();
                Float f1= Float.parseFloat(s1);
                Float f2= Float.parseFloat(s2);
                Float f3=f1+f2;
                String s3=f3.toString();
                ans.setText(s3);
                Toast.makeText(Calculator.this, "The answer is :"+s3, Toast.LENGTH_SHORT).show();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=num1.getText().toString();
                String s2=num2.getText().toString();
                Float f1= Float.parseFloat(s1);
                Float f2= Float.parseFloat(s2);
                Float f3=f1-f2;
                String s3=f3.toString();
                ans.setText(s3);
                Toast.makeText(Calculator.this, "The answer is :"+s3, Toast.LENGTH_SHORT).show();
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=num1.getText().toString();
                String s2=num2.getText().toString();
                Float f1= Float.parseFloat(s1);
                Float f2= Float.parseFloat(s2);
                Float f3=f1*f2;
                String s3=f3.toString();
                ans.setText(s3);
                Toast.makeText(Calculator.this, "The answer is :"+s3, Toast.LENGTH_SHORT).show();
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=num1.getText().toString();
                String s2=num2.getText().toString();
                Float f1= Float.parseFloat(s1);
                Float f2= Float.parseFloat(s2);
                Float f3=f1/f2;
                String s3=f3.toString();
                ans.setText(s3);
                Toast.makeText(Calculator.this, "The answer is :"+s3, Toast.LENGTH_SHORT).show();
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=num1.getText().toString();
                String s2=num2.getText().toString();
                Float f1= Float.parseFloat(s1);
                Float f2= Float.parseFloat(s2);
                Float f3=f1%f2;
                String s3=f3.toString();
                ans.setText(s3);
                Toast.makeText(Calculator.this, "The answer is :"+s3, Toast.LENGTH_SHORT).show();
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=num1.getText().toString();
                String s2=num2.getText().toString();
                Double d1= Double.parseDouble(s1);
                Double d2= Double.parseDouble(s2);
                Double d3=Math.pow(d1,d2);
                String s3=d3.toString();
                ans.setText(s3);
                Toast.makeText(Calculator.this, "The answer is :"+s3, Toast.LENGTH_SHORT).show();
            }
        });
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Calculator.this, Mainscreen.class);
                startActivity(i);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(Calculator.this, Mainscreen.class);
        startActivity(i);
        finish();
    }
}