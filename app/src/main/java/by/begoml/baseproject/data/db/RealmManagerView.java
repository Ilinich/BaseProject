package by.begoml.baseproject.data.db;

import by.begoml.baseproject.data.model.MovieEntity;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by ilinich on 18.03.2018.
 */

public interface RealmManagerView {

    void replaceMovies(RealmList<MovieEntity> moviesEntity);

    void closeRealm();

    RealmResults<MovieEntity> getMovies();

    MovieEntity getMovieEntity(int movieId);

    void openRealm();
}
