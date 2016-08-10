package com.example.aishwarya.topbooks.network;

import com.example.aishwarya.topbooks.model.TopBooksResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *
 */
public interface ApiInterface {

    @GET("{country_code}/rss/{book_type}/limit=25/json")
    Call<TopBooksResponse> getTopBooks(@Path("country_code") String countryCode, @Path("book_type") String bookType);


}
