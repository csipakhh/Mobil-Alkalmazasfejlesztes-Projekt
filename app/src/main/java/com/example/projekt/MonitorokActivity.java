package com.example.projekt;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MonitorokActivity extends AppCompatActivity {

    private Notification mNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        mNotification = new Notification(this);
    }
    public void vissza(View view) {
        mNotification.send("Monitorokat néztél meg");
        finish();
    }

}

