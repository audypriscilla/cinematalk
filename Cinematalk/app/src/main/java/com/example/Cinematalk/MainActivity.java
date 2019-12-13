package com.example.Cinematalk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String JSON_URL = "https://raw.githubusercontent.com/audypriscilla/cinematalkjson/master/cinematalk.json";

    ListView listView;
    private List<MoviesItem> moviesItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =  findViewById(R.id.listView);
        moviesItemList = new ArrayList<>();



       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

               MoviesItem moviesItem = moviesItemList.get(position);

               Intent i = new Intent(getApplicationContext(), DetailActivity.class);
               i.putExtra(DetailActivity.EXTRA_PLAYER, moviesItem);
               startActivity(i);


               }
               });
               loadPlayer();
    }

    private void loadPlayer() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray playerArray = obj.getJSONArray("result");

                            for (int i = 0; i < playerArray.length(); i++) {

                                JSONObject playerObject = playerArray.getJSONObject(i);


                                MoviesItem moviesItem = new MoviesItem(playerObject.getString("judul"),
                                        playerObject.getString("synopsis"),
                                        playerObject.getString("directors"),
                                        playerObject.getString("writers"),
                                        playerObject.getString("poster"));

                                moviesItemList.add(moviesItem);
                            }

                            ListViewAdapter adapter = new ListViewAdapter(moviesItemList, getApplicationContext());

                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}