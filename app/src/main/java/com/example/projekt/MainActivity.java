package com.example.projekt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getName();
    private static final int SECRET_KEY = 99;

    EditText userNameEt;
    EditText passwordEt;



    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEt = findViewById(R.id.editTextUserName);
        passwordEt = findViewById(R.id.editTextPassword);

        mAuth = FirebaseAuth.getInstance();



    }



    public void login(View view) {

        String userNameStr = userNameEt.getText().toString();
        String passwordStr = passwordEt.getText().toString();

        mAuth.signInWithEmailAndPassword(userNameStr, passwordStr).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(LOG_TAG, "Sikeres bejelentkezés!");
                    startListing();
                } else {
                    Log.d(LOG_TAG, "Bejelentkezés sikertelen!");
                    Toast.makeText(MainActivity.this, "Bejelentkezés sikertelen!" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        Log.i("MainActivity", "Bejelentkezett: " + userNameStr + ", jelszó: " + passwordStr);
        //elkerem  szobeget
    }

    private void startListing(/*regisztralt felh adatok*/) {
        Intent intent = new Intent(this, AruListaActivity.class);
        //intent.putExtra("SECRET_KEY", SECRET_KEY);
        startActivity(intent);
    }

    public void register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.putExtra("SECRET_KEY", 99);
        startActivity(intent);
    }





}