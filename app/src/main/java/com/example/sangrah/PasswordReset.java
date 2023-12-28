package com.example.sangrah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PasswordReset extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextView pwdreset,loglink;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);
        mAuth=FirebaseAuth.getInstance();
        email=(EditText)findViewById(R.id.editTextText6);
        pwdreset=(TextView)findViewById(R.id.textView11);
        loglink=(TextView)findViewById(R.id.textView12);
        pwdreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = email.getText().toString().trim();
                mAuth.sendPasswordResetEmail(s).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(PasswordReset.this, "The email has been sent", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(PasswordReset.this, "Task Unsuccessful . Please Re Enter the Email.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        loglink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PasswordReset.this, Login.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(PasswordReset.this, Login.class);
        startActivity(i);
        finish();
    }
}