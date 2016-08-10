package com.example.aishwarya.topbooks.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aishwarya on 4/8/16.
 */
public class Link {
@SerializedName("attributes")
    private Attributes mAttributes;

    public Attributes getAttributes() {
        return mAttributes;
    }

    public void setAttributes(Attributes attributes) {
        mAttributes = attributes;
    }
}
