package by.begoml.baseproject.data.net;

import by.begoml.baseproject.data.model.MainMovieEntity;
import io.reactivex.Observable;

/**
 * Created by ilinich on 18.03.2018.
 */

public interface IRestApi {

    Observable<MainMovieEntity> downloadMovies();
}
