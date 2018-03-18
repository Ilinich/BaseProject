package by.begoml.baseproject.data.db;

import android.annotation.SuppressLint;

import javax.inject.Inject;
import javax.inject.Singleton;

import by.begoml.baseproject.data.model.MovieEntity;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by ilinich on 18.03.2018.
 */
@Singleton
public class RealmManager implements RealmManagerView {

    @SuppressLint("StaticFieldLeak")
    private static Realm realm;

    @Inject
    public RealmManager() {
        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }
    }

    @Override
    public void replaceMovies(RealmList<MovieEntity> moviesEntity) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.delete(MovieEntity.class);
        realm.copyToRealmOrUpdate(moviesEntity);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public RealmResults<MovieEntity> getMovies() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<MovieEntity> realmResults = realm.where(MovieEntity.class).findAll();
        realm.commitTransaction();
        return realmResults;
    }

    @Override
    public MovieEntity getMovieEntity(int movieId) {
        return realm.where(MovieEntity.class)
                .equalTo("movieId", movieId)
                .findFirst();
    }

    @Override
    public void openRealm() {
        if (realm == null || realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }
    }

    public void closeRealm() {
        if (realm != null && !realm.isClosed()) {
            realm.close();
        }
    }
}
