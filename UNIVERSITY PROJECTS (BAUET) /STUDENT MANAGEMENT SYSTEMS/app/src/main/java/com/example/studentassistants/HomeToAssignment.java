package com.example.studentassistants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeToAssignment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_to_assignment);

        //Button for Student pannel
        Button buttontasg14=findViewById(R.id.batch_14);
        buttontasg14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeToAssignment.this,StudentPanel.class);
                startActivity(intent);
            }
        });
        Button buttontasg11=findViewById(R.id.batch_11);
        buttontasg11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeToAssignment.this,StudentPanel.class);
                startActivity(intent);
            }
        });
        Button buttontasg10=findViewById(R.id.batch_10);
        buttontasg10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeToAssignment.this,StudentPanel.class);
                startActivity(intent);
            }
        });
        Button buttontasg12=findViewById(R.id.batch_12);
        buttontasg12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeToAssignment.this,StudentPanel.class);
                startActivity(intent);
            }
        });
        Button buttontasg13=findViewById(R.id.batch_13);
        buttontasg13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeToAssignment.this,StudentPanel.class);
                startActivity(intent);
            }
        });
        Button buttontasg15=findViewById(R.id.batch_15);
        buttontasg15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeToAssignment.this,StudentPanel.class);
                startActivity(intent);
            }
        });
        Button buttontasg16=findViewById(R.id.batch_16);
        buttontasg16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeToAssignment.this,StudentPanel.class);
                startActivity(intent);
            }
        });
        Button buttontasg17=findViewById(R.id.batch_17);
        buttontasg17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeToAssignment.this,StudentPanel.class);
                startActivity(intent);
            }
        });

    }
}