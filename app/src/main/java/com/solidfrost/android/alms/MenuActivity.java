package com.solidfrost.android.alms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private static final String TAG = "MenuActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.d(TAG, "started recycler view" );
        initImageBitmaps();
    }
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing Bitmaps");

        mImageUrls.add("https://i.imgur.com/omTZuh0.jpg");
        mNames.add("Clothes");

        mImageUrls.add("https://i.imgur.com/gwXyzgX.jpg");
        mNames.add("Books");

        mImageUrls.add("https://i.imgur.com/mUUfqMC.jpg");
        mNames.add("Utensils");

        mImageUrls.add("https://i.imgur.com/4ESXGRE.jpg");
        mNames.add("Toys");

        initRecyclerView();

    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
