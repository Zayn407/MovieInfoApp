package edu.uic.cs478.s2024.project2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WikipediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wikipedia);

        WebView wikiWebView = findViewById(R.id.wikiWebView);

        wikiWebView.setWebViewClient(new MyWebViewClient());

        String wikipediaUrl = getIntent().getStringExtra("wikipediaUrl");

        if (wikipediaUrl != null) {
            wikiWebView.loadUrl(wikipediaUrl);
        }
    }
}
