package com.example.studentassistants;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class TeacherPanel extends AppCompatActivity {


    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_panel);



        //Button for Assignment
        Button buttontasg=findViewById(R.id.tcp_assignment);
        buttontasg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent=new Intent(TeacherPanel.this,TeacherAssignment.class);
                startActivity(intent);
            }
        });

        //Button for Class test
        Button buttonct=findViewById(R.id.tp_Ctest);
        buttonct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent intent=new Intent(TeacherPanel.this,TeacherCt.class);
                startActivity(intent);
            }
        });


        //button for notes
        Button buttonnote=findViewById(R.id.tp_CNote);
        buttonnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                Intent intent=new Intent(TeacherPanel.this,TeacherNote.class);
                startActivity(intent);
            }
        });

        //Student details
        Button buttonstudet=findViewById(R.id.tstd_button);
        buttonstudet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v4) {
                Intent intent=new Intent(TeacherPanel.this,TeacherStudentdetails.class);
                startActivity(intent);
            }
        });

        //button for feedback
        Button buttonfed=findViewById(R.id.tp_Feedback);
        buttonfed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v5) {
                Intent intent=new Intent(TeacherPanel.this,TeacherFeedback.class);
                startActivity(intent);
            }
        });

        //button for logout
        Button buttonlogout= findViewById(R.id.tclogout);
        buttonlogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v6) {
                firebaseAuth.getInstance().signOut();
                Intent intent=new Intent(TeacherPanel.this,TeacherLogin.class);
                startActivity(intent);
                finish();

                Toast.makeText(TeacherPanel.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onBackPressed(){
        AlertDialog.Builder ad = new AlertDialog.Builder(TeacherPanel.this);
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