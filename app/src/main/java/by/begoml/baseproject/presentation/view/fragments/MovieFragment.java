package by.begoml.baseproject.presentation.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.begoml.baseproject.R;
import by.begoml.baseproject.databinding.FragmentMovieBinding;
import by.begoml.baseproject.presentation.intarfaces.MovieView;
import by.begoml.baseproject.presentation.mvp.MvpFragment;
import by.begoml.baseproject.presentation.other.managers.MainScreenManager;
import by.begoml.baseproject.presentation.presenters.MoviePresenter;
import by.begoml.baseproject.presentation.view.view_models.MovieViewModel;

/**
 * Created by ilinich on 18.03.2018.
 */

public class MovieFragment extends MvpFragment<MoviePresenter, MainScreenManager, FragmentMovieBinding>
        implements MovieView.View {

    private final static String KEY_VIEW_MODEL = "viewModelId";

    public static MovieFragment newInstance(int viewModelId) {
        MovieFragment fragment = new MovieFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_VIEW_MODEL, viewModelId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);
        presenter.onCreateView();
        return binding.getRoot();
    }

    @Override
    protected MoviePresenter createPresenter() {
        return new MoviePresenter(getArguments().getInt(KEY_VIEW_MODEL));
    }

    @Override
    public <ViewModel extends MovieViewModel> void setViewModel(ViewModel viewModel) {
        binding.setVm(viewModel);
    }
}
