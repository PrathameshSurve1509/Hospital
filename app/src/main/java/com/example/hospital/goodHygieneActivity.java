package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class goodHygieneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_hygiene);

        TextView goodH = findViewById(R.id.hygiene_text);
        goodH.setText(getString(R.string.hygiene));
    }
}