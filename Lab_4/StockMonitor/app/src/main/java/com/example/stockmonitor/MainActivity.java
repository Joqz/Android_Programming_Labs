package com.example.stockmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    //apple AAPL   google GOOGL   facebook FB   nokia NOK

    //Constructing an array with the companies stock ids
    String[] companies = {"AAPL", "GOOGL", "FB", "NOK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView company1 = findViewById(R.id.company1);
        final TextView company2 = findViewById(R.id.company2);
        final TextView company3 = findViewById(R.id.company3);
        final TextView company4 = findViewById(R.id.company4);

        //Creating a Volley requestqueue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Looping through the company stock ids and adding requests to the queue
        for (int i=0; i < companies.length; i++) {
            String stringURL = "https://financialmodelingprep.com/api/company/price/"+companies[i]+"?datatype=json";

            final int finalI = i;

            //Requesting JSON objects and setting these responses to the text views
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, stringURL,
                    null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if (companies[finalI].equals("AAPL")) {
                            company1.setText("Apple: " + response.getJSONObject(companies[finalI]).getString("price") + " USD");
                        }
                        if (companies[finalI].equals("GOOGL")) {
                            company2.setText("Google: " + response.getJSONObject(companies[finalI]).getString("price") + " USD");
                        }
                        if (companies[finalI].equals("FB")) {
                            company3.setText("Facebook: " + response.getJSONObject(companies[finalI]).getString("price") + " USD");
                        }
                        if (companies[finalI].equals("NOK")) {
                            company4.setText("Nokia: " + response.getJSONObject(companies[finalI]).getString("price") + " USD");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
            requestQueue.add(jsonObjectRequest);
        }
    }
}
