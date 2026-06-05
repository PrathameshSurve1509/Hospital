package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NormalFeverActivity extends AppCompatActivity {
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_fever);

        lst = findViewById(R.id.normal);

        //crete data
        ArrayList<Normal> arrayList = new ArrayList<>();

        arrayList.add(new Normal(R.drawable.nor1,"Dr.Yogesh P Mehata","Pediatrician                                             38 years of Experience           Time:Monday to Saturday                               12:00pm-4:00pm"));
        arrayList.add(new Normal(R.drawable.nor2,"Dr.Sujata Chitnis","Pediatrician                                              42 years of Experience           Time:Monday to Saturday                               10:00am-1:00pm"));
        arrayList.add(new Normal(R.drawable.nor3,"Dr.Yuvaraj S Shetty","Pediatrician                                            18 years of Experience           Time:Monday to Saturday                               01:00pm-4:00pm"));
        arrayList.add(new Normal(R.drawable.nor4,"Dr.Rajanshu Tiwari","General Phisician                                        13 years of Experience           Time:Monday to Saturday                               09:0apm-4:00pm"));
        arrayList.add(new Normal(R.drawable.tub1,"Dr.Sumeet Singhania","Polmonologist                                             17 years of Experience           Time:Monday to Saturday                               11:00am-3:00pm"));
        arrayList.add(new Normal(R.drawable.tub2,"Dr.Amit Raodeo","Critical Care Specialist                                             12 years of Experience           Time:Monday to Saturday                               12:00pm-5:00pm"));
        arrayList.add(new Normal(R.drawable.tub3,"Dr.Vaibhav Kubul","Polmonologist                                             15 years of Experience           Time:Monday to Saturday                               3:00pm-6:00pm"));
        arrayList.add(new Normal(R.drawable.tub4,"Dr.Dev Lakshmesh","Critical Care Specialist                                             12 years of Experience           Time:Monday to Saturday                               5:00pm-9:00pm"));
        arrayList.add(new Normal(R.drawable.can1,"Dr.Shaila Welling","General Surgeon                                          54 years of Experience           Time:Monday to Saturday                               12:00pm-4:00pm"));
        arrayList.add(new Normal(R.drawable.can2,"Dr.Suresh Advani","Oncologist                                               46 years of Experience           Time:Monday to Saturday                               10:00am-1:00pm"));
        arrayList.add(new Normal(R.drawable.can3,"Dr.Purna kurkure"," Hemato Oncologist                                          44 years of Experience           Time:Monday to Saturday                               12:00pm-3:00pm"));
        arrayList.add(new Normal(R.drawable.can4,"Dr.Shaila Welling","Radiation Oncologist                                      42 years of Experience           Time:Monday to Saturday                               12:00pm-4:00pm"));

        NormalAdapter normalAdapter = new NormalAdapter(this,R.layout.list_row1,arrayList);
        lst.setAdapter(normalAdapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                startActivity(new Intent(NormalFeverActivity.this, appointment_book.class));






            }
        });



    }
}