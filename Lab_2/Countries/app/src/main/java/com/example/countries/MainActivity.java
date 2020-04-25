package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Arraylist for countries
    public ArrayList<String> countries = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Adding countries to the list
        countries.add("Afghanistan");
        countries.add("Albania");
        countries.add("Algeria");
        countries.add("American Samoa");
        countries.add("Andorra");
        countries.add("Angola");
        countries.add("Anguilla");
        countries.add("Antarctica");
        countries.add("Antigua and Barbuda");
        countries.add("Argentina");
        countries.add("Armenia");
        countries.add("Aruba");
        countries.add("Australia");
        countries.add("Austria");
        countries.add("Azerbaijan");

        //Starting to construct the view
        LinearLayout.LayoutParams horizontalParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        horizontalParams.gravity = Gravity.CENTER;

        LinearLayout verticalLayout = new LinearLayout(this);
        verticalLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout horizontalLayout = new LinearLayout(this);
        horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
        horizontalLayout.setLayoutParams(horizontalParams);

        ListView listView = new ListView(this);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );
        listView.setAdapter(arrayAdapter);

        final EditText editText = new EditText(this);

        //Damn this is pretty annoying

        Button addButton = new Button(this);
        addButton.setText("Add");
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCountries(editText.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        Button editButton = new Button(this);
        editButton.setText("Edit");

        Button removeButton = new Button(this);
        removeButton.setText("Remove");
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeCountries(editText.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        verticalLayout.addView(horizontalLayout);
        horizontalLayout.addView(addButton);
        horizontalLayout.addView(editButton);
        horizontalLayout.addView(removeButton);
        verticalLayout.addView(editText);
        verticalLayout.addView(listView);

        setContentView(verticalLayout);

        //Phew.
    }

    public void addCountries(String country) {
        countries.add(country);
    }

    public void removeCountries(String country) {
        countries.remove(country);
    }
}