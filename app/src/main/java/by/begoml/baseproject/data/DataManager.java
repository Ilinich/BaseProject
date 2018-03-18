package by.begoml.baseproject.data;

import android.content.Context;


import javax.inject.Inject;
import javax.inject.Singleton;

import by.begoml.baseproject.data.db.RealmManager;
import by.begoml.baseproject.data.db.RealmManagerView;
import by.begoml.baseproject.data.model.MainMovieEntity;
import by.begoml.baseproject.data.model.MovieEntity;
import by.begoml.baseproject.data.net.IRestApi;
import by.begoml.baseproject.data.net.RestApiImpl;
import by.begoml.baseproject.system.di.ApplicationContext;
import io.reactivex.Observable;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by ilinich on 18.03.2018.
 */
@Singleton
public class DataManager implements DataManagerView {

    private final Context mContext;
    private IRestApi restApi;
    private RealmManagerView realmManagerView;

    @Inject
    public DataManager(@ApplicationContext Context context
            , RestApiImpl restApi, RealmManager realmManager) {
        mContext = context;
        this.restApi = restApi;
        this.realmManagerView = realmManager;
    }


    public Observable<MainMovieEntity> downloadMovies() {
        return restApi.downloadMovies();
    }

    @Override
    public void replaceMovies(RealmList<MovieEntity> moviesEntity) {
        realmManagerView.replaceMovies(moviesEntity);
    }

    @Override
    public RealmResults<MovieEntity> getMovies() {
        return realmManagerView.getMovies();
    }

    @Override
    public MovieEntity getMovieEntity(int movieId) {
        return realmManagerView.getMovieEntity(movieId);
    }

    @Override
    public void closeRealm() {
        realmManagerView.closeRealm();
    }

    @Override
    public void openRealm() {
        realmManagerView.openRealm();
    }

}
