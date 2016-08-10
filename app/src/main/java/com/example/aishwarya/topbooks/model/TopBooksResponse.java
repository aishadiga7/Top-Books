package com.example.aishwarya.topbooks.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aishwarya on 4/8/16.
 */
public class TopBooksResponse {
    @SerializedName("feed")
    private Feed mFeed;

    public Feed getFeed() {
        return mFeed;
    }

    public void setFeed(Feed feed) {
        mFeed = feed;
    }
}
