package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HealthFitnessActivity extends AppCompatActivity {
    public CardView card1, card2, card3, card4, card5, card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_fitness);

        card1 = findViewById(R.id.card1);
        // add content to card1

        card2 = findViewById(R.id.card2);
        // add content to card2

        card3 = findViewById(R.id.card3);
        // add content to card3

        card4 = findViewById(R.id.card4);
        // add content to card4

        card5 = findViewById(R.id.card5);
        // add content to card5

        card6 = findViewById(R.id.card6);
        // add content to card6

        // Set a click listener for each CardView (optional)
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthFitnessActivity.this,waterText.class));
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthFitnessActivity.this,balancedDietActivity.class));
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthFitnessActivity.this,sleepActivity.class));
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthFitnessActivity.this,stressActivity.class));
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthFitnessActivity.this,yogaActivity.class));
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthFitnessActivity.this,goodHygieneActivity.class));
            }
        });
    }
}