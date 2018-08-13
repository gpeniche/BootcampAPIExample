package com.example.gustavo.api3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    private RequestQueue rq;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_1);
        rq = Volley.newRequestQueue(this);
        makeCall();
    }

    private void makeCall() {

        final TextView textView = findViewById(R.id.text_1);
        String url = "https://jsonplaceholder.typicode.com/posts?userId=1";

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        handleResponse(response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("TAG", error.toString());

                    }
                });
        rq.add(jsonObjectRequest);
    }

    private void handleResponse(JSONArray jsonArray) {
        textView.setText("Response: " + jsonArray.toString());
    }
}
