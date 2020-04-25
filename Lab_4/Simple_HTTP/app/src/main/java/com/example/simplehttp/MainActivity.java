package com.example.simplehttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);
        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        //Setting an onclick listener to the button which reads the edittext and sends a request to the provided url
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Loading.... Please wait....");

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                String stringURL = editText.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.GET, stringURL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView.setText(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Something went wrong!");
                    }
                });
                requestQueue.add(stringRequest);
            }
        });
    }
}
