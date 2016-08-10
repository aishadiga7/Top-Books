package com.example.aishwarya.topbooks.network;

import android.util.Log;

import com.example.aishwarya.topbooks.intf.BookFetchListener;
import com.example.aishwarya.topbooks.model.TopBooksResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Singleton Network Adapter class having various API Call functions
 */
public class NetworkAdapter {
    private static final String TAG = NetworkAdapter.class.getSimpleName();
    private static NetworkAdapter sInstance = null;
    ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);

    private NetworkAdapter() {

    }

    public static NetworkAdapter getInstance() {
        if (sInstance == null) {
            sInstance = new NetworkAdapter();
        }
        return sInstance;
    }

    /**
     * API Call to get top books
     * @param countryName country name of the books
     * @param booktype  type of books , it might be "free", "paid" or "text"
     * @param callback response callback
     */

    public void getTopBooks(String countryName, final String booktype, final BookFetchListener  callback) {
        Call<TopBooksResponse> call = mApiInterface.getTopBooks(countryName, booktype);
        Log.d(TAG, "URL:" + call.request());
        call.enqueue(new Callback<TopBooksResponse>() {
            @Override
            public void onResponse(Call<TopBooksResponse> call, Response<TopBooksResponse> response) {
                if (response != null && response.body() !=null) {
                    callback.onBooksFetched(response);
                }
            }

            @Override
            public void onFailure(Call<TopBooksResponse> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
                callback.onBooksFetchFailed(throwable.getMessage());
            }
        });

    }

}
