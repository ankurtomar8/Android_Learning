package com.example.colorsoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button blackBtn,greenBtn,purpleBtn,redBtn,yellowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blackBtn = findViewById(R.id.blackBtn);
        greenBtn = findViewById(R.id.greenBtn);
        purpleBtn = findViewById(R.id.purpleBtn);
        redBtn = findViewById(R.id.redBtn);
        yellowBtn = findViewById(R.id.yellowBtn);

        blackBtn.setOnClickListener(this); // call niche onClick method ko hui hai
        greenBtn.setOnClickListener(this); // call niche onClick method ko hui hai
        purpleBtn.setOnClickListener(this); // call niche onClick method ko hui hai
        redBtn.setOnClickListener(this); // call niche onClick method ko hui hai
        yellowBtn.setOnClickListener(this); // call niche onClick method ko hui hai


/*        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(
                        getApplicationContext(),
                        R.raw.red
                );
                mediaPlayer.start();
            }
        });*/   /* Yeah same jo niche likha hai uske kyuki bs class name in implemnent kia check line 11
                yeah isliye bhi kia kyuki woh implemenmt karne ke baad  individual calls remove ho jayengi
        */

        
    }

    @Override
    public void onClick(View view) {

        int clickedBtnId = view.getId();

        if(clickedBtnId == R.id.redBtn){
          playSounds(R.raw.red);
        } else if (clickedBtnId == R.id.blackBtn) {
            playSounds(R.raw.black);
        } else if (clickedBtnId == R.id.purpleBtn) {
            playSounds(R.raw.purple);
        } else if (clickedBtnId == R.id.greenBtn) {
            playSounds(R.raw.green);
        } else if (clickedBtnId == R.id.yellowBtn) {
            playSounds(R.raw.yellow);
        }

    }

    public void playSounds(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(
          this,id
        );
        mediaPlayer.start();
    }
}