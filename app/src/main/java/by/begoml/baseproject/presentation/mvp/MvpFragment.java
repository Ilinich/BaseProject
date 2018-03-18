package by.begoml.baseproject.presentation.mvp;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import by.begoml.baseproject.presentation.intarfaces.OnListFragmentInteractionListener;
import by.begoml.baseproject.presentation.other.managers.BaseScreenManager;

/**
 * Created by ilinich on 18.03.2018.
 */

public abstract class MvpFragment<P extends MvpPresenter, S extends BaseScreenManager
        , VDB extends ViewDataBinding> extends Fragment implements MvpView.View {

    protected P presenter;
    protected S screenManager;
    protected VDB binding;

    protected OnListFragmentInteractionListener mListener;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        if (activity instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView(this);
        presenter.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        screenManager = (S) mListener.getScreenManager();
        presenter.onActivityCreated();
    }

    @Override
    public void onStop() {
        presenter.onStop();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        presenter.onDestroyView();
        super.onDestroyView();
    }

    protected abstract P createPresenter();

    @Override
    public void showLoading() {
        screenManager.showLoading();
    }

    @Override
    public void hideLoading() {
        screenManager.hideLoading();
    }

    @Override
    public void showError(String message) {
        screenManager.showError(message);
    }
}
