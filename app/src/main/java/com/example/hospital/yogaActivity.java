package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class yogaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);


        TextView yoga = findViewById(R.id.yoga_text);
        yoga.setText(getString(R.string.hygiene));
    }
}