package com.book.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handleSleep();
    }

    private void handleSleep() {
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                    Intent i = new Intent(activity, MainActivity.class);
                    startActivity(i);
                    finish();
            }
        };

        int SPLASH_TIME_OUT = 3000;
        handler.postDelayed(runnable, SPLASH_TIME_OUT);
    }

    @Override
    public void onBackPressed() {
        handler.removeCallbacks(runnable);
        finish();
    }

}
