package com.example.aishwarya.topbooks.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by aishwarya on 4/8/16.
 */
public class Entry {
    @SerializedName("im:name")
    private Name mImName;
    @SerializedName("im:image")
    private ArrayList<Image> mImages;
    @SerializedName("summary")
    private Name mSummary;
    @SerializedName("im:vendorName")
    private Name mVendorName;
    @SerializedName("im:price")
    private Attributes mPrice;
    @SerializedName("title")
    private Name mTitle;
    @SerializedName("category")
    private Category mCategory;
    @SerializedName("im:artist")
    private ReleasedDate mArtist;
    @SerializedName("im:releaseDate")
    private ReleasedDate mReleasedDate;
    @SerializedName("link")
    private Link mLinks;

    public Link getLinks() {
        return mLinks;
    }

    public void setLinks(Link links) {
        mLinks = links;
    }

    public Name getImName() {
        return mImName;
    }

    public void setImName(Name imName) {
        mImName = imName;
    }

    public ArrayList<Image> getImages() {
        return mImages;
    }

    public void setImages(ArrayList<Image> images) {
        mImages = images;
    }

    public Name getSummary() {
        return mSummary;
    }

    public void setSummary(Name summary) {
        mSummary = summary;
    }

    public Name getVendorName() {
        return mVendorName;
    }

    public void setVendorName(Name vendorName) {
        mVendorName = vendorName;
    }

    public Attributes getPrice() {
        return mPrice;
    }

    public void setPrice(Attributes price) {
        mPrice = price;
    }

    public Name getTitle() {
        return mTitle;
    }

    public void setTitle(Name title) {
        mTitle = title;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    public ReleasedDate getArtist() {
        return mArtist;
    }

    public void setArtist(ReleasedDate artist) {
        mArtist = artist;
    }

    public ReleasedDate getReleasedDate() {
        return mReleasedDate;
    }

    public void setReleasedDate(ReleasedDate releasedDate) {
        mReleasedDate = releasedDate;
    }
}
