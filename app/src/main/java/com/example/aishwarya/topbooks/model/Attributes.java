package com.example.aishwarya.topbooks.model;

import com.google.gson.annotations.SerializedName;

/**
 * Model class for Attributes
 */
public class Attributes {
    @SerializedName("term")
    private String mTerm;
    @SerializedName("label")
    private String mLabel;
    @SerializedName("amount")
    private double mAmount;
    @SerializedName("href")
    private String mHref;

    public String getTerm() {
        return mTerm;
    }

    public String getHref() {
        return mHref;
    }

    public void setHref(String href) {
        mHref = href;
    }

    public void setTerm(String term) {
        mTerm = term;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }

    public double getAmount() {
        return mAmount;
    }

    public void setAmount(double amount) {
        mAmount = amount;
    }
}
