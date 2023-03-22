package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class sleepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        TextView sleep = findViewById(R.id.sleep_text);
        sleep.setText(getString(R.string.sleep));
    }
}