package com.example.studentassistants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar progressBar;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar= findViewById(R.id.progressBarId);
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        doWork();
                    }
                });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),HomePage.class));
            }
        },3500);
        thread.start();
    }
    public void doWork(){
        for(progress=20; progress<=3500; progress=progress+10);
        try {
            Thread.sleep(3500);
            progressBar.setProgress(progress);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}