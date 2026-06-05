package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AsthmaActivity extends AppCompatActivity {
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asthma);

        lst = findViewById(R.id.Lst);

        //crete data
        ArrayList<Asthma> arrayList = new ArrayList<>();


        arrayList.add(new Asthma(R.drawable.dr2,"Dr Nasir Fulara","MBBS,MD,Fellowship                                 42 years of Experience           Time:Monday to Saturday                               12:00pm-4:00pm"));
        arrayList.add(new Asthma(R.drawable.tub1,"Dr.Sumeet Singhania","Polmonologist                                             17 years of Experience           Time:Monday to Saturday                               09:00am-8:00pm"));
        arrayList.add(new Asthma(R.drawable.tub2,"Dr.Amit Raodeo","Critical Care Specialist                                             12 years of Experience           Time:Monday to Saturday                               12:00pm-6:00pm"));
        arrayList.add(new Asthma(R.drawable.tub3,"Dr.Vaibhav Kubul","Polmonologist                                             15 years of Experience           Time:Monday to Saturday                               01:00pm-4:00pm"));
        arrayList.add(new Asthma(R.drawable.tub4,"Dr.Dev Lakshmesh","Critical Care Specialist                                             12 years of Experience           Time:Monday to Saturday                               12:00pm-4:00pm"));
        arrayList.add(new Asthma(R.drawable.nor1,"Dr.Yogesh P Mehata","Pediatrician                                             38 years of Experience           Time:Monday to Saturday                               12:00pm-3:00pm"));
        arrayList.add(new Asthma(R.drawable.nor2,"Dr.Sujata Chitnis","Pediatrician                                              42 years of Experience           Time:Monday to Saturday                               10:00am-6:00pm"));
        arrayList.add(new Asthma(R.drawable.nor3,"Dr.Yuvaraj S Shetty","Pediatrician                                            18 years of Experience           Time:Monday to Saturday                               12:00pm-4:00pm"));
        arrayList.add(new Asthma(R.drawable.nor4,"Dr.Rajanshu Tiwari","General Phisician                                        13 years of Experience           Time:Monday to Saturday                               11:00am-2:00pm"));

        AsthmaAdapter asthmaAdapter = new AsthmaAdapter(this,R.layout.list_row1,arrayList);
        lst.setAdapter(asthmaAdapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                startActivity(new Intent(AsthmaActivity.this, appointment_book.class));






            }
        });



    }
}