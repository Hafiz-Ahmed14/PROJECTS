package com.example.studentassistants;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;
import java.util.Map;

public class RegisterStudent extends AppCompatActivity {

    public static final String TAG= "TAG";
    EditText mName,mEmail,mID,mBatch,mNumber,mPassword,mConfirmPassword;

    TextView textView;




    FirebaseFirestore fstore;
    String userId;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        mName = findViewById(R.id.RT_name);
        mEmail = findViewById(R.id.RT_email);
        mID = findViewById(R.id.RT_Id);
        mBatch = findViewById(R.id.RT_Batch);
        mNumber = findViewById(R.id.RT_number);
        mPassword = findViewById(R.id.RT_pass);
        mConfirmPassword= findViewById(R.id.CRT_pass);


        fAuth = FirebaseAuth.getInstance();
        fstore =FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),StudentLogin.class));
            finish();
        }

        Button buttonstBtnRegistrationtologin = findViewById(R.id.SRT_Btnregistration);

        buttonstBtnRegistrationtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name =mName.getText().toString().trim();
                final String email =mEmail.getText().toString().trim();
                final String id =mID.getText().toString().trim();
                final String batch =mBatch.getText().toString().trim();
                final String number=mNumber.getText().toString().trim();
                final String password =mPassword.getText().toString().trim();
                final String Cpassword =mConfirmPassword.getText().toString().trim();

                if(TextUtils.isEmpty(name)){
                    mName.setError("Name is Required");
                    return;
                }

            if(TextUtils.isEmpty(email)){
                mEmail.setError("Email is Required");
                return;
            }

            if(TextUtils.isEmpty(id)){
                mID.setError("ID is Required");
                return;
            }
                if(id.length()==16){
                    mID.setError("Enter your full id");
                    return;
                }

                if(TextUtils.isEmpty(batch)) {
                    mBatch.setError("Please Enter Your Batch");
                    return;
                }
            if(TextUtils.isEmpty(number)){
                mNumber.setError("Mobile Number is Required");
                return;
            }
            if(number.length()<11){
                mNumber.setError("Enter your number properly");
                return;
            }

            if(TextUtils.isEmpty(password)){
                mPassword.setError("Password is Required");
                return;
            }

            if(password.length()<6){
                mPassword.setError("Password must be more than 6 digits");
                return;
            }

            if(TextUtils.isEmpty(Cpassword)){
                mConfirmPassword.setError("Re-enter the password");
                return;
            }

            if(!password.equals(Cpassword)){
                mConfirmPassword.setError("Please enter the same password");
            }






                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser fuser = fAuth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(),"Register Succesful",Toast.LENGTH_SHORT).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"Onfailur: Email not sent"+ e.getMessage());

                                }
                            });

                            Toast.makeText(getApplicationContext(),"User Created",Toast.LENGTH_SHORT).show();
                           userId = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference =fstore.collection("user").document(userId);
                            Map<String,Object>user = new HashMap<>();
                            user.put("fName",name);
                            user.put("email",email);
                            user.put("id",id);
                            user.put("phone",number);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                   Log.d(TAG,"onSuccess: user profile is created for"+userId);

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"onFailur: "+e.toString());

                                }
                            });


                           startActivity(new Intent(getApplicationContext(),StudentLogin.class));

                        }
                        else{
                            Toast.makeText(RegisterStudent.this,"Error" +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }

                });


            }


        });

        textView=(TextView)findViewById(R.id.stln5);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterStudent.this,StudentLogin.class);
                startActivity(intent);
            }
        });
    }
}