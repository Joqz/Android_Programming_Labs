package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    final String[] COUNTRIES = new String[] {
            "Afghanistan", "Albania", "Algeria", "American Samoa",
            "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda",
            "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams horizontalParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        horizontalParams.gravity = Gravity.CENTER;

        LinearLayout verticalLayout = new LinearLayout(this);
        verticalLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout horizontalLayout = new LinearLayout(this);
        horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
        horizontalLayout.setLayoutParams(horizontalParams);


        Button add_button = new Button(this);
        add_button.setText("Add");

        Button edit_Button = new Button(this);
        edit_Button.setText("Edit");

        Button remove_Button = new Button(this);
        remove_Button.setText("Remove");

        EditText editText = new EditText(this);

        ListView listView = new ListView(this);

        verticalLayout.addView(horizontalLayout);
        horizontalLayout.addView(add_button);
        horizontalLayout.addView(edit_Button);
        horizontalLayout.addView(remove_Button);
        verticalLayout.addView(editText);
        verticalLayout.addView(listView);

        setContentView(verticalLayout);

        final ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COUNTRIES);
        listView.setAdapter(arrayAdapter);

    }
}