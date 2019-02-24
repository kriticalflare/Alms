package com.solidfrost.android.alms;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";

    EditText editText;
    Button buttondonate;
    Spinner spinner;
    Context context;
    DatabaseReference databaseNgo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        context=getApplicationContext();
        FirebaseApp.initializeApp(context);
        Log.d(TAG, "onCreate: started");


        getIncomingIntent();

        databaseNgo = FirebaseDatabase.getInstance().getReference("Ngos");

        editText = (EditText) findViewById(R.id.ngo_enter);
        buttondonate = (Button) findViewById(R.id.next_button);
        spinner = (Spinner) findViewById(R.id.spinnerNGO);

        buttondonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNGO();

            }
        });

    }
    private void addNGO(){
        String name = editText.getText().toString().trim();
        String area = editText.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){

            String id = databaseNgo.push().getKey();

            Ngo ngo = new Ngo(id,name,area);

            databaseNgo.child(id).setValue(ngo);

            Toast.makeText(this, "NGO selected", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "You should enter a name", Toast.LENGTH_LONG).show();
        }

    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIncomingIntent: Found intent extras");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");

            setImage(imageUrl,imageName);
        }
    }
    private void setImage(String imageUrl, String imageName){
        Log.d(TAG, "setImage: setting the image and name to widgets.");

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }

    private int EnterDonate()
    {
        EditText x = (EditText) findViewById(R.id.amount_enter);
        int n = Integer.parseInt(x.getText().toString());
        return n;
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.image_description2);
        priceTextView.setText(message);
    
}

    public void donateOut(View view) {

        int donated=EnterDonate();
        String priceMessage="you donated:" + donated +"\n Approx market value donated:"+donated*5; // Placeholder for future implementation valuing the goods in realtime
        displayMessage(priceMessage);
    }
    }
