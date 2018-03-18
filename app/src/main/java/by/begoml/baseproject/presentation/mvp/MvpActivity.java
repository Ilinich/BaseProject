package by.begoml.baseproject.presentation.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import by.begoml.baseproject.presentation.intarfaces.OnListFragmentInteractionListener;
import by.begoml.baseproject.presentation.other.managers.BaseScreenManager;

/**
 * Created by ilinich on 18.03.2018.
 */

public abstract class MvpActivity<P extends MvpPresenter, S extends BaseScreenManager>
        extends AppCompatActivity implements MvpView.View
        , FragmentManager.OnBackStackChangedListener, OnListFragmentInteractionListener {

    protected P presenter;
    protected S screenManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView(this);
    }

    protected abstract P createPresenter();

    protected abstract S initScreenManager();

    public abstract S getScreenManager();

    @Override
    public void hideLoading() {
        screenManager.hideLoading();
    }

    @Override
    public void showError(String anError) {
        screenManager.showError(anError);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroyView();
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        screenManager.showLoading();
    }

    @Override
    public void onBackPressed() {
        screenManager.onBackPressed();
    }

    @Override
    public void onBackStackChanged() {
        screenManager.onBackStackChange();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        getSupportFragmentManager().removeOnBackStackChangedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                screenManager.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


}
