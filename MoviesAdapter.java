package edu.uic.cs478.s2024.project2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import edu.uic.cs478.s2024.project2.R;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private final List<Movie> movieList;
    private final Context context;

    public MoviesAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesAdapter.ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.actors.setText(String.join(", ", movie.getActors()));
        Glide.with(context).load(movie.getPosterUrl()).centerCrop().into(holder.poster);


        holder.itemView.setOnClickListener(view -> {
            // Open the movie's official web page
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movie.getOfficialWebPageUrl()));
            context.startActivity(intent);
        });

        holder.itemView.setOnLongClickListener(view -> {
            // Create PopupMenu
            PopupMenu popupMenu = new PopupMenu(context, holder.itemView);
            popupMenu.inflate(R.menu.movie_options_menu); // Load menu resource
            popupMenu.setOnMenuItemClickListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.action_view_poster) {
                    // Handle "View Poster" click event
                    Intent intent = new Intent(context, MoviePosterActivity.class);
                    intent.putExtra("posterUrl", movie.getPosterUrl());
                    intent.putExtra("officialWebPageUrl", movie.getOfficialWebPageUrl());
                    context.startActivity(intent);
                    return true;
                } else if (itemId == R.id.action_view_wikipedia) {
                    // Handle "View Wikipedia page" click event
                    Intent intent = new Intent(context, WikipediaActivity.class);
                    intent.putExtra("wikipediaUrl", movie.getWikipediaUrl());
                    context.startActivity(intent);
                    return true;
                } else if (itemId == R.id.action_view_streaming_services) {
                    // Handle "View streaming services list" click event
                    Intent intent = new Intent(context, StreamingServicesActivity.class);
                    intent.putExtra("amazonPrimeLink", movie.getAmazonPrimeUrl());
                    intent.putExtra("youtubeLink", movie.getYoutubeUrl());
                    context.startActivity(intent);
                    return true;
                } else {
                    return false;
                }
            });
            popupMenu.show(); // Display PopupMenu
            return true; // Long press event has been handled
        });
    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, actors;
        public ImageView poster;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movieTitle);
            actors = itemView.findViewById(R.id.movieActors);
            poster = itemView.findViewById(R.id.movieThumbnail);
        }
    }
}
