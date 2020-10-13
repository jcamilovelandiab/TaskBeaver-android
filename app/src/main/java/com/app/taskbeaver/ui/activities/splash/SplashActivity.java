package com.app.taskbeaver.ui.activities.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.app.taskbeaver.R;
import com.app.taskbeaver.ui.activities.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initLoginActivity();
    }

    private void initLoginActivity(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                LoginActivity.start(SplashActivity.this);
            }
        }, 3000);
    }

}