package com.example.hospital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    private TextView textVieWelcome, textViewFullName, textViewEmail;
    private ProgressBar progressBar;
    private String fullName,email;
    private ImageView imageView;
    private FirebaseAuth authProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        textVieWelcome=findViewById(R.id.textView_show_welcome);
        textViewFullName=findViewById(R.id.textView_show_full_name);
        textViewEmail=findViewById(R.id.textView_show_email);

        authProfile =   FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=authProfile.getCurrentUser();

        if(firebaseUser == null){
            Toast.makeText(ProfileActivity.this,"Something went wrong! Users details are not available at the moment",Toast.LENGTH_SHORT).show();
        }else{
            progressBar.setVisibility(View.VISIBLE);
            showUserProfile(firebaseUser);
        }
    }

    private void showUserProfile(FirebaseUser firebaseUser) {
        String userId= firebaseUser.getUid();

        //Extracting User Reference from Database for "Registered Users"
        DatabaseReference referenceProfile= FirebaseDatabase.getInstance().getReference("Registered users");
        referenceProfile.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ReadWriteUserDetails readUserDetails= snapshot.getValue(ReadWriteUserDetails.class);
                if(readUserDetails !=null){
                    fullName=firebaseUser.getDisplayName();
                    email = firebaseUser.getEmail();

                    textVieWelcome.setText("welcome, "+fullName+"!");
                    textViewFullName.setText(fullName);
                    textViewEmail.setText(email);
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfileActivity.this,"Something went wrong! ",Toast.LENGTH_LONG).show();
                progressBar.setVisibility((View.GONE));
            }
        });
    }
}