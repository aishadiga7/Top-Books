package com.example.aishwarya.topbooks.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by aishwarya on 4/8/16.
 */
public class Feed {
    @SerializedName("author")
    private Author mAuthor;
    @SerializedName("entry")
    private ArrayList<Entry> mEntry;
    @SerializedName("updated")
    private Updated mUpdated;
    @SerializedName("rights")
    private Rights mRights;
    @SerializedName("title")
    private Title mTitle;
    @SerializedName("icon")
    private Icon mIcon;
    @SerializedName("link")
    private ArrayList<Link> mLinks;
    @SerializedName("id")
    private Id mId;

    public Author getAuthor() {
        return mAuthor;
    }

    public void setAuthor(Author author) {
        mAuthor = author;
    }

    public ArrayList<Entry> getEntry() {
        return mEntry;
    }

    public void setEntry(ArrayList<Entry> entry) {
        mEntry = entry;
    }

    public Updated getUpdated() {
        return mUpdated;
    }

    public void setUpdated(Updated updated) {
        mUpdated = updated;
    }

    public Rights getRights() {
        return mRights;
    }

    public void setRights(Rights rights) {
        mRights = rights;
    }

    public Title getTitle() {
        return mTitle;
    }

    public void setTitle(Title title) {
        mTitle = title;
    }

    public Icon getIcon() {
        return mIcon;
    }

    public void setIcon(Icon icon) {
        mIcon = icon;
    }

    public ArrayList<Link> getLinks() {
        return mLinks;
    }

    public void setLinks(ArrayList<Link> links) {
        mLinks = links;
    }

    public Id getId() {
        return mId;
    }

    public void setId(Id id) {
        mId = id;
    }
}
