package com.example.picassoshowmovie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<MainActivity.MovieViewHolder>{
    private List<Movie> mMovieList;
    private LayoutInflater mInflater;
    private Context mContext;



    public Adapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public MainActivity.MovieViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i){
        View view = mInflater.inflate(R.layout.row_movie, viewGroup, false);
        MainActivity.MovieViewHolder holder = new MainActivity.MovieViewHolder(view);
        return holder;
    }
    //@Override
    public void onBindViewHolder(MainActivity.MovieViewHolder holder, int position){
        Movie movie = mMovieList.get(position);
        Picasso.with(mContext)
                .load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return (mMovieList == null) ?  0:  mMovieList.size();
    }

    public void setMovieList(List<Movie> movieList){
        this.mMovieList = new ArrayList<>();
        this.mMovieList.addAll(movieList);
        notifyDataSetChanged();
    }
}
