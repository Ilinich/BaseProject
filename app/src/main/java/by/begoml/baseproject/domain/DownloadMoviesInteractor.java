package by.begoml.baseproject.domain;

import by.begoml.baseproject.data.model.MovieEntity;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.realm.RealmList;

/**
 * Created by ilinich on 18.03.2018.
 */

public class DownloadMoviesInteractor extends BaseInteractor {

    public Completable downloadMovies() {
        return getDataManager().downloadMovies()
                .map(mainMovieEntity -> {
                    int idx = 0;
                    RealmList<MovieEntity> moviesEntity = mainMovieEntity.getMoviesEntity();
                    for (MovieEntity movieEntity : mainMovieEntity.getMoviesEntity()) {
                        movieEntity.setMovieId(idx);
                        idx++;
                    }
                    return moviesEntity;
                })
                .flatMapCompletable(moviesEntity -> {
                    getDataManager().replaceMovies(moviesEntity);
                    return Completable.complete();
                })
                .compose(applySchedulersCompletable());
    }
}
