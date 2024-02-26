package edu.uic.cs478.s2024.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class StreamingServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming_services);

        String amazonLink = getIntent().getStringExtra("amazonPrimeLink");
        String youtubeLink = getIntent().getStringExtra("youtubeLink");

        Button amazonPrimeButton = findViewById(R.id.amazonPrimeButton);
        amazonPrimeButton.setOnClickListener(v -> openWebPage(amazonLink));

        Button youtubeButton = findViewById(R.id.youtubeButton);
        youtubeButton.setOnClickListener(v -> openWebPage(youtubeLink));
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
