package by.begoml.baseproject.presentation.other.data_binding;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ilinich on 18.03.2018.
 */

public class RecyclerConfiguration {
    private final static long DURATION = 700;

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;
    private RecyclerView.Adapter adapter;
    private DividerItemDecoration decoration;


    public RecyclerConfiguration(
            RecyclerView.LayoutManager layoutManager, RecyclerView.ItemAnimator itemAnimator
            , RecyclerView.Adapter adapter, DividerItemDecoration decoration) {
        this.layoutManager = layoutManager;
        this.itemAnimator = itemAnimator;
        this.adapter = adapter;
        this.decoration = decoration;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public RecyclerView.ItemAnimator getItemAnimator() {
        if (itemAnimator == null) {
            itemAnimator = new DefaultItemAnimator();
            itemAnimator.setRemoveDuration(DURATION);
            itemAnimator.setAddDuration(DURATION);
            itemAnimator.setChangeDuration(DURATION);
        }
        return itemAnimator;
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public DividerItemDecoration getDecoration() {
        return decoration;
    }
}
