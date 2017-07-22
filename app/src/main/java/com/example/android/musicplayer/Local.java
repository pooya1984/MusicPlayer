package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class Local extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        //TODO: Add ArrayList for Words
        ArrayList<String> genres = new ArrayList<String>();
        genres.add("music one");
        genres.add("music two");
        genres.add("music three");
    }

  // menu code //////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.About_id:
                Toast.makeText(getApplicationContext(),"This app is a student project for Udacity",Toast.LENGTH_LONG).show();
                return true;
            case R.id.search_id:
                startActivity(new Intent(this, Local.class));
                return true;
            case R.id.genres_id:
                startActivity(new Intent(this, Genres.class));
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);}
    //////////////////////////////////////////////////////////////////////
}
