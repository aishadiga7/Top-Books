package com.example.aishwarya.topbooks.application;

import android.app.Application;
import android.content.Context;

import com.example.aishwarya.topbooks.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Application class of the app
 */
public class TopBooksApplication extends Application {
    private static Tracker sTracker;

    synchronized  static public Tracker getDefaultTracker(Context context) {
        if (sTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(context);
            sTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return sTracker;
    }



}
