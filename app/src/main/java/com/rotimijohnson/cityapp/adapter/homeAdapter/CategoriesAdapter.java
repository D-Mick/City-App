package com.rotimijohnson.cityapp.adapter.homeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rotimijohnson.cityapp.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder> {
    ArrayList<FeaturedCategoriesHelper> featuredCategoriesHelpers;

    public CategoriesAdapter(ArrayList<FeaturedCategoriesHelper> featuredCategoriesHelpers) {
        this.featuredCategoriesHelpers = featuredCategoriesHelpers;
    }

    @NonNull
    @Override
    public CategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        CategoriesHolder categoriesHolder = new CategoriesHolder(view);
        return categoriesHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesHolder holder, int position) {
        FeaturedCategoriesHelper featuredHelper = featuredCategoriesHelpers.get(position);
        holder.image.setImageResource(featuredHelper.getImage());
        holder.title.setText(featuredHelper.getTitle());
    }

    @Override
    public int getItemCount() {
        return featuredCategoriesHelpers.size();
    }

    public class CategoriesHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public CategoriesHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.categories_title);
            image = itemView.findViewById(R.id.categories_image);
        }
    }
}
