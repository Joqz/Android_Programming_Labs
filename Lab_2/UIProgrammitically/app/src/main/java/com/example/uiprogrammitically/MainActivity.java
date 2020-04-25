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

        final Button button = new Button(this);
        button.setText("Poke me. Times poked:" + clicks);

        //Setting onclick listener to the button which adds clicks and updates the textview
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                button.setText("Poke me. Times poked:" + clicks);
            }
        });

        setContentView(button);
    }
}