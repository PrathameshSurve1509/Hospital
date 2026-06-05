package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ArthritisActivity extends AppCompatActivity {
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuberculosis);

        lst = findViewById(R.id.Lst);




        //crete data
        ArrayList<Arith> arrayList = new ArrayList<>();

        arrayList.add(new Arith(R.drawable.art1,"Dr.Jyotsna Oak","Internal Medicine Specialist                                         27 years of Experience           Time:Monday to Saturday                               09:00am-8:00pm"));
        arrayList.add(new Arith(R.drawable.art2,"Dr.Rajkumari Bhagati Dar","Rheumatologist                                          24 years of Experience           Time:Monday to Saturday                               12:00pm-4:00pm"));
        arrayList.add(new Arith(R.drawable.art3,"Dr.Punit Prithi ","Internal Medicine Specialist                                         20 years of Experience           Time:Monday to Saturday                               10:30am-4:00pm"));
        arrayList.add(new Arith(R.drawable.art4,"Dr.Neena Chitnis","Rheumatologist                                          13 years of Experience           Time:Monday to Saturday                               12:00pm-4:00pm"));
        arrayList.add(new Arith(R.drawable.tub1,"Dr.Sumeet Singhania","Polmonologist                                             17 years of Experience           Time:Monday to Saturday                               09:00am-8:00pm"));
        arrayList.add(new Arith(R.drawable.tub2,"Dr.Amit Raodeo","Critical Care Specialist                                             12 years of Experience           Time:Monday to Saturday                               1:00pm-9:00pm"));
        arrayList.add(new Arith(R.drawable.tub3,"Dr.Vaibhav Kubul","Polmonologist                                             15 years of Experience           Time:Monday to Saturday                               09:00am-4:00pm"));
        arrayList.add(new Arith(R.drawable.tub4,"Dr.Dev Lakshmesh","Critical Care Specialist                                             12 years of Experience           Time:Monday to Saturday                               09:00am-8:00pm"));
        arrayList.add(new Arith(R.drawable.nor1,"Dr.Yogesh P Mehata","Pediatrician                                             38 years of Experience           Time:Monday to Saturday                               12:00pm-4:00pm"));
        arrayList.add(new Arith(R.drawable.nor2,"Dr.Sujata Chitnis","Pediatrician                                              42 years of Experience           Time:Monday to Saturday                               01:00pm-6:00pm"));
        arrayList.add(new Arith(R.drawable.nor3,"Dr.Yuvaraj S Shetty","Pediatrician                                            18 years of Experience           Time:Monday to Saturday                               12:00pm-2:00pm"));
        arrayList.add(new Arith(R.drawable.nor4,"Dr.Rajanshu Tiwari","General Phisician                                        13 years of Experience           Time:Monday to Saturday                               11:00am-2:00pm"));

        ArithAdapter arithAdapter = new ArithAdapter(this,R.layout.list_row1,arrayList);
        lst.setAdapter(arithAdapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                startActivity(new Intent(ArthritisActivity.this, appointment_book.class));






            }
        });



    }
}