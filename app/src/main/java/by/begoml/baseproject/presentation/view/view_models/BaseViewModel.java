package by.begoml.baseproject.presentation.view.view_models;

import android.databinding.BaseObservable;

/**
 * Created by ilinich on 18.03.2018.
 */

public class BaseViewModel extends BaseObservable {

    private int idViewModel;

    public BaseViewModel(int idViewModel) {
        this.idViewModel = idViewModel;
    }

    public int getIdViewModel() {
        return idViewModel;
    }
}
