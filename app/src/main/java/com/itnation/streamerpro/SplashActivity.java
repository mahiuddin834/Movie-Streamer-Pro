package com.itnation.streamerpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;


public class SplashActivity extends AppCompatActivity {


    ProgressBar progressBar;
    int progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);




        progressBar=findViewById(R.id.progress);

        progressBar.setProgressTintList(ColorStateList.valueOf(Color.WHITE));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                doWork();

            }
        });

        thread.start();



        final Handler myHaldler;
        myHaldler = new Handler();
        myHaldler.postDelayed(new Runnable() {
            @Override
            public void run() {


                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();

            }
        }, 4000);




    }





    public  void doWork() {


        for(progress = 30; progress<= 100; progress= progress+30){

            try {
                Thread.sleep(1000);

                progressBar.setProgress(progress);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }


}