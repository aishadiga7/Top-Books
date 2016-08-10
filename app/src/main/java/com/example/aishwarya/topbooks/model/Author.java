package com.example.aishwarya.topbooks.model;

import com.google.gson.annotations.SerializedName;

public class Author {
    @SerializedName("mame")
    private Name mName;
    @SerializedName("uri")
    private Uri mUri;

    public Name getName() {
        return mName;
    }

    public void setName(Name name) {
        this.mName = name;
    }

    public Uri getUri() {
        return mUri;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
    }
}
