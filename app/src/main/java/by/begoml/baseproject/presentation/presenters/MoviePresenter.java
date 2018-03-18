package by.begoml.baseproject.presentation.presenters;

import android.os.Bundle;

import by.begoml.baseproject.domain.GetMovieInteractor;
import by.begoml.baseproject.presentation.intarfaces.MovieView;
import by.begoml.baseproject.presentation.mvp.MvpPresenter;
import by.begoml.baseproject.presentation.view.view_models.MovieViewModel;

/**
 * Created by ilinich on 18.03.2018.
 */

public class MoviePresenter<ViewModel extends MovieViewModel> extends MvpPresenter<MovieView.View> {

    private int movieId;

    private ViewModel viewModel;

    public MoviePresenter(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addDisposable(new GetMovieInteractor<ViewModel>().getMovieViewModel(movieId)
                .subscribe(this::setViewModel, this::setThrowable));
    }

    @Override
    public void onCreateView() {
        super.onCreateView();
        getView().setViewModel(getViewModel());
    }

    private ViewModel getViewModel() {
        return viewModel;
    }

    private void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
