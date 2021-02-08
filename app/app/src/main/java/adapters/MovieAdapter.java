package adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.R;

import java.util.List;

import models.movie;

public class MovieAdapter extends RecyclerView.Adapter {

    private View movieView;

    public MovieAdapter(Context context, List<movie> movies) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class movieAdapter extends RecyclerView.Adapter<movieAdapter.ViewHolder> {

        Context context;
        List<movie> movies;

        public movieAdapter(Context context, List<movie> movies){
            this.context = context;
            this.movies = movies;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d("MovieAdapter", "onCreateViewHolder");
            LayoutInflater.from(context).inflate(R.layout.item_movies, parent, false);
            return new ViewHolder(movieView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Log.d("MovieAdapter", "onBindViewHolder" + position);
        movie movie = movies.get(position);
        holder.bind(movie);
        }

        @Override
        public int getItemCount() {
            return movies.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView tvTitle;
            TextView tvOverview;
            ImageView ivPoster;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvTitle = itemView.findViewById(R.id.tvTitle);
                tvOverview = itemView.findViewById(R.id.tvOverview);
                ivPoster = itemView.findViewById(R.id.RelativeLayout);
            }

            public void bind(movie movie) {
                tvTitle.setText(movie.getTitle());
                tvOverview.setText(movie.getOverview());
                String imageUrl;

                //for lanscape mode
                if  (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

                    imageUrl = movie.getBackdropPath();

                }else {

                    imageUrl = movie.getPosterPath();
                }
                Glide.with(context).load(imageUrl).into(ivPoster);
            }
        }
    }

}
