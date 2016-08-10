package com.example.aishwarya.topbooks.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.example.aishwarya.topbooks.R;
import com.example.aishwarya.topbooks.common.BaseActivity;
import com.example.aishwarya.topbooks.manager.AnalyticsManager;

public class SplashScreenActivity extends BaseActivity {
    private static final String TAG = SplashScreenActivity.class.getSimpleName();
    public static final int DELAY_TO_START_HOME_SCREEN = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setStatusBarColor(this);
        }
        AnalyticsManager.logEvent(this, getResources().getString(R.string
                                                        .splash_screen_tracking),
                                                        getResources().getString(R.string
                                                        .action_name_for_splash_screen), getResources().getString(R.string
                                                        .label_for_splash_screen));
        launchHomeScreenWithDelay();
    }

    private void launchHomeScreenWithDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeScreenIntent = new Intent(SplashScreenActivity.this, HomeScreenActivity.class);
                startActivity(homeScreenIntent);
                finish();
            }
        }, DELAY_TO_START_HOME_SCREEN);
    }
}
