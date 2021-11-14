package com.example.project2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity2 extends AppCompatActivity {
    private SharedPreferences mPreferences;
    public static final String sharedPrefFile ="tn.esprit.myapplication";


    ImageButton btF1,btF2,btF3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();


        btF1= findViewById(R.id.button1);
        btF2= findViewById(R.id.favorisBtn);
        btF3=findViewById(R.id.imageMap);

        btF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragSpace,new ListFragment()).commit();
            }
        });
        btF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragSpace,new FavorisFragment()).commit();
            }
        });
        btF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity2.this,MapsActivity.class));

            }
        });

    }
}