package com.example.aishwarya.topbooks.intf;

import com.example.aishwarya.topbooks.model.TopBooksResponse;

import retrofit2.Response;

/**
 * Interface having callbacks for handling API results.
 */
public interface BookFetchListener {
    void onBooksFetched(Response<TopBooksResponse> response);

    void onBooksFetchFailed(String message);
}
