package by.begoml.baseproject.presentation.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import by.begoml.baseproject.R;
import by.begoml.baseproject.presentation.mvp.MvpActivity;
import by.begoml.baseproject.presentation.intarfaces.MainActivityView;
import by.begoml.baseproject.presentation.other.managers.MainScreenManager;
import by.begoml.baseproject.presentation.presenters.MainPresenter;

/**
 * Created by ilinich on 18.03.2018.
 */

public class MainActivity extends MvpActivity<MainPresenter, MainScreenManager>
        implements MainActivityView {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenManager = initScreenManager();
        screenManager.initView();
        presenter.onCreate(savedInstanceState);
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected MainScreenManager initScreenManager() {
        return new MainScreenManager(this);
    }

    @Override
    public MainScreenManager getScreenManager() {
        return screenManager;
    }


    @Override
    public void openListMoviesScreen() {
        getScreenManager().openListMoviesScreen();
    }
}
