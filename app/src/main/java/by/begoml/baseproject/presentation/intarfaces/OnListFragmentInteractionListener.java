package by.begoml.baseproject.presentation.intarfaces;

import by.begoml.baseproject.presentation.other.managers.BaseScreenManager;

/**
 * Created by ilinich on 18.03.2018.
 */

public interface OnListFragmentInteractionListener<S extends BaseScreenManager> {

    S getScreenManager();

}
