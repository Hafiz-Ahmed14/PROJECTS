package com.example.studentassistants;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StudentLogin extends AppCompatActivity {
    public static final String TAG= "TAG";
    EditText mEmail,mPassword;

    FirebaseAuth fAuth;



    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        mEmail = findViewById(R.id.st_email);
        mPassword = findViewById(R.id.st_password);
        fAuth = FirebaseAuth.getInstance();

        textView=(TextView)findViewById(R.id.textView5);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StudentLogin.this,RegisterStudent.class);
                startActivity(intent);

            }
        });

        Button buttonstBtnLogin = findViewById(R.id.st_BtnLogin);

        buttonstBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email =mEmail.getText().toString().trim();
                final String password =mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required");
                    return;
                }

                if(password.length()<6){
                    mPassword.setError("Password must be more than 6 digits");

                }



                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Log In Successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeToAssignment.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        });



    }
    public void onBackPressed(){
        AlertDialog.Builder ad = new AlertDialog.Builder(StudentLogin.this);
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