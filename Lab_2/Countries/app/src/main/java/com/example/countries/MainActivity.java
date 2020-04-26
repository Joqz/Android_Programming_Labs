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

        //The 'base' linear layout
        LinearLayout verticalLayout = new LinearLayout(this);
        verticalLayout.setOrientation(LinearLayout.VERTICAL);

        //The horizontal linear layout for the buttons
        LinearLayout horizontalLayout = new LinearLayout(this);
        horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams horizontalParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        horizontalParams.gravity = Gravity.CENTER;
        horizontalLayout.setLayoutParams(horizontalParams);

        //Listview for the countries
        ListView listView = new ListView(this);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );
        listView.setAdapter(arrayAdapter);

        //The edit text box for adding and removing countries
        final EditText editText = new EditText(this);

        //Add button
        Button addButton = new Button(this);
        addButton.setText("Add");
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCountries(editText.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        //Edit button (no functionality)
        Button editButton = new Button(this);
        editButton.setText("Edit");

        //Remove button
        Button removeButton = new Button(this);
        removeButton.setText("Remove");
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeCountries(editText.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        //Adding the content into the layouts
        verticalLayout.addView(horizontalLayout);
        horizontalLayout.addView(addButton);
        horizontalLayout.addView(editButton);
        horizontalLayout.addView(removeButton);
        verticalLayout.addView(editText);
        verticalLayout.addView(listView);

        setContentView(verticalLayout);

        //Phew.
    }

    //Constructing functions to add and remove countries from the arraylist
    public void addCountries(String country) {
        countries.add(country);
    }

    public void removeCountries(String country) {
        countries.remove(country);
    }
}