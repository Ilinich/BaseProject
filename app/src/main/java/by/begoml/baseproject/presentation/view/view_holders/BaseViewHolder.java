package by.begoml.baseproject.presentation.view.view_holders;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import by.begoml.baseproject.BR;
import by.begoml.baseproject.presentation.intarfaces.OnItemClickListener;

/**
 * Created by ilinich on 18.03.2018.
 */

public class BaseViewHolder <I extends OnItemClickListener, VDB extends ViewDataBinding>
        extends RecyclerView.ViewHolder {

    protected VDB binding;
    protected I callback;

    public BaseViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public <T> void setVM(@NonNull T vm) {
        binding.setVariable(BR.vm, vm);
    }

    public <IView extends OnItemClickListener> void setCallbacks(@NonNull IView callbacks) {
        this.callback = (I) callbacks;
        binding.setVariable(BR.callback, callbacks);
    }
}
