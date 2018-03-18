package by.begoml.baseproject.presentation.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import by.begoml.baseproject.R;
import by.begoml.baseproject.presentation.intarfaces.OnItemClickListener;
import by.begoml.baseproject.presentation.view.view_holders.BaseViewHolder;
import by.begoml.baseproject.presentation.view.view_models.BaseViewModel;

/**
 * Created by ilinich on 18.03.2018.
 */

public class MoviesAdapter<T extends BaseViewModel, I extends OnItemClickListener>
        extends RecyclerView.Adapter<BaseViewHolder> {

    private List<T> viewModels;
    private I callbacks;

    public MoviesAdapter(@NonNull List<T> viewModels, I callbacks) {
        this.viewModels = viewModels;
        this.callbacks = callbacks;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        T dataModel = viewModels.get(position);
        holder.setVM(dataModel);
        holder.setCallbacks(callbacks);
    }

    @Override
    public int getItemCount() {
        return viewModels.size();
    }

}