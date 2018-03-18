package by.begoml.baseproject.presentation.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import by.begoml.baseproject.R;
import by.begoml.baseproject.databinding.FragmentMoviesBinding;
import by.begoml.baseproject.presentation.intarfaces.OnItemClickListener;
import by.begoml.baseproject.presentation.intarfaces.MoviesView;
import by.begoml.baseproject.presentation.mvp.MvpFragment;
import by.begoml.baseproject.presentation.other.data_binding.RecyclerConfiguration;

import by.begoml.baseproject.presentation.other.managers.MainScreenManager;
import by.begoml.baseproject.presentation.presenters.MoviesPresenter;
import by.begoml.baseproject.presentation.view.adapters.MoviesAdapter;
import by.begoml.baseproject.presentation.view.view_models.MovieViewModel;

/**
 * Created by ilinich on 18.03.2018.
 */

public class MoviesFragment extends MvpFragment<MoviesPresenter, MainScreenManager, FragmentMoviesBinding>
        implements MoviesView.View, OnItemClickListener {

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false);
        presenter.onCreateView();
        return binding.getRoot();
    }


    @Override
    protected MoviesPresenter createPresenter() {
        return new MoviesPresenter();
    }


    @Override
    public void setViewModels(List arrViewModels) {
        binding.setRecCof(new RecyclerConfiguration(new LinearLayoutManager(getContext())
                , null, new MoviesAdapter(arrViewModels, this)
                , new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL)));
    }

    @Override
    public void openMovieScreen(int idViewModel) {
        screenManager.openMovieScreen(idViewModel);
    }

    @Override
    public <ViewModel extends MovieViewModel> void onItemClick(ViewModel viewModel) {
        presenter.onItemClick(viewModel);
    }
}
