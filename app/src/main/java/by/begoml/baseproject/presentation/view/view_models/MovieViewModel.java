package by.begoml.baseproject.presentation.view.view_models;

import android.databinding.Bindable;

/**
 * Created by ilinich on 18.03.2018.
 */

public class MovieViewModel extends BaseViewModel {

    private String title;
    private String description;
    private String premiere;
    private String imgUrl;

    public MovieViewModel(int idViewModel, String title, String description, String premiere
            , String imgUrl) {
        super(idViewModel);
        this.title = title;
        this.description = description;
        this.premiere = premiere;
        this.imgUrl = imgUrl;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    @Bindable
    public String getPremiere() {
        return premiere;
    }

    @Bindable
    public String getImgUrl() {
        return imgUrl;
    }
}
