package com.example.Cinematalk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_PLAYER = "extra_player";
    TextView tvJudul, tvSynopsis;
    Button btnTrailer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvJudul = findViewById(R.id.tViewJudul);
        tvSynopsis = findViewById(R.id.tViewSynopsis);
        btnTrailer = findViewById(R.id.btnTrailer);

        MoviesItem moviesItem =  getIntent().getParcelableExtra(EXTRA_PLAYER);

        String judul = moviesItem.getJudul();
        String synopsis = moviesItem.getSynopsis();

        tvJudul.setText(judul);
        tvSynopsis.setText(synopsis);

        btnTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www/youtube.com/watch?")));
            }
        });

    }

}
