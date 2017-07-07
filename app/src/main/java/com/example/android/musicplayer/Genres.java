package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Genres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);

        //TODO: Add ArrayList for Words
        ArrayList<String> genres = new ArrayList<String>();
        genres.add("Pop");
        genres.add("Rock");
        genres.add("Rap");
    }

    // menu code ///////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_manu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.About_id:
                Toast.makeText(getApplicationContext(),"This app is a student project for Udacity",Toast.LENGTH_LONG).show();
                return true;
            case R.id.local_id:
                startActivity(new Intent(this, Local.class));
                return true;
            case R.id.genres_id:
                startActivity(new Intent(this, Genres.class));
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);}
    ///////////////////////////////////////////////////////////////////



    public void pop (View view){
        TextView pop = (TextView) findViewById(R.id.pop);
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(Genres.this, Pop.class);
                startActivity(numbersIntent);
            }
        });
    }

    public void rock (View view){
        TextView rock = (TextView) findViewById(R.id.rock);
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(Genres.this, Rock.class);
                startActivity(numbersIntent);
            }
        });
    }

    public void rap (View view){
        TextView rap = (TextView) findViewById(R.id.rap);
        rap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(Genres.this, Rap.class);
                startActivity(numbersIntent);
            }
        });
    }
}
