package com.example.blessednumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeTxt , blessedNumberTxt;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeTxt = findViewById(R.id.textView2);
        blessedNumberTxt = findViewById(R.id.blessed_number_text);
        share_btn =  findViewById(R.id.share_btn);

        //

        Intent i = getIntent();
        String userName = i.getStringExtra("name"); /* Getting intent
         from main activity */

      // Generating function
        int random_num = generateRandomNumber();
        blessedNumberTxt.setText(""+random_num);


        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,random_num);
            }
        });

    }
    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit =1000;

        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;
    }
    public void shareData(String username, int random_num)
    {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT,username+"The number you got");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is:"+random_num);

        startActivity(Intent.createChooser(i,"Choose a Platform")); // Choose platform
    }

}