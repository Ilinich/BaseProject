package by.begoml.baseproject.data;

import by.begoml.baseproject.data.model.MainMovieEntity;
import by.begoml.baseproject.data.model.MovieEntity;
import io.reactivex.Observable;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by ilinich on 18.03.2018.
 */

public interface DataManagerView {
    Observable<MainMovieEntity> downloadMovies();

    void replaceMovies(RealmList<MovieEntity> moviesEntity);

    RealmResults<MovieEntity> getMovies();

    MovieEntity getMovieEntity(int movieId);

    void closeRealm();

    void openRealm();
}
