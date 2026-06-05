package com.example.hospital;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactUs extends AppCompatActivity {

    private ListView mListView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        // Set the title of the activity
//        getSupportActionBar().setTitle("List View");

        // Find the ListView and ImageView in the layout
        mListView = findViewById(R.id.list_view);

        // Set the image for the ImageView
//        mImageView.setImageResource(R.drawable.doctorabouts);

        // Create an array of four items (empty for now)
        String[] items = new String[] {"Email    helthcare@123gmail.com", "Facebook    www.Facebook.com/healthcare", "Instagram    www.Instagram.com/healthcare", "Twitter    www.Twitter.com/healthcare"};

        // Set the adapter for the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        mListView.setAdapter(adapter);
        // Add item click listener to the ListView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Open Instagram if "Instagram" is clicked
                if (selectedItem.contains("Instagram")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/healthcare_4233"));
                    startActivity(intent);
                }
                // Open Facebook if "Facebook" is clicked
                else if (selectedItem.contains("Facebook")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100091804537772"));
                    startActivity(intent);
                }
                // Open Twitter if "Twitter" is clicked
                else if (selectedItem.contains("Twitter")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/home"));
                    startActivity(intent);
                }
                else if (selectedItem.contains("Email")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com/mail/u/1/?ogbl#inbox"));
                    startActivity(intent);
                }
            }
        });
    }
}