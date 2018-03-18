package by.begoml.baseproject.presentation.mvp;

import android.os.Bundle;
import android.support.annotation.CallSuper;

import by.begoml.baseproject.presentation.other.exception.ErrorMessageFactory;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by ilinich on 18.03.2018.
 */

public abstract class MvpPresenter<V extends MvpView.View> implements MvpView.PresenterView {

    protected V view;

    private CompositeDisposable compositeSubscription;

    public MvpPresenter() {
        compositeSubscription = new CompositeDisposable();
    }

    public <View extends MvpView.View> void attachView(View view) {
        this.view = (V) view;
    }

    @Override
    @CallSuper
    public void onStop() {

    }

    @Override
    @CallSuper
    public void onCreateView() {

    }

    @Override
    @CallSuper
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    @CallSuper
    public void onPause() {

    }

    @Override
    @CallSuper
    public void onDestroyView() {
        compositeSubscription.clear();
        dettachView();
    }

    @Override
    @CallSuper
    public void onActivityCreated() {

    }

    protected void addDisposable(Disposable disposable) {
        compositeSubscription.add(disposable);
    }



    protected String getAnError(Throwable e) {
        return ErrorMessageFactory.create( e);
    }

    public boolean isViewAttached() {
        return view != null;
    }

    protected void setThrowable(Throwable throwable) {
        if (isViewAttached()) {
            view.hideLoading();
            view.showError(getAnError(throwable));
        }
    }

    private void dettachView() {
        this.view = null;
    }

    protected V getView() {
        return view;
    }
}
