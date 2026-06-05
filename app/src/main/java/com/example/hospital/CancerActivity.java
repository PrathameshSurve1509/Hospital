package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CancerActivity extends AppCompatActivity {
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancer);

        lst = findViewById(R.id.cancer);

        //crete data
        ArrayList<Can> arrayList = new ArrayList<>();

        arrayList.add(new Can(R.drawable.can1,"Dr.Shaila Welling","General Surgeon                                          54 years of Experience           Time:Monday to Saturday                               01:00pm-7:00pm"));
        arrayList.add(new Can(R.drawable.can2,"Dr.Suresh Advani","Oncologist                                               46 years of Experience           Time:Monday to Saturday                               12:00pm-3:00pm"));
        arrayList.add(new Can(R.drawable.can3,"Dr.Purna kurkure"," Hemato Oncologist                                          44 years of Experience           Time:Monday to Saturday                               2:00pm-9:00pm"));
        arrayList.add(new Can(R.drawable.can4,"Dr.Shaila Welling","Radiation Oncologist                                      42 years of Experience           Time:Monday to Saturday                               09:00am-4:00pm"));
        arrayList.add(new Can(R.drawable.tub1,"Dr.Sumeet Singhania","Polmonologist                                             17 years of Experience           Time:Monday to Saturday                               10:00am-8:00pm"));
        arrayList.add(new Can(R.drawable.tub2,"Dr.Amit Raodeo","Critical Care Specialist                                             12 years of Experience"));
        arrayList.add(new Can(R.drawable.tub3,"Dr.Vaibhav Kubul","Polmonologist                                             15 years of Experience           Time:Monday to Saturday                               12:00pm-4:00pm"));
        arrayList.add(new Can(R.drawable.tub4,"Dr.Dev Lakshmesh","Critical Care Specialist                                             12 years of Experience           Time:Monday to Saturday                               12:00pm-3:00pm"));
        arrayList.add(new Can(R.drawable.nor1,"Dr.Yogesh P Mehata","Pediatrician                                             38 years of Experience           Time:Monday to Saturday                               11:00am-5:00pm"));
        arrayList.add(new Can(R.drawable.nor2,"Dr.Sujata Chitnis","Pediatrician                                              42 years of Experience           Time:Monday to Saturday                               4:00pm-10:00pm"));
        arrayList.add(new Can(R.drawable.nor3,"Dr.Yuvaraj S Shetty","Pediatrician                                            18 years of Experience           Time:Monday to Saturday                               8:00pm-4:00pm"));
        arrayList.add(new Can(R.drawable.nor4,"Dr.Rajanshu Tiwari","General Phisician                                        13 years of Experience           Time:Monday to Saturday                               5:00pm-7:00pm"));

        CanAdapter canAdapter = new CanAdapter(this,R.layout.list_row1,arrayList);
        lst.setAdapter(canAdapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    startActivity(new Intent(CancerActivity.this, appointment_book.class));
            }
        });
    }
}