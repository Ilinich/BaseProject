package by.begoml.baseproject.domain;


import by.begoml.baseproject.domain.mappers.MovieMapper;
import by.begoml.baseproject.presentation.view.view_models.MovieViewModel;
import io.reactivex.Observable;


/**
 * Created by ilinich on 18.03.2018.
 */

public class GetMovieInteractor<ViewModel extends MovieViewModel> extends BaseInteractor {

    public Observable<ViewModel> getMovieViewModel(int movieId) {
        return Observable.just(movieId)
                .map(id -> getDataManager().getMovieEntity(id))
                .map(MovieMapper.applyViewModel());
    }
}
