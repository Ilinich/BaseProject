package by.begoml.baseproject.presentation.presenters;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import by.begoml.baseproject.domain.DownloadMoviesInteractor;
import by.begoml.baseproject.domain.GetMoviesInteractor;
import by.begoml.baseproject.presentation.intarfaces.MoviesView;
import by.begoml.baseproject.presentation.mvp.MvpPresenter;
import by.begoml.baseproject.presentation.view.view_models.MovieViewModel;

/**
 * Created by ilinich on 18.03.2018.
 */

public class MoviesPresenter<ViewModel extends MovieViewModel> extends MvpPresenter<MoviesView.View> implements MoviesView.Presenter {

    private List<ViewModel> viewModels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMovies();
    }

    @Override
    public void onCreateView() {
        super.onCreateView();
        getView().setViewModels(getViewModels());
    }

    @Override
    public void onActivityCreated() {
        super.onActivityCreated();
        downloadMovies();
    }

    private void downloadMovies() {
        getView().showLoading();
        addDisposable(new DownloadMoviesInteractor().downloadMovies()
                .subscribe(() -> {
                    if (isViewAttached()) {
                        initMovies();
                        getView().hideLoading();
                        onCreateView();
                    }
                }, this::setThrowable));
    }

    private void initMovies() {
        addDisposable(new GetMoviesInteractor().getMovies()
                .subscribe(this::setViewModels, this::setThrowable));
    }

    public <ViewModel extends MovieViewModel> void onItemClick(ViewModel viewModel) {
        getView().openMovieScreen(viewModel.getIdViewModel());
    }

    private List<ViewModel> getViewModels() {
        if (viewModels == null) {
            viewModels = new ArrayList<>();
        }
        return viewModels;
    }

    private void setViewModels(List viewModels) {
        this.viewModels = viewModels;
    }
}
