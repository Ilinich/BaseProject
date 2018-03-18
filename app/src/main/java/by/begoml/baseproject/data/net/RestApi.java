package by.begoml.baseproject.data.net;

import java.util.List;

import by.begoml.baseproject.data.model.MainMovieEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ilinich on 18.03.2018.
 */

public interface RestApi {

    @GET("/v2/57cffac8260000181e650041?lipi=urn%3Ali%3Apage%3Ad_flagship3_messaging%3BQ97VvPFcQsGaSzJNqVpFHA%3D%3D")
    Observable<MainMovieEntity> getMovies();
}
