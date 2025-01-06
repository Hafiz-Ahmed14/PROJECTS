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

public class StudentPanel extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_panel);


        //Button for Assignment
        Button buttontasg=findViewById(R.id.sp_assignment);
        buttontasg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentPanel.this,StudentAssignment.class);
                startActivity(intent);
            }
        });

        //Button for Class test
        Button buttonct=findViewById(R.id.sp_ct);
        buttonct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentPanel.this,StudentClasstest.class);
                startActivity(intent);
            }
        });

        //button for notes
        Button buttonnote=findViewById(R.id.sp_cn);
        buttonnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentPanel.this,StudentClassnotes.class);
                startActivity(intent);
            }
        });

        //course details
        Button buttonstudet=findViewById(R.id.sp_course);
        buttonstudet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentPanel.this,CourseDetails.class);
                startActivity(intent);
            }
        });


        //button for feedback
        Button buttonfed=findViewById(R.id.sp_feedback);
        buttonfed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentPanel.this,StudentFeedback.class);
                startActivity(intent);
            }
        });

        //button for logout
        Button buttonlogout= findViewById(R.id.stlogout);
        buttonlogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                firebaseAuth.getInstance().signOut();
                Intent intent=new Intent(StudentPanel.this,StudentLogin.class);
                startActivity(intent);
                finish();

                Toast.makeText(StudentPanel.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }

   /* public void onBackPressed(){
        AlertDialog.Builder ad = new AlertDialog.Builder(StudentPanel.this);
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
}*/
}