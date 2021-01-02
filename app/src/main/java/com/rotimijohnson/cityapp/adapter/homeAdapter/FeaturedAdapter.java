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

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedHolder> {

    ArrayList<FeaturedHelper> featuredLocations;

    public FeaturedAdapter(ArrayList<FeaturedHelper> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design, parent, false);
        FeaturedHolder featuredHolder = new FeaturedHolder(view);
        return featuredHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedHolder holder, int position) {
        FeaturedHelper featuredHelper = featuredLocations.get(position);
        holder.imageView.setImageResource(featuredHelper.getImages());
        holder.title.setText(featuredHelper.getTitle());
        holder.desc.setText(featuredHelper.getDescription());
    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public static class FeaturedHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, desc;

        public FeaturedHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.featured_img);
            title = itemView.findViewById(R.id.featured_text);
            desc = itemView.findViewById(R.id.featured_desc);
        }
    }
 }
