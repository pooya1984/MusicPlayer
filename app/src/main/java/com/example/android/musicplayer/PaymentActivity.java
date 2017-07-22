package com.example.android.musicplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;

public class PaymentActivity extends AppCompatActivity {

    String title;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peyment);

        //Get the details of the track from the previous activity
        Bundle b = getIntent().getExtras();
        if (b != null) {
            String trackGenre = b.getString("trackGenre");
            String singer = b.getString("singer");
            final String trackTitle = b.getString("trackTitle");
            final int trackPrice = b.getInt("trackPrice");
            int trackImage = b.getInt("trackImage");


            //Set the title of the track
            this.setTitle(trackTitle);


            //Display the track image
            ImageView albumImageView = (ImageView) findViewById(R.id.track_image);
            albumImageView.setImageResource(trackImage);

            //Display the track title
            TextView trackTitleTextView = (TextView) findViewById(R.id.track_title);
            trackTitleTextView.setText(trackTitle);

            //Display the track artist
            TextView artistTextView = (TextView) findViewById(R.id.track_singer);
            artistTextView.setText(singer);

            //Display the genre title
            TextView genreTitleTextView = (TextView) findViewById(R.id.genre_title);
            genreTitleTextView.setText(trackGenre);

            //Get the price textView and the buy button
            TextView trackPriceTextView = (TextView) findViewById(R.id.track_price);
            trackPriceTextView.setText(getString(R.string.total) + trackPrice);


            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, "This song is in yor basket " + name);
            intent.putExtra(Intent.EXTRA_SUBJECT, trackPrice);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/main_menu.xml file.
        // This adds menu items to the app bar.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "About" menu option
            case R.id.About_id:
                Toast.makeText(getApplicationContext(), "This app is a student project for Udacity", Toast.LENGTH_LONG).show();
                return true;
            // Respond to a click on the "Local" menu option
            case R.id.search_id:
                startActivity(new Intent(this, AllMusicActivity.class));
                return true;
            // Respond to a click on the "Genre" menu option
            case R.id.genres_id:
                startActivity(new Intent(this, Genres.class));
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}