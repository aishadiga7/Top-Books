package com.example.aishwarya.topbooks.manager;

import android.content.Context;

import com.example.aishwarya.topbooks.application.TopBooksApplication;
import com.google.android.gms.analytics.HitBuilders;

/**
 * Manager class to perform various Analytics Operations
 */
public class AnalyticsManager {

    /**
     * Function that is used to track various screens of the app
     * @param context calling context
     * @param screenName name of the screen
     */
    public static void logScreenName(Context context, String screenName) {
        TopBooksApplication.getDefaultTracker(context).setScreenName(screenName);
        TopBooksApplication.getDefaultTracker(context).send(new HitBuilders.ScreenViewBuilder().build());
    }

    /**
     * Function that is used to keep track of events
     * @param context calling context
     * @param category category name
     * @param action action to be specified
     * @param label label to be specified
     */
    public static void logEvent(Context context, String category, String action, String label) {
        TopBooksApplication.getDefaultTracker(context).send(new HitBuilders.EventBuilder()
                                                                                .setCategory(category)
                                                                                .setAction(action)
                                                                                .setLabel(label)
                                                                                .setNonInteraction(true)
                                                                                .setValue(1)
                                                                                .build());
    }
}
