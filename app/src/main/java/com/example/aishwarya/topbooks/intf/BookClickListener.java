package com.example.aishwarya.topbooks.intf;

import com.example.aishwarya.topbooks.model.Book;

/**
 * Interface that provides callback when a book item is clicked
 */
public interface BookClickListener {
    void onBookClicked(Book book);
}
