package com.example.aishwarya.topbooks.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aishwarya on 4/8/16.
 */
public class ReleasedDate {
    @SerializedName("label")
    private String mLabel;
    @SerializedName("attributes")
    private Attributes mAttributes;

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }

    public Attributes getAttributes() {
        return mAttributes;
    }

    public void setAttributes(Attributes attributes) {
        mAttributes = attributes;
    }
}
