package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mapButton = findViewById(R.id.mapButton);
        Button callButton = findViewById(R.id.callButton);
        Button siteButton = findViewById(R.id.siteButton);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNumber();
            }
        });

        siteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSite();
            }
        });

    }

    public void openMap() {
        Uri location = Uri.parse("geo: 0,0?q= Kotkantie 1, 90250 Oulu, Finland");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }

    public void callNumber() {
        Uri number = Uri.parse("tel: +020 611 0200");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void openSite() {
        EditText editText = findViewById(R.id.editText);
        String site = editText.getText().toString();
        Uri webPage = Uri.parse(site);
        Intent siteIntent = new Intent(Intent.ACTION_VIEW, webPage);

        startActivity(siteIntent);
    }

}
