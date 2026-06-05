package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class balancedDietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balanced_diet);

        TextView balanceDiet = findViewById(R.id.diet);
        balanceDiet.setText(getString(R.string.balancedDiet));
    }
}