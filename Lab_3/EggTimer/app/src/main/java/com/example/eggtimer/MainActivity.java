package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting an onclick listener to the button which reads input value and redirects to timer activity
        Button start = findViewById(R.id.button);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TimerActivity.class);
                EditText editText = findViewById(R.id.editText);
                String string = editText.getText().toString();
                if(string.equals("")){
                    Toast.makeText(getApplicationContext(), "Please input a number", Toast.LENGTH_SHORT).show();
                }
                else{
                    intent.putExtra("Timer activity", string);
                    startActivity(intent);
                }

            }
        });
    }
}
