package com.example.aishwarya.topbooks.model;

import com.google.gson.annotations.SerializedName;

/**
 * Model class Category field
 */
public class Category {
    @SerializedName("attributes")
    private Attributes mAttributes;

    public Attributes getAttributes() {
        return mAttributes;
    }

    public void setAttributes(Attributes attributes) {
        mAttributes = attributes;
    }
}
