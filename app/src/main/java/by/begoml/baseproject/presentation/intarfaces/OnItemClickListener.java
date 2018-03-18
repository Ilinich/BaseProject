package by.begoml.baseproject.presentation.intarfaces;

import by.begoml.baseproject.presentation.view.view_models.MovieViewModel;

/**
 * Created by ilinich on 18.03.2018.
 */

public interface OnItemClickListener {

    <ViewModel extends MovieViewModel> void onItemClick(ViewModel viewModel);
}
