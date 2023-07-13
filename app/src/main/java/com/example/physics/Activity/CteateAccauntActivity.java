package com.example.physics.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.physics.R;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class CteateAccauntActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText , confirmPasswordEditText;
    Button createAccountBtn, loginBtn;
    ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cteate_accaunt);

        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        confirmPasswordEditText = findViewById(R.id.confim_password_edit_text);
        createAccountBtn=findViewById(R.id.account_btn);
        progressBar=findViewById(R.id.progressBar);
        loginBtn=findViewById(R.id.login_activity_btn);


        createAccountBtn.setOnClickListener(v -> {

            createAccount();


        });
        loginBtn.setOnClickListener(v -> {
            startActivity(new Intent(CteateAccauntActivity.this,LoginActivity.class));
            finish();
        });




    }

    void createAccount() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();


        boolean isValidated = validateData(email,password,confirmPassword);
        if(!isValidated){
            return;
        }

        createAccountInFirebase(email,password);

    }

    void createAccountInFirebase(String email, String password) {
        changeInProgress(true);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(CteateAccauntActivity.this, task -> {
            changeInProgress(false);
            if(task.isSuccessful()){
                Toast.makeText(CteateAccauntActivity.this,"Succesfuly",Toast.LENGTH_SHORT).show();
                firebaseAuth.getCurrentUser().sendEmailVerification();
                startActivity(new Intent(CteateAccauntActivity.this,LoginActivity.class));
                finish();
            }else{
                Toast.makeText(CteateAccauntActivity.this, Objects.requireNonNull(task.getException()).getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    void changeInProgress(boolean inProgress){
        if(inProgress){
            progressBar.setVisibility(View.VISIBLE);
            createAccountBtn.setVisibility(View.GONE);
        }else{
            progressBar.setVisibility(View.GONE);
            createAccountBtn.setVisibility(View.VISIBLE);
        }
    }


    boolean validateData(String email,String password,String confirmPassword){

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Email is invalid");
            return false;
        }
        if(password.length()<6){
            passwordEditText.setError("Password length is invalid");
            return false;
        }
        if(!password.equals(confirmPassword)){
            confirmPasswordEditText.setError("Password not matched");
            return false;

        }
        return true;
    }
}