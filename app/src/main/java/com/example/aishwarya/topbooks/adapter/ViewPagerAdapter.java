package com.example.aishwarya.topbooks.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.aishwarya.topbooks.Constants;
import com.example.aishwarya.topbooks.intf.BookType;
import com.example.aishwarya.topbooks.ui.BooksFragment;

/**
 * Adapter for the view pager
 */
public class ViewPagerAdapter  extends FragmentPagerAdapter {


    public static final int NUMBER_OF_TABS = 3;

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        BooksFragment booksFragment;
        Bundle bundle = new Bundle();
        switch(position) {
            case Constants.FIRST_TAB:
                bundle.putSerializable(Constants.BOOKTYPE, BookType.FREE);
                break;
            case Constants.SECOND_TAB:
                bundle.putSerializable(Constants.BOOKTYPE, BookType.PAID);
                break;
            case Constants.THIRD_TAB:
                bundle.putSerializable(Constants.BOOKTYPE, BookType.TEXT);
                break;
        }
        booksFragment = new BooksFragment();
        booksFragment.setArguments(bundle);
        return booksFragment;
    }

    @Override
    public int getCount() {
        return NUMBER_OF_TABS;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch(position) {
            case Constants.FIRST_TAB:
                title = "Free";
                break;
            case Constants.SECOND_TAB:
                title = "Paid";
                break;
            case Constants.THIRD_TAB:
                title = "Text";
                break;
        }
        return title;
    }


}

