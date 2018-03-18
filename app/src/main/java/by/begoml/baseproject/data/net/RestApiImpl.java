package by.begoml.baseproject.data.net;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import by.begoml.baseproject.data.model.MainMovieEntity;
import by.begoml.baseproject.system.di.ApplicationContext;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ilinich on 18.03.2018.
 */
@Singleton
public class RestApiImpl implements IRestApi {

    private final Context context;
    private RestApi restApi;

    @Inject
    public RestApiImpl(@ApplicationContext Context context) {
        if (context == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context;
        this.restApi = new RequestManager(context).getClient();
    }

    @Override
    public Observable<MainMovieEntity> downloadMovies() {
        return restApi.getMovies();
    }
}
