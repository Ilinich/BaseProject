package by.begoml.baseproject.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;

/**
 * Created by ilinich on 18.03.2018.
 */

public class MainMovieEntity {

    @SerializedName("list")
    @Expose
    public RealmList<MovieEntity> moviesEntity = null;

    public RealmList<MovieEntity> getMoviesEntity() {
        if (moviesEntity == null) {
            moviesEntity = new RealmList<>();
        }
        return moviesEntity;
    }
}
