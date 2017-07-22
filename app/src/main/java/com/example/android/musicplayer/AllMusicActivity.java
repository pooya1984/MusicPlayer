package com.example.android.musicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class AllMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_music_activity);


        //Create the list of tracks
        ArrayList<Track> tracks = new ArrayList<Track>();

        //Add the tracks to the list
        tracks.add(new Track("Work","Rihana","POP",0, R.drawable.rihana));
        tracks.add(new Track("Controlla","Drake" ,"RAP",0, R.drawable.drake));
        tracks.add(new Track("Hard Wired","Metallica","ROCK", 0, R.drawable.maxresdefault));

        //Display the list by using a TrackListAdapter
        TrackListAdapter itemsAdapter = new TrackListAdapter(this, tracks);
        ListView listView = (ListView) findViewById(R.id.list_all_music);
        listView.setAdapter(itemsAdapter);
    }
    }
