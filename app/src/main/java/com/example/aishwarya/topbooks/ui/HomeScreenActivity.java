package com.example.aishwarya.topbooks.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.aishwarya.topbooks.Constants;
import com.example.aishwarya.topbooks.R;
import com.example.aishwarya.topbooks.Utils.JsonUtil;
import com.example.aishwarya.topbooks.adapter.ViewPagerAdapter;
import com.example.aishwarya.topbooks.common.BaseActivity;
import com.example.aishwarya.topbooks.manager.AnalyticsManager;
import com.example.aishwarya.topbooks.model.Country;
import com.example.aishwarya.topbooks.model.CountryList;

import java.io.IOException;
import java.util.ArrayList;

public class HomeScreenActivity extends BaseActivity implements ViewPager.OnPageChangeListener{
    private static final String TAG = HomeScreenActivity.class.getSimpleName();
    private static final int VIEWPAGER_OFF_SCREEN_LIMIT = 3;
    private ArrayList<CountryListener> mCountryListeners = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        setStatusBarColor(this);
        initToolBar();
        initSpinner(this);
        setToolBarTitle(getString(R.string.home));
        initTabs();
    }

    private void initTabs() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.addOnPageChangeListener(this);
        setupViewPager(viewPager);
        viewPager.setOffscreenPageLimit(VIEWPAGER_OFF_SCREEN_LIMIT);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        if (tabLayout != null) {
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch(position) {
            case Constants.FIRST_TAB:
                AnalyticsManager.logScreenName(HomeScreenActivity.this, getResources().getString(R.string.first_tab_name));
                break;
            case Constants.SECOND_TAB:
                AnalyticsManager.logScreenName(HomeScreenActivity.this, getResources().getString(R.string.second_tab_name));
                break;
            case Constants.THIRD_TAB:
                AnalyticsManager.logScreenName(HomeScreenActivity.this, getResources().getString(R.string.third_tab_name));
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public interface CountryListener {
        void onCountrySelected(String code);
    }

    public void addCountryListener(CountryListener listener) {
        mCountryListeners.add(listener);
    }

    @Override
    public void onSpinnerItemSelected(int position) {
        super.onSpinnerItemSelected(position);
        Country country = getSelectedCountryDetails(position);
        AnalyticsManager.logEvent(HomeScreenActivity.this, getString(R.string
                                            .country_name_tracking), getString(R.string.log_country_name), country.getCountryName());
        Log.d(TAG, "Selected country Name:" +country.getCountryName());
        Log.d(TAG, "Selected country Id:" +country.getCountryId());
        for(CountryListener listener : mCountryListeners) {
            if (listener != null && country != null) {
                listener.onCountrySelected(country.getCountryId());
            }
        }
    }

    private Country getSelectedCountryDetails(int position) {
        Country selectedCountry = null;
        try {
            CountryList countryList = JsonUtil.parseAssetJSON(this,
                    "Country" + ".json", CountryList.class);
            ArrayList<Country> countries = countryList.getCountries();
            if (countries != null) {
                selectedCountry = countries.get(position);
            }
        } catch (IOException e) {
            e.printStackTrace();
            selectedCountry =  null;
        }
        return selectedCountry;
    }

}
