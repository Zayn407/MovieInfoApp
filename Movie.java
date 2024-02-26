package edu.uic.cs478.s2024.project2;

import java.util.List;

public class Movie {
    private String title; // Movie title
    private List<String> actors; // List of actors
    private String posterUrl; // URL for the movie poster
    private String officialWebPageUrl;
    private String wikipediaUrl;
    private String amazonPrimeUrl;
    private String youtubeUrl;

    // Constructor
    public Movie(String title, List<String> actors, String posterUrl, String officialWebPageUrl, String wikipediaUrl, String amazonPrimeUrl, String youtubeUrl) {
        this.title = title;
        this.actors = actors;
        this.posterUrl = posterUrl;
        this.officialWebPageUrl = officialWebPageUrl;
        this.wikipediaUrl = wikipediaUrl;
        this.amazonPrimeUrl = amazonPrimeUrl;
        this.youtubeUrl = youtubeUrl;
    }

    // Getter for the movie title
    public String getTitle() {
        return title;
    }

    // Getter for the list of actors
    public List<String> getActors() {
        return actors;
    }

    // Getter for the poster URL
    public String getPosterUrl() {
        return posterUrl;
    }
    public String getOfficialWebPageUrl() {
        return officialWebPageUrl;
    }

    public String getWikipediaUrl() {
        return wikipediaUrl;
    }

    public String getAmazonPrimeUrl() {
        return amazonPrimeUrl;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

}
