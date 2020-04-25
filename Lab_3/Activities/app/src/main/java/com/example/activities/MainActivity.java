package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting the buttons and setting on click listeners
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

    //Function to open Google Maps with Kotkantie Campus location
    public void openMap() {
        Uri location = Uri.parse("geo:0,0?q=Kotkantie+1+,+Oulu");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        startActivity(mapIntent);
    }

    //Function to open the caller with a prefilled OAMK number
    public void callNumber() {
        Uri number = Uri.parse("tel: +020 611 0200");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

        startActivity(callIntent);
    }

    //Function to web browser with input address
    public void openSite() {
        EditText editText = findViewById(R.id.editText);
        Uri webPage = Uri.parse(editText.getText().toString());
        Intent siteIntent = new Intent(Intent.ACTION_VIEW, webPage);

        startActivity(siteIntent);
    }

}
