package by.begoml.baseproject.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by ilinich on 18.03.2018.
 */

public class MovieEntity extends RealmObject {

    private int movieId;

    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("name_eng")
    @Expose
    public String nameEng;
    @SerializedName("premiere")
    @Expose
    public String premiere;
    @SerializedName("description")
    @Expose
    public String description;

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getNameEng() {
        return nameEng;
    }

    public String getPremiere() {
        return premiere;
    }

    public String getDescription() {
        return description;
    }
}
