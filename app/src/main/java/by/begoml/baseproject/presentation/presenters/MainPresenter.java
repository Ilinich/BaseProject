package by.begoml.baseproject.presentation.presenters;

import android.os.Bundle;

import by.begoml.baseproject.domain.RealmInteractor;
import by.begoml.baseproject.presentation.mvp.MvpPresenter;
import by.begoml.baseproject.presentation.intarfaces.MainActivityView;

/**
 * Created by ilinich on 18.03.2018.
 */

public class MainPresenter extends MvpPresenter<MainActivityView> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openRealm();
        if (savedInstanceState == null) {
            openListMoviesScreen();
        }
    }

    private void openListMoviesScreen() {
        if (isViewAttached()) {
            getView().openListMoviesScreen();
        }
    }

    private void openRealm() {
        new RealmInteractor().openRealm().subscribe(() -> {
        }, tr -> {
        });
    }

    private void closeRealm() {
        new RealmInteractor().closeRealm().subscribe(() -> {
        }, tr -> {
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        closeRealm();
    }
}
