package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class waterText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_text);

        TextView waterText = findViewById(R.id.water);
        waterText.setText(getString(R.string.water_text));
    }
}