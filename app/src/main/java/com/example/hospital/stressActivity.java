package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class stressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stress);

        TextView stress = findViewById(R.id.stress_text);
        stress.setText(getString(R.string.stress));


    }
}