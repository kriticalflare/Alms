package com.solidfrost.android.alms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

        mImageUrls.add("https://i.imgur.com/WKmak6L.jpg");
        mNames.add("Cloths");

        mImageUrls.add("https://images.wallpaperscraft.com/image/lamps_books_library_73969_1920x1080.jpg");
        mNames.add("Books");

        mImageUrls.add("https://smhttp-ssl-21049.nexcesscdn.net/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/4/5/4513-2s10_viking_3_ply_mirror_finish_10_piece_cookware_set_-_2.jpg");
        mNames.add("Utensils");

        mImageUrls.add("https://lovelace-media.imgix.net/uploads/633/2e1379f0-6887-0132-b03f-0e30b68214d8.jpg");
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
