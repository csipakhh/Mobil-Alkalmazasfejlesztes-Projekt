package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class AruListaActivity extends AppCompatActivity {

    private static final String LOG_TAG = AruListaActivity.class.getName();
    private FirebaseUser user;
    private static final int SECRET_KEY = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aru_lista);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Log.d(LOG_TAG, "Létező felhasználó");
        } else {
            Log.d(LOG_TAG, "Nem létező felhasználó");
            finish();
        }

    }

    public void monitor(View view) {
        Intent intent = new Intent(this,MonitorokActivity.class);
        //intent.putExtra("SECRET_KEY", SECRET_KEY);
        startActivity(intent);
    }

    public void eger(View view) {
        Intent intent = new Intent(this,EgerekActivity.class);
        //intent.putExtra("SECRET_KEY", SECRET_KEY);
        startActivity(intent);
    }

    public void billentyuzet(View view) {
        Intent intent = new Intent(this,BillentyuzetekActivity.class);
        //intent.putExtra("SECRET_KEY", SECRET_KEY);
        startActivity(intent);
    }

    public void vissza(View view) {
        finish();
    }
}