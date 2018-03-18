package by.begoml.baseproject.system;

import android.support.multidex.MultiDexApplication;

import by.begoml.baseproject.system.di.components.AppComponent;
import by.begoml.baseproject.system.di.components.DaggerAppComponent;
import by.begoml.baseproject.system.di.modules.ApplicationModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ilinich on 18.03.2018.
 */

public class ProjectApplication extends MultiDexApplication {

    public final static int SCHEMA_VERSION = 0;
    public static final String REALM_DB_NAME = "locationTrackerService.realm";

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initRealmConfiguration();
        initializeInjector();
    }

    private void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    private void initRealmConfiguration() {
        Realm.init(this);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(REALM_DB_NAME)
                .schemaVersion(SCHEMA_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }


    public static AppComponent getAppComponent() {
        return appComponent;
    }

}
