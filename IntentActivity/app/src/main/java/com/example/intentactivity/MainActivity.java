package com.example.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn); // setting from layout
        Button btn2 = findViewById(R.id.openBrowser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage(); // Called Webpage Method
            }
        });

    }

    // 1. Explicit Intent
    public  void goToSecondActivity(){
        Intent mIntent = new Intent(this,SecondActivity.class); // Instance of Intent class
        startActivity(mIntent); //Targeting second activity

    }
    // 2. Implicit Intent
    public void openWebPage(){
        Uri webpage = Uri.parse("https://google.com");

        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);

    }
}