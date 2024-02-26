package edu.uic.cs478.s2024.project2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

public class MoviePosterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_poster);

        ImageView moviePosterImageView = findViewById(R.id.moviePosterImageView);

        String posterUrl = getIntent().getStringExtra("posterUrl");
        String officialWebPageUrl = getIntent().getStringExtra("officialWebPageUrl");

        Picasso.get().load(posterUrl).into(moviePosterImageView);

        moviePosterImageView.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(officialWebPageUrl));
            startActivity(browserIntent);
        });
    }
}
