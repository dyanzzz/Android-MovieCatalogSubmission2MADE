package com.submission.moviecatalogsubmission2made.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.submission.moviecatalogsubmission2made.Detail;
import com.submission.moviecatalogsubmission2made.R;
import com.submission.moviecatalogsubmission2made.model.Movie;

import java.util.ArrayList;

public class CardMovieAdapter extends RecyclerView.Adapter<CardMovieAdapter.ListViewHolder> {
    private ArrayList<Movie> listMovie;

    public CardMovieAdapter(ArrayList<Movie> list) {
        this.listMovie = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_movie, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Movie movie = listMovie.get(position);
        Glide.with(holder.itemView.getContext())
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(movie.getName());
        holder.tvDate.setText(movie.getDate());
        holder.tvDescription.setText(movie.getDescription());



        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite " +
                        listMovie.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Share " +
                        listMovie.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movies = new Movie();
                movies.setName(movie.getName());
                movies.setDate(movie.getDate());
                movies.setCategory(movie.getCategory());
                movies.setDescription(movie.getDescription());
                movies.setPhoto(movie.getPhoto());
                Intent moveWithObjectIntent = new Intent(holder.itemView.getContext(), Detail.class);
                moveWithObjectIntent.putExtra(Detail.EXTRA_MOVIE, movies);
                holder.itemView.getContext().startActivity(moveWithObjectIntent);
            }
        });


    }



    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDate, tvCategory, tvDescription;
        Button btnFavorite, btnShare;
        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDate = itemView.findViewById(R.id.tv_item_date);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}