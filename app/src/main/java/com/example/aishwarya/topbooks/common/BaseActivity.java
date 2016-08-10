package com.example.aishwarya.topbooks.common;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.aishwarya.topbooks.R;
import com.example.aishwarya.topbooks.intf.SpinnerClickListener;

public class BaseActivity extends AppCompatActivity implements SpinnerClickListener {
    private static final String TAG = BaseActivity.class.getSimpleName();
    private SpinnerClickListener mSpinnerClickListener;


    /**
     * function that sets toolbar text
     * @param title text to be displayed
     */
    public void setToolBarTitle(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(getSupportActionBar() != null)
            getSupportActionBar().setTitle("");
        TextView titleView = (TextView) toolbar.findViewById(R.id.tv_toolbar_title);
        titleView.setText(title);
        titleView.setTextColor(Color.WHITE);
    }

    /**
     * function that initialises the toolbar
     */

    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * function that initialises the spinner
     * @param context calling context
     */

    public void initSpinner(Context context) {
        mSpinnerClickListener = (SpinnerClickListener) context;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(getSupportActionBar() != null) {
            Spinner spinner = (Spinner) toolbar.findViewById(R.id.country_spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.country_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position,
                                                                                        long l) {
                    mSpinnerClickListener.onSpinnerItemSelected(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }


    }

    /**
     * Function used to set the status bar color
     */

    public void setStatusBarColor(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int color = ContextCompat.getColor(context, R.color.dark_red);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    @Override
    public void onSpinnerItemSelected(int position) {

    }
}
