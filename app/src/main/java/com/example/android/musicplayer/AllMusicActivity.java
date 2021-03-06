package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_music_activity);

        //Create the list of tracks
        ArrayList<Track> tracks = new ArrayList<Track>();

        //Add the tracks to the list
        tracks.add(new Track("Work", "Rihana", "POP", 10, R.drawable.rihana));
        tracks.add(new Track("Controlla", "Drake", "RAP", 10, R.drawable.drake));
        tracks.add(new Track("Hard Wired", "Metallica", "ROCK", 10, R.drawable.maxresdefault));

        //Display the list by using a TrackListAdapter
        TrackListAdapter itemsAdapter = new TrackListAdapter(this, tracks);
        ListView listView = (ListView) findViewById(R.id.list_all_music);
        listView.setAdapter(itemsAdapter);
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