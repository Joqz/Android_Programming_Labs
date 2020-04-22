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

    public ArrayList<String> countries = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        Button addButton = new Button(this);
        addButton.setText("Add");
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCountries(editText.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        Button edit_Button = new Button(this);
        edit_Button.setText("Edit");

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
        horizontalLayout.addView(edit_Button);
        horizontalLayout.addView(removeButton);
        verticalLayout.addView(editText);
        verticalLayout.addView(listView);

        setContentView(verticalLayout);

    }

    public void addCountries(String country) {
        countries.add(country);
    }

    public void removeCountries(String country) {
        countries.remove(country);
    }
}