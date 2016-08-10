package com.example.aishwarya.topbooks.model;

import com.google.gson.annotations.SerializedName;

public class Uri {
    @SerializedName("label")
    private String mLabel;

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        this.mLabel = label;
    }
}
