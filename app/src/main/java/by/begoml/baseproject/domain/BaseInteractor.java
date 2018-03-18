package by.begoml.baseproject.domain;

import javax.inject.Inject;

import by.begoml.baseproject.data.DataManager;
import by.begoml.baseproject.system.ProjectApplication;
import io.reactivex.CompletableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ilinich on 18.03.2018.
 */

public abstract class BaseInteractor {

    @Inject
    protected DataManager dataManager;

    private ObservableTransformer schedulersTransformer;

    public BaseInteractor() {
        initializeInjector();

        schedulersTransformer = observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }

    private void initializeInjector() {
        if (ProjectApplication.getAppComponent() != null) {
            ProjectApplication.getAppComponent().inject(this);
        }
    }


    @SuppressWarnings("unchecked")
    protected <T> ObservableTransformer<T, T> applySchedulers() {
        return getSchedulersTransformer();
    }

    public <T> ObservableTransformer<T, T> getSchedulersTransformer() {
        return (ObservableTransformer<T, T>) schedulersTransformer;
    }

    public CompletableTransformer applySchedulersCompletable() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io());
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
