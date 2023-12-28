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

public class Login extends AppCompatActivity {
    TextView t1,t3,t8,t9;
    EditText e1,p1;
    ImageButton login;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseApp.initializeApp(this);
        mAuth=FirebaseAuth.getInstance();
        e1=(EditText)findViewById(R.id.editTextText);
        p1=(EditText)findViewById(R.id.editTextText2);
        login=(ImageButton)findViewById(R.id.imageButton);
        t3=(TextView)findViewById(R.id.textView3);
        t8=(TextView)findViewById(R.id.textView8);
        t9=(TextView)findViewById(R.id.textView9);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Signup.class);
                startActivity(i);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signInAnonymously().addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login.this, "Log In as Guest", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Login.this,Mainscreen.class);
                            startActivity(i);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(Login.this, "Login Unsuccessfull", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, PasswordReset.class);
                startActivity(i);
                finish();
            }
        });


    }
    private void loginUser()
    {
        String email,pass;
        email=e1.getText().toString();
        pass=p1.getText().toString();
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
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this,Mainscreen.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(Login.this, "Login Unsuccessfull", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }


}