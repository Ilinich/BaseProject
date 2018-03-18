package by.begoml.baseproject.domain.mappers;

import by.begoml.baseproject.data.model.MovieEntity;
import by.begoml.baseproject.presentation.intarfaces.MoviesView;
import by.begoml.baseproject.presentation.view.view_models.BaseViewModel;
import by.begoml.baseproject.presentation.view.view_models.MovieViewModel;
import io.reactivex.functions.Function;

/**
 * Created by ilinich on 18.03.2018.
 */

public class MovieMapper {


    public static <ViewModel extends MovieViewModel> Function<MovieEntity, ViewModel>
    applyViewModel() {
        return entity -> {
            ViewModel viewModel = (ViewModel) new MovieViewModel(entity.getMovieId(), entity.getNameEng()
                    , entity.getDescription(), entity.getPremiere(), entity.getImage());
            return viewModel;
        };
    }

}
