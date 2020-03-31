package com.example.uiprogrammitically;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int clicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Button gameButton = new Button(this);
        gameButton.setText("Poke me. Times poked:" + clicks);

        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                gameButton.setText("Poke me. Times poked:" + clicks);
            }
        });

        setContentView(gameButton);
    }
}