package com.example.studentassistants;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button buttonTeacherLogin = findViewById(R.id.Hm_teacher);

        buttonTeacherLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, TeacherLogin.class);
                startActivity(intent);
            }
        });

        Button buttonStudentLogin = findViewById(R.id.Hm_student);

        buttonStudentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, StudentLogin.class);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed(){
        AlertDialog.Builder ad = new AlertDialog.Builder(HomePage.this);
        ad.setTitle("Exit");
        ad.setMessage("Are you want to Exit");
        ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
//                firebaseAuth.getInstance().signOut();
//                Intent intent=new Intent(TeacherPanel.this,TeacherLogin.class);
//                startActivity(intent);
//                finish();
//
//                Toast.makeText(TeacherPanel.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        ad.show();
    }
}