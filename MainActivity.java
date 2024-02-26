package edu.uic.cs478.s2024.project2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    private final List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMovieList();
        setUpRecyclerView();
    }

    private void initializeMovieList() {
        movieList.add(new Movie("Stranger Than Fiction",
                Arrays.asList("Will Ferrell","Emma Thompson","Maggie Gyllenhaal","Dustin Hoffman"),
                "https://i.ebayimg.com/images/g/VJwAAOSw3yNicWUm/s-l960.jpg",
                "https://www.sonypictures.com/movies/strangerthanfiction",
                "https://en.wikipedia.org/wiki/Stranger_than_Fiction_(2006_film)",
                "https://www.amazon.com/Stranger-Than-Fiction-Will-Ferrell/dp/B0BR1SW441/ref=sr_1_1?crid=2SORTK2CJJZ8F&dib=eyJ2IjoiMSJ9.9Az8MOqZEKJwAkbOxD1qwKv6Bx7XAhK_AeIv_5XxXxRAQ8fR-AlTZ-eXgxdf5XrvaaQZbUSRICplTFtED8IZNLi8f1PfaYua5qzK4ZxvImqFl-xo6ZGAwILnqTD_fIacxsCqFKFLbYjmqQwS_WvA_HL0X-Y_xExRMpQ-OJoYD5ugid-n__Rpz5KljlmQSMd5YuRXxds05ZzNOvJBNUgqcaP4WeMtlrDaqALxgG85F9U.9grEBp2LocSZxqMBAFArnuuIEdiQRXqjatbQ0KJVRH0&dib_tag=se&keywords=stranger+than+fiction&qid=1708878962&s=instant-video&sprefix=stranger+than+fiction%2Cinstant-video%2C98&sr=1-1",
                "https://www.youtube.com/watch?v=a4ABIWc9oyI"));
        movieList.add(new Movie("The Godfather",
                Arrays.asList("Marlon Brando", "Al Pacino","James Caan"),
                "https://i.ebayimg.com/images/g/bxwAAOSwT0tlTwI6/s-l960.jpg",
                "https://www.paramountpictures.com/movies/godfather-collection",
                "https://en.wikipedia.org/wiki/The_Godfather",
                "https://www.amazon.com/Godfather-Marlon-Brando/dp/B001GJ19F4",
                "https://www.youtube.com/watch?v=evl5ai7Mg7w"));
        movieList.add(new Movie("The Dark Knight",
                Arrays.asList("Christian Bale", "Heath Ledger"),
                "https://i.ebayimg.com/images/g/IUUAAOSwm~5gasgR/s-l960.jpg",
                "https://www.warnerbros.com/movies/dark-knight",
                "https://en.wikipedia.org/wiki/The_Dark_Knight",
                "https://www.amazon.com/Dark-Knight-Christian-Bale/dp/B0B6PKFVHR",
                "https://www.youtube.com/watch?v=EXeTwQWrcwY"

                ));
        movieList.add(new Movie("Forrest Gump",
                Arrays.asList("Tom Hanks","Robin Wright"),
                "https://i.ebayimg.com/images/g/t5sAAOSwfnlgn7n~/s-l960.jpg",
                "https://www.paramountpictures.com/movies/forrest-gump",
                "https://en.wikipedia.org/wiki/Forrest_Gump",
                "https://www.amazon.com/Forrest-Gump-Tom-Hanks/dp/B002QVZ71I",
                "https://www.youtube.com/watch?v=ya_zgmvhKuM"
                ));
        movieList.add(new Movie("Inception",
                Arrays.asList("Leonardo DiCaprio", "Ellen Page"),
                "https://i.ebayimg.com/images/g/AS8AAOSwtNBl17sW/s-l1600.jpg",
                "https://www.legendary.com/film/inception/",
                "https://en.wikipedia.org/wiki/Inception",
                "https://www.amazon.com/Inception-Leonardo-DiCaprio/dp/B0047WJ11G",
                "https://www.youtube.com/watch?v=8hP9D6kZseM"));

    }



    private void setUpRecyclerView() {
        RecyclerView moviesRecyclerView = findViewById(R.id.moviesRecyclerView);
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MoviesAdapter moviesAdapter = new MoviesAdapter(this, movieList);
        moviesRecyclerView.setAdapter(moviesAdapter);
    }
}
