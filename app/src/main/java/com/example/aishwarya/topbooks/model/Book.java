package com.example.aishwarya.topbooks.model;

/**
 * Model class that holds Book object
 */
public class Book {
    private String mName;
    private String mAuthor;
    private String mCategory;
    private String mReleasedOn;
    private String mPrice;
    private String mBookImageUrl;
    private String mBookWebViewLink;

    public String getBookWebViewLink() {
        return mBookWebViewLink;
    }

    public void setBookWebViewLink(String bookWebViewLink) {
        mBookWebViewLink = bookWebViewLink;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getReleasedOn() {
        return mReleasedOn;
    }

    public void setReleasedOn(String releasedOn) {
        mReleasedOn = releasedOn;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getBookImageUrl() {
        return mBookImageUrl;
    }

    public void setBookImageUrl(String bookImageUrl) {
        mBookImageUrl = bookImageUrl;
    }
}
