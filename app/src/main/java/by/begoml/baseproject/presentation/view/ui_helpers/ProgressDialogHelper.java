package by.begoml.baseproject.presentation.view.ui_helpers;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatDialog;

import by.begoml.baseproject.R;

/**
 * Created by ilinich on 18.03.2018.
 */

public class ProgressDialogHelper {


    private Context context;
    private AppCompatDialog mProgressDialog;

    public ProgressDialogHelper(Context context) {
        this.context = context;
    }

    public void show() {
        if (getProgressDialog().isShowing()) {
            return;
        }

        getProgressDialog().show();
    }

    public void hide() {
        if (getProgressDialog().isShowing()) {
            mProgressDialog.dismiss();
        }
    }


    private void setupDlg() {
        if (mProgressDialog != null) {
            mProgressDialog.show();
            return;
        }

        mProgressDialog = new AppCompatDialog(context);
        mProgressDialog.setContentView(R.layout.progress_diallog);
        mProgressDialog.setCancelable(false);
        mProgressDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mProgressDialog.show();
    }

    private AppCompatDialog getProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new AppCompatDialog(context);
            mProgressDialog.setContentView(R.layout.progress_diallog);
            mProgressDialog.setCancelable(false);
            mProgressDialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(android.graphics.Color.TRANSPARENT));
        }

        return mProgressDialog;

    }
}
