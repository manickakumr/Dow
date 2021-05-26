package com.example.demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Demo  extends AppCompatActivity implements AdapterClass.OnItemClickListener {
    static final String Image = "avatar_url";
    static final String NAME = "full_name";
    static final String DESC = "description";
    private RecyclerView List;
    private AdapterClass adapter;
    private ArrayList<ModelView> DemoModelArrayList;
    String url = "https://api.github.com/repositories";
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DemoModelArrayList = new ArrayList<>();
        List=findViewById(R.id.list);
        getData();
        buildRecyclerView();
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(Demo.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                List.setVisibility(View.VISIBLE);
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject responseObj = response.getJSONObject(i);
                        JSONObject ownerArray =  new JSONObject(responseObj.getString("owner"));

                        String Name = responseObj.getString("full_name");
                        String Desc = responseObj.getString("description");
                        String Image="";
                        Image = ownerArray.getString("avatar_url");
                        DemoModelArrayList.add(new ModelView(Name,Image, Desc));
                        buildRecyclerView();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Demo.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonArrayRequest);
    }

    private void buildRecyclerView() {

        adapter = new AdapterClass(Demo.this, DemoModelArrayList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        adapter.setOnItemClickListener(Demo.this);
        List.setHasFixedSize(true);
        List.setLayoutManager(manager);
        List.setAdapter(adapter);
    }

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

    }

    @SuppressLint("WrongViewCast")
    @Override
    public void OnItemClick(int postion) {


        Intent detailIntent = new Intent(this, Details_page.class);
        ModelView clickedItem = DemoModelArrayList.get(postion);
        detailIntent.putExtra(Image, clickedItem.getImage());
        detailIntent.putExtra(NAME, clickedItem.getName());
        detailIntent.putExtra(DESC, clickedItem.getDesc());
        startActivity(detailIntent);
    }
}