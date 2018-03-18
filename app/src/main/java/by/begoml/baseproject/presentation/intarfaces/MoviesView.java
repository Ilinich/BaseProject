package by.begoml.baseproject.presentation.intarfaces;

import java.util.List;

import by.begoml.baseproject.presentation.mvp.MvpView;

/**
 * Created by ilinich on 18.03.2018.
 */

public interface MoviesView {

    interface View extends MvpView.View {
        void setViewModels(List arrViewModels);

        void openMovieScreen(int idViewModel);
    }

    interface Presenter extends MvpView.PresenterView {

    }
}
