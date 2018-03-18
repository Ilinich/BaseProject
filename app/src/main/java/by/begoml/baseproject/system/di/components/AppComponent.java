package by.begoml.baseproject.system.di.components;

import javax.inject.Singleton;

import by.begoml.baseproject.domain.BaseInteractor;
import by.begoml.baseproject.system.di.modules.ApplicationModule;
import dagger.Component;

/**
 * Created by ilinich on 18.03.2018.
 */
@Component(modules = {ApplicationModule.class})
@Singleton
public interface AppComponent {

    void inject(BaseInteractor baseInteractor);
}
