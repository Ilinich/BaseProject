package by.begoml.baseproject.presentation.other.managers;

/**
 * Created by ilinich on 18.03.2018.
 */

public interface ScreenManagerView {

    void showError(String anError);

    void showLoading();

    void hideLoading();

    void initView();

    void onBackStackChange();

    void onBackPressed();
}
