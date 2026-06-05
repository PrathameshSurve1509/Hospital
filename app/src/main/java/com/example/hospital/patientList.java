package com.example.hospital;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class patientList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    patientD_Adapter patientA;
    ArrayList<patientD> list;
    ImageButton imgButton;
    ArrayList<String> list1;

    ListView myList1;
    ArrayAdapter<String> adapter1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

        recyclerView = findViewById(R.id.recyclerView);
        imgButton=(ImageButton)findViewById(R.id.imageButton1);
        myList1 = (ListView)findViewById(R.id.myList2);
//        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance().getReference().child("Users");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        patientA = new patientD_Adapter(this, list);
        recyclerView.setAdapter(patientA);

        database.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    patientD pd = dataSnapshot.getValue(patientD.class);
                    list.add(pd);
                }
                patientA.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(patientList.this, "Canceled" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        //menu button list
        list1=new ArrayList<String>();
        list1.add("Profile");
        list1.add("Logout");


        myList1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position==0){
                    startActivity(new Intent(patientList.this,ProfileActivity.class));
                }else if(position==1){
                    startActivity(new Intent(patientList.this,MainActivity2.class));
                }


            }
        });

        //for menu
        imgButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myList1.getVisibility()==View.VISIBLE){
                    myList1.setVisibility(View.GONE);
                } else{
                    myList1.setVisibility(View.VISIBLE);
                }
            }
        }));
        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list1);
        myList1.setAdapter(adapter1);
    }
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(patientList.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent a = new Intent(Intent.ACTION_MAIN);
                        a.addCategory(Intent.CATEGORY_HOME);
                        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(a);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}