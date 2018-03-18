package by.begoml.baseproject.presentation.other.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import by.begoml.baseproject.R;
import by.begoml.baseproject.presentation.other.data_binding.RecyclerConfiguration;

/**
 * Created by ilinich on 18.03.2018.
 */

public class BindingAdapterUtils {
    @BindingAdapter("app:configuration")
    public static void configureRecyclerView(RecyclerView recyclerView, RecyclerConfiguration configuration) {
        if (configuration == null) {
            return;
        }
        recyclerView.setLayoutManager(configuration.getLayoutManager());
        recyclerView.setItemAnimator(configuration.getItemAnimator());
        recyclerView.setAdapter(configuration.getAdapter());
        if (configuration.getDecoration() != null) {
            recyclerView.addItemDecoration(configuration.getDecoration());
        }
    }

    @BindingAdapter("app:imageUrl")
    public static void imageUrl(ImageView imageView, String v) {
        Glide
                .with(imageView.getContext())
                .load(v)
                .into(imageView);
    }
}
