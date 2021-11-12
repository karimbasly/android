package com.example.project2android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project2android.Entity.Pilot;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView tvName,tvDescription;
    private Pilot pilot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView=findViewById(R.id.imgDetail);
        tvName=findViewById(R.id.nomDetail);
        tvDescription=findViewById(R.id.decDetail);
        pilot= (Pilot) getIntent().getExtras().getSerializable("pilotDetail");
        imageView.setImageResource(pilot.getImgPilot());
        tvName.setText(pilot.getNamePilot());
        tvDescription.setText(pilot.getDecPilot());
    }
}