package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Person;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.PointerIcon;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CancerActivity extends AppCompatActivity {
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancer);

        lst = findViewById(R.id.Lst);

        //crete data
        ArrayList<Can> arrayList = new ArrayList<>();

        arrayList.add(new Can(R.drawable.dr1,"Dr ssss","MBBS"));
        arrayList.add(new Can(R.drawable.dr1,"Dr ssss","MBBS"));
        arrayList.add(new Can(R.drawable.dr1,"Dr ssss","MBBS"));

        CanAdapter personAdapter = new CanAdapter(this,R.layout.list_row3,arrayList);
        lst.setAdapter(personAdapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(CancerActivity.this,BookActivity.class));

            }
        });



    }
}