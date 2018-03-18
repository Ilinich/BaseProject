package by.begoml.baseproject.presentation.other.managers;

import android.support.v7.app.AppCompatActivity;

import by.begoml.baseproject.presentation.view.fragments.MovieFragment;
import by.begoml.baseproject.presentation.view.fragments.MoviesFragment;

/**
 * Created by ilinich on 18.03.2018.
 */

public class MainScreenManager extends BaseScreenManager {


    public MainScreenManager(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
    }

    public void openListMoviesScreen() {
        replaceFragment(MoviesFragment.newInstance());
    }

    public void openMovieScreen(int idViewModel) {
        addFragment(MovieFragment.newInstance(idViewModel));
    }
}
