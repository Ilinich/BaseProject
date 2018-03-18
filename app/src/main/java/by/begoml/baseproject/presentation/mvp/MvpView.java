package by.begoml.baseproject.presentation.mvp;

import android.os.Bundle;

/**
 * Created by ilinich on 18.03.2018.
 */

public interface MvpView {

    interface View{

        void showLoading();

        void hideLoading();

        void showError(String message);
    }

    interface PresenterView{
        void onStop();

        void onCreateView();

        void onCreate(Bundle savedInstanceState);

        void onPause();

        void onDestroyView();

        void onActivityCreated();
    }
}
