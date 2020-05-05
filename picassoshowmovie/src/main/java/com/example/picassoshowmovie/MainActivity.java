package com.example.picassoshowmovie;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private RecyclerView mRecyclerView;
   private  Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

        adapter = new Adapter(this);
        mRecyclerView.setAdapter(adapter);


        List<Movie> movies = new ArrayList<>();

        for(int i = 0; i<25; i++){
            movies.add(new Movie());
        }
        adapter.setMovieList(movies);

    }


   public static class MovieViewHolder extends  RecyclerView.ViewHolder{
       public ImageView imageView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =(ImageView) itemView.findViewById(R.id.imageView);
        }


    }
}
