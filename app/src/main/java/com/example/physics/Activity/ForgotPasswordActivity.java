package com.example.physics.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.physics.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class ForgotPasswordActivity extends AppCompatActivity {
    TextView forgotPassword;
    Button passworlddrecover_btn;
    EditText forgot_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_passworld);

        forgotPassword=findViewById(R.id.forgotpassworld_toLogin_btn);
        passworlddrecover_btn=findViewById(R.id.passworlddrecover_btn);
        forgot_email=findViewById(R.id.forgot_email);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPasswordActivity.this,LoginActivity.class));
                finish();
            }
        });
        passworlddrecover_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = forgot_email.getText().toString().trim();
                if(email.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter email",Toast.LENGTH_SHORT).show();
                }else {
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"mail send",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ForgotPasswordActivity.this,LoginActivity.class));

                            }
                        }
                    });


                }
            }

        });
    }
}