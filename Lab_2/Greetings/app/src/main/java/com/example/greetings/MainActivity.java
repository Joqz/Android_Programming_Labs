package com.example.greetings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting buttons and views for later use
        final TextView textView = findViewById(R.id.textView);
        final EditText editText = findViewById(R.id.editText);

        Button english = findViewById(R.id.english);
        Button finnish = findViewById(R.id.finnish);
        Button swedish = findViewById(R.id.swedish);
        Button surprise = findViewById(R.id.surprise);

        //Setting onclick listeners to the buttons which greet the user
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Hi "+ editText.getText().toString());
            }
        });

        finnish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Moi "+ editText.getText().toString());
            }
        });

        swedish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Hej "+ editText.getText().toString());
            }
        });

        surprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("привет " + editText.getText().toString());
            }
        });
    }
}
