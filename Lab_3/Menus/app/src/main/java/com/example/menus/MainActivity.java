package com.example.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Constructing the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    //Setting functions to the items that are used to change color and text in the view
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        View container = findViewById(R.id.container);
        TextView textView = findViewById(R.id.textView);

        if (item.getItemId() == R.id.red) {
            textView.setText("Red");
            container.setBackgroundColor(Color.RED);
        }

        if (item.getItemId() == R.id.green) {
            textView.setText("Green");
            container.setBackgroundColor(Color.GREEN);
        }

        if (item.getItemId() == R.id.blue) {
            textView.setText("Blue");
            container.setBackgroundColor(Color.BLUE);
        }

        if (item.getItemId() == R.id.yellow) {
            textView.setText("Yellow");
            container.setBackgroundColor(Color.YELLOW);
        }

        return true;
    }
}
