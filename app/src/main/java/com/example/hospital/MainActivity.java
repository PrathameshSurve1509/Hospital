package com.example.hospital;


import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.SearchView;
import android.widget.VideoView;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    ListView myList;

    ListView myList1;
    ImageButton imgButton,bell;

    Button button;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    ArrayList<String> list1;
    ArrayAdapter<String> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = findViewById(R.id.videoView);
        String videoPath="android.resource://" + getPackageName() +"/" +R.raw.video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        //to stay buttons below
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        searchView = (SearchView)findViewById(R.id.SearchView);
        myList = (ListView)findViewById(R.id.myList);
        myList1 = (ListView)findViewById(R.id.myList2);
        imgButton=(ImageButton)findViewById(R.id.imageButton1);
        button=(Button)findViewById(R.id.button2);
        bell=(ImageButton)findViewById(R.id.imageButton2);


        final SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setFocusable(false);
        searchView.setIconified(true);
        searchView.requestFocusFromTouch();


        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HealthFitnessActivity.class));
            }
        });




        //menu button list
        list1=new ArrayList<String>();
        list1.add("Profile");
        list1.add("Help");
        list1.add("Logout");


        myList1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position==0){
                    startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                }else if (position==1){
                    startActivity(new Intent(MainActivity.this,helpButton.class));
                }else if(position==2){
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
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


        list=new ArrayList<String>();

        list.add("Normal Fever");
        list.add("Diabetes");
        list.add("Tuberculosis");
        list.add("Cancer");
        list.add("Asthma");
        list.add("Arthritis");

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0){
                    startActivity(new Intent(MainActivity.this,NormalFeverActivity.class));
                }
                else if (position==1){
                    startActivity(new Intent(MainActivity.this,DiabetesActivity.class));
                }
                else if (position==2){
                    startActivity(new Intent(MainActivity.this,TuberculosisActivity.class));
                }
                else if (position==3){
                    startActivity(new Intent(MainActivity.this,CancerActivity.class));
                }
                else if (position==4){
                    startActivity(new Intent(MainActivity.this,AsthmaActivity.class));
                }
                else if (position==5){
                    startActivity(new Intent(MainActivity.this,ArthritisActivity.class));
                }
            }
        });


        searchView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myList.getVisibility()==View.VISIBLE){
                    myList.setVisibility(View.GONE);
                } else{
                    myList.setVisibility(View.VISIBLE);
                }
            }
        }));

        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        myList.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(s.length() >0)
                adapter.getFilter().filter(s);
                return false;
            }

        });
    }
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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