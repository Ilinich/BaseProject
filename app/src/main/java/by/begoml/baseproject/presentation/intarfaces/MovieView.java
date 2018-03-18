package by.begoml.baseproject.presentation.intarfaces;

import by.begoml.baseproject.presentation.mvp.MvpView;
import by.begoml.baseproject.presentation.view.view_models.MovieViewModel;

/**
 * Created by ilinich on 18.03.2018.
 */

public interface MovieView  {

    interface View extends MvpView.View{

        <ViewModel extends MovieViewModel> void setViewModel(ViewModel viewModel);
    }
    
    interface Presenter extends MvpView.PresenterView{
        
    }
}
