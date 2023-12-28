package com.example.sangrah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity {
    TextView t6;
    EditText em1,p2,pc2;
    ImageButton signup;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth=FirebaseAuth.getInstance();
        em1=(EditText)findViewById(R.id.editTextText4);
        p2=(EditText)findViewById(R.id.editTextText5);
        pc2=(EditText)findViewById(R.id.editTextText3);
        signup=(ImageButton)findViewById(R.id.imageButton2);
        t6=(TextView)findViewById(R.id.textView6);
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Signup.this, Login.class);
                startActivity(i);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerNewUser();
            }
        });

    }
    private void registerNewUser()
    {
        String email=em1.getText().toString();
        String pass=p2.getText().toString();
        String passc=pc2.getText().toString();
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass))
        {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!passc.equals(pass))
        {
            Toast.makeText(this, "Please Reconfirm the Password", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Signup.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Signup.this, Login.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(Signup.this, "Registration Unsuccessfull", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(Signup.this, Login.class);
        startActivity(i);
        finish();
    }
}