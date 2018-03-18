package by.begoml.baseproject.presentation.other.managers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import by.begoml.baseproject.R;
import by.begoml.baseproject.presentation.view.ui_helpers.ProgressDialogHelper;

/**
 * Created by ilinich on 18.03.2018.
 */

public abstract class BaseScreenManager implements ScreenManagerView {

    protected WeakReference<AppCompatActivity> activity;
    protected FragmentManager fragmentManager;
    private ProgressDialogHelper dialogHelper;
    protected Toolbar toolbar;

    public BaseScreenManager(AppCompatActivity appCompatActivity) {
        this.fragmentManager = appCompatActivity.getSupportFragmentManager();
        this.activity = new WeakReference<>(appCompatActivity);
        dialogHelper = new ProgressDialogHelper(appCompatActivity);
    }

    @Override
    public void initView() {
        toolbar = activity.get().findViewById(R.id.toolbar);
        activity.get().setSupportActionBar(toolbar);
    }

    public Fragment getCurrentFragment() {
        return fragmentManager.findFragmentById(R.id.content_frame);
    }

    @Override
    public void hideLoading() {
        dialogHelper.hide();
    }


    @Override
    public void showLoading() {
        dialogHelper.show();
    }

    @Override
    public void onBackPressed() {
        if (isLastFragmentinStack()) {
            activity.get().finish();
        } else {
            popBackStackImmediate();
        }
    }

    private void popBackStackImmediate() {
        fragmentManager.popBackStackImmediate();
    }

    private boolean isLastFragmentinStack() {
        return fragmentManager.getBackStackEntryCount() == 0;
    }

    @Override
    public void onBackStackChange() {
        AppCompatActivity activity = this.activity.get();
        if (activity.getSupportActionBar() != null) {
            if (isLastFragmentinStack()) {
                toolbar.setNavigationIcon(null);
            } else {
                toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
            }
        }
    }

    @Override
    public void showError(String errorRmessage) {
        Toast.makeText(activity.get(), errorRmessage, Toast.LENGTH_SHORT).show();
    }

    protected void replaceFragment(Fragment fragment){
        FragmentTransaction tr = fragmentManager.beginTransaction();
        tr.replace(R.id.content_frame, fragment);
        tr.commitAllowingStateLoss();
    }

    protected void addFragment(Fragment fragment){
        FragmentTransaction tr = fragmentManager.beginTransaction();
        tr.add(R.id.content_frame, fragment);
        tr.addToBackStack(null);
        tr.commitAllowingStateLoss();
    }
}
