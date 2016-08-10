package com.example.aishwarya.topbooks.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aishwarya.topbooks.Constants;
import com.example.aishwarya.topbooks.R;
import com.example.aishwarya.topbooks.Utils.DialogUtils;
import com.example.aishwarya.topbooks.Utils.NetworkUtils;
import com.example.aishwarya.topbooks.adapter.BooksAdapter;
import com.example.aishwarya.topbooks.intf.BookClickListener;
import com.example.aishwarya.topbooks.intf.BookFetchListener;
import com.example.aishwarya.topbooks.intf.BookType;
import com.example.aishwarya.topbooks.manager.AnalyticsManager;
import com.example.aishwarya.topbooks.model.Book;
import com.example.aishwarya.topbooks.model.Entry;
import com.example.aishwarya.topbooks.model.TopBooksResponse;
import com.example.aishwarya.topbooks.network.NetworkAdapter;

import java.util.ArrayList;

import retrofit2.Response;


public class BooksFragment extends Fragment implements BookClickListener,
                                                        HomeScreenActivity.CountryListener , BookFetchListener{
    private static final String TAG = BooksFragment.class.getSimpleName();
    private BookType mBookType;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                             Bundle savedInstanceState) {
        mBookType = (BookType) getArguments().getSerializable(Constants.BOOKTYPE);
        return inflater.inflate(R.layout.fragment_free_books, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.free_books);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof HomeScreenActivity) {
            HomeScreenActivity homeScreenActivity = (HomeScreenActivity) context;
            homeScreenActivity.addCountryListener(this);
        }
    }

    private void initRecyclerView(ArrayList<Book> topFreeBooks) {
        RecyclerView booksRecyclerView = mRecyclerView;
        if (booksRecyclerView != null) {
            booksRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            BooksAdapter   booksAdapter = new BooksAdapter(topFreeBooks, getActivity(),
                                                                        this);
            booksRecyclerView.setAdapter(booksAdapter);
            booksRecyclerView.setItemAnimator(new DefaultItemAnimator());
        }
    }

    @Override
    public void onBookClicked(Book book) {
        if (book != null) {
            AnalyticsManager.logEvent(getActivity(), book.getName(), book.getCategory(), book.getName());
            Intent webViewIntent = new Intent(getActivity(), WebViewActivity.class);
            webViewIntent.putExtra(Constants.BOOK_URL, book.getBookWebViewLink());
            startActivity(webViewIntent);
        }
    }


    public void fetchBooks(BookType bookType, String countryCode) {
        switch (bookType) {
            case FREE:
                makeAPICallToFetchBooks(countryCode, getActivity().getString(R.string.top_free_books));
                break;
            case PAID:
                makeAPICallToFetchBooks(countryCode, getActivity().getString(R.string.top_paid_books));
                break;
            case TEXT:
                makeAPICallToFetchBooks(countryCode, getActivity().getString(R.string.top_text_books));
                break;
        }
    }

    private void makeAPICallToFetchBooks(String countryName, final String booktype) {
        if (NetworkUtils.isNetworkAvailable(getActivity())) {
            DialogUtils.showProgressDialog(getActivity(), getString(R.string.loading));
            NetworkAdapter.getInstance().getTopBooks(countryName, booktype, this);
        } else {
            DialogUtils.showSnackBar(getActivity().getWindow().getDecorView().findViewById
                    (android.R.id
                            .content), getString(R.string.please_check_internet));
        }
    }

    private void handleSuccessOfFetchBooks(Response<TopBooksResponse> response) {
        TopBooksResponse topBooksResponse = response.body();
        if (topBooksResponse != null) {
            ArrayList<Book> books = new ArrayList<>();
            Book book = null;
            if (topBooksResponse.getFeed().getEntry() != null) {
                for (Entry entries : topBooksResponse.getFeed().getEntry()) {
                    book = new Book();
                    book.setName(entries.getImName().getLabel());
                    book.setAuthor(entries.getArtist().getLabel());
                    book.setCategory(entries.getCategory().getAttributes().getLabel());
                    book.setReleasedOn(entries.getReleasedDate().getAttributes().getLabel());
                    book.setPrice(entries.getPrice().getLabel());
                    String price = (entries.getPrice().getLabel().equals(getActivity().getString(R.string.placeholder_when_no_amount))? "0.0":
                                                                                (entries.getPrice().getLabel()));
                    book.setPrice(price);
                    book.setBookImageUrl(entries.getImages().get(0).getUrl());
                    book.setBookWebViewLink(entries.getLinks().getAttributes().getHref());
                    books.add(book);
                }
                initRecyclerView(books);
            }
        }
    }

    @Override
    public void onCountrySelected(String countryCode) {
        fetchBooks(mBookType, countryCode);
    }

    @Override
    public void onBooksFetched(Response<TopBooksResponse> response) {
        if (response != null) {
            DialogUtils.dismissProgressDialog();
            Log.d(TAG, "OnSuccess():");
            if (response.isSuccessful()) {
                handleSuccessOfFetchBooks(response);
            } else  {
                DialogUtils.showSnackBar(getActivity().getWindow().getDecorView()
                        .findViewById(android.R.id.content), getString(R.string.something_went_wrong));
            }

        }
    }

    @Override
    public void onBooksFetchFailed(String message) {
        DialogUtils.dismissProgressDialog();
        Log.d(TAG, "onFailure():" +message);
        DialogUtils.showSnackBar(getActivity().getWindow().getDecorView()
                .findViewById(android.R.id
                        .content), getString(R.string.rest_error));
    }
}
