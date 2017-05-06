package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
                startActivity(new Intent(this, local.class));
                return true;
            case R.id.genres_id:
                startActivity(new Intent(this, genres.class));
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);}


    public void openGenresctivity (View view){
        ImageView genres = (ImageView) findViewById(R.id.genres);
        genres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, genres.class);
                startActivity(numbersIntent);
            }

        });
    }

    public void openLocalActivity (View view){
        ImageView local = (ImageView) findViewById(R.id.local);
        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, local.class);
                startActivity(numbersIntent);
            }

        });
    }
}
