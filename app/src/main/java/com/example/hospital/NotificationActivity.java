package com.example.hospital;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class NotificationActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    TextView textView;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        textView = findViewById(R.id.tv);
        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        handler = new Handler();

        String textToDisplay = preferences.getString("text", "");
        textView.setText(textToDisplay);



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setText("");
            }
        }, 10);


        Intent intent = getIntent();
        if (intent != null) {
            String text = intent.getStringExtra("text");
            if (text != null) {
                textView.setText(text);
            }

        }


    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("text", textView.getText().toString());
        editor.apply();
        handler.removeCallbacksAndMessages(null);
    }}