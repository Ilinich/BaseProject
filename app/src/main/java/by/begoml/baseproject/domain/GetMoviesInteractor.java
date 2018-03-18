package by.begoml.baseproject.domain;

import java.util.ArrayList;
import java.util.List;

import by.begoml.baseproject.domain.mappers.MovieMapper;
import by.begoml.baseproject.presentation.view.view_models.MovieViewModel;
import io.reactivex.Observable;

/**
 * Created by ilinich on 18.03.2018.
 */

public class GetMoviesInteractor extends BaseInteractor {

    public Observable<List<MovieViewModel>> getMovies() {
        return Observable.fromCallable(() -> getDataManager().getMovies())
                .flatMap(this::getViewModels);
    }


    private Observable<List<MovieViewModel>> getViewModels(List models) {
        return Observable.
                fromIterable(models)
                .filter(v -> v != null)
                .map(MovieMapper.applyViewModel())
                .toList()
                .toObservable();
    }
}
