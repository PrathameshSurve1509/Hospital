package com.example.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DiabetesActivity extends AppCompatActivity {
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes);

        lst = findViewById(R.id.Lst);

        //crete data
        ArrayList<Diab> arrayList = new ArrayList<>();

        arrayList.add(new Diab(R.drawable.diab1,"Dr.Ameya joshi ","Diabetologist                                          19 years Experience           Time:Monday to Saturday                               12:00pm-4:00pm"));
        arrayList.add(new Diab(R.drawable.diab2,"Dr.Sweta Budyal","Diabetologist                                          12 years Experience           Time:Monday to Saturday                               01:00pm-4:00pm"));
        arrayList.add(new Diab(R.drawable.diab3,"Dr.Abhijit Jadhav","Diabetologist                                          23 years Experience           Time:Monday to Saturday                               11:00am-6:00pm"));
        arrayList.add(new Diab(R.drawable.diab4,"Dr.Sudhakar Krishnan ","Diabetologist                                          21 years Experience           Time:Monday to Saturday                               12:00pm-4:00pm"));
        arrayList.add(new Diab(R.drawable.tub1,"Dr.Sumeet Singhania","Polmonologist                                             17 years of Experience           Time:Monday to Saturday                               09:00am-8:00pm"));
        arrayList.add(new Diab(R.drawable.tub2,"Dr.Amit Raodeo","Critical Care Specialist                                             12 years of Experience"));
        arrayList.add(new Diab(R.drawable.tub3,"Dr.Vaibhav Kubul","Polmonologist                                             15 years of Experience           Time:Monday to Saturday                               03:00pm-7:00pm"));
        arrayList.add(new Diab(R.drawable.tub4,"Dr.Dev Lakshmesh","Critical Care Specialist                                             12 years of Experience           Time:Monday to Saturday                               1:00pm-4:00pm"));
        arrayList.add(new Diab(R.drawable.nor1,"Dr.Yogesh P Mehata","Pediatrician                                             38 years of Experience           Time:Monday to Saturday                               12:00pm-5:00pm"));
        arrayList.add(new Diab(R.drawable.nor2,"Dr.Sujata Chitnis","Pediatrician                                              42 years of Experience           Time:Monday to Saturday                               09:00am-4:00pm"));
        arrayList.add(new Diab(R.drawable.nor3,"Dr.Yuvaraj S Shetty","Pediatrician                                            18 years of Experience           Time:Monday to Saturday                               10:00am-4:00pm"));
        arrayList.add(new Diab(R.drawable.nor4,"Dr.Rajanshu Tiwari","General Phisician                                        13 years of Experience           Time:Monday to Saturday                               6:00pm-:00pm"));

        DiabAdapter diabAdapter = new DiabAdapter(this,R.layout.list_row1,arrayList);
        lst.setAdapter(diabAdapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    startActivity(new Intent(DiabetesActivity.this, appointment_book.class));







            }
        });



    }
}