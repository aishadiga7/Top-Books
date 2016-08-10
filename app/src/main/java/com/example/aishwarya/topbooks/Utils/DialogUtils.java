package com.example.aishwarya.topbooks.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

/**
 * Util class having dialogs related functionalities
 */
public class DialogUtils {
    private static final String TAG = DialogUtils.class.getSimpleName();
    private static ProgressDialog mProgressDialog = null;

    /**
     * Function used to set up progress dialog
     * @param context calling context
     * @param message message to be displayed
     */

    public static void showProgressDialog(Context context, String message){
        if(mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.setMessage(message);
            mProgressDialog.show();
        }
    }

    /**
     * Function used to dismiss the progress dialog
     */

    public static void dismissProgressDialog() {
        if((mProgressDialog != null) && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    /**
     * Function that is used to show messages through toast
     * @param view view on top of which snack bar has to be shown
     * @param message message to be shown
     */

    public static void showSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    /**
     * Function that is used to show toast messages
     * @param context calling context
     * @param message message to be displayed
     */

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
