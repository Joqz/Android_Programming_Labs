package com.example.zoo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMammals();
    }

    //Constructing the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.mammals) {
            setMammals();
        }

        if (item.getItemId() == R.id.birds) {
            setBirds();
        }
        return true;
    }

    //Setting mammals in to the imageviews
    public void setMammals(){
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(R.drawable.bear);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(R.drawable.wolf);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(R.drawable.elephant);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(R.drawable.lamb);

        (findViewById(R.id.imageView1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bear);
                mediaPlayer.start();
            }
        });

        (findViewById(R.id.imageView2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.wolf);
                mediaPlayer.start();
            }
        });

        (findViewById(R.id.imageView3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.elephant);
                mediaPlayer.start();
            }
        });

        (findViewById(R.id.imageView4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lamb);
                mediaPlayer.start();
            }
        });
    }

    //Setting birds into the imageviews
    public void setBirds(){
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(R.drawable.huuhkaja);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(R.drawable.peippo);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(R.drawable.peukaloinen);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(R.drawable.punatulkku);

        (findViewById(R.id.imageView1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.huuhkaja_norther_eagle_owl);
                mediaPlayer.start();
            }
        });

        (findViewById(R.id.imageView2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.peippo_chaffinch);
                mediaPlayer.start();
            }
        });

        (findViewById(R.id.imageView3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.peukaloinen_wren);
                mediaPlayer.start();
            }
        });

        (findViewById(R.id.imageView4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.punatulkku_northern_bullfinch);
                mediaPlayer.start();
            }
        });
    }
}
