package com.submission.moviecatalogsubmission2made;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.submission.moviecatalogsubmission2made.model.Movie;

public class Detail extends AppCompatActivity {

    String name, date, category, description, photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        if (movie != null) {
            name = movie.getName();
            date = movie.getDate();
            category = movie.getCategory();
            description = movie.getDescription();
            photo = movie.getPhoto();
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(name);
        }

        TextView tvname = findViewById(R.id.item_name);
        TextView tvdate = findViewById(R.id.item_date);
        TextView tvdescription = findViewById(R.id.item_description);
        TextView tvphotoqty = findViewById(R.id.item_photo_qty);
        ImageView imgphoto = findViewById(R.id.item_photo);

        tvname.setText(name);
        tvdate.setText(date);
        tvphotoqty.setText(category);
        tvdescription.setText(description);

        Glide.with(this)
                .load(photo)
                .into(imgphoto);

    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public static final String EXTRA_MOVIE = "extra_movie";

}
