package by.begoml.baseproject.domain;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Created by ilinich on 18.03.2018.
 */

public class RealmInteractor extends BaseInteractor {

    public Completable closeRealm() {
        return Completable.fromAction(() -> getDataManager().closeRealm());
    }

    public Completable openRealm() {
        return Completable.fromAction(() -> getDataManager().openRealm());
    }
}
