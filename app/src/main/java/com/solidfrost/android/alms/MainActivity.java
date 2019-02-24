package com.solidfrost.android.alms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {
        private Button button;
        private Button button2;
        private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

        button2 =(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


    }
    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
    public void openActivity4(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
