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

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedHolder> {
    ArrayList<FeaturedHelper> featuredlocations;

    public MostViewedAdapter(ArrayList<FeaturedHelper> featuredlocations) {
        this.featuredlocations = featuredlocations;
    }

    @NonNull
    @Override
    public MostViewedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design, parent, false);
        MostViewedHolder mostViewedHolder = new MostViewedHolder(view);
        return mostViewedHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedHolder holder, int position) {
        FeaturedHelper featuredHelper = featuredlocations.get(position);
        holder.imageView.setImageResource(featuredHelper.getImages());
        holder.title.setText(featuredHelper.getTitle());
        holder.desc.setText(featuredHelper.getDescription());
    }

    @Override
    public int getItemCount() {
        return featuredlocations.size();
    }


    public static class MostViewedHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title, desc;

        public MostViewedHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.mv_image);
            title = itemView.findViewById(R.id.mv_title);
            desc = itemView.findViewById(R.id.mv_desc);
        }
    }
}
