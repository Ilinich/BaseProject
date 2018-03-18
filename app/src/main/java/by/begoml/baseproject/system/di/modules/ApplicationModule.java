package by.begoml.baseproject.system.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import by.begoml.baseproject.data.DataManager;
import by.begoml.baseproject.data.DataManagerView;
import by.begoml.baseproject.system.ProjectApplication;
import by.begoml.baseproject.system.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ilinich on 18.03.2018.
 */
@Module
public class ApplicationModule {

    private final ProjectApplication mApplication;

    public ApplicationModule(ProjectApplication application) {
        this.mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManagerView provideDataManager(DataManager appDataManager) {
        return appDataManager;
    }
}
