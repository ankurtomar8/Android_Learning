package com.example.planetsnameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetsArrayList;
    private static CustomAdapters adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1- AdapterView : a List View
        listView = findViewById(R.id.listview);

        //2- Data Source: ArrayList<Planet>
        planetsArrayList = new ArrayList<>();

        Planet planet1 = new Planet("Mercury","0",R.drawable.mercury);
        Planet planet2 = new Planet("Venus","0",R.drawable.venus);
        Planet planet3 = new Planet("Earth","1",R.drawable.earth);
        Planet planet4 = new Planet("Mars","2",R.drawable.mars);
        Planet planet5 = new Planet("Jupiter","79",R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn","83",R.drawable.saturn);
        Planet planet7 = new Planet("Uranus","27",R.drawable.uranus);
        Planet planet8 = new Planet("Neptune","14",R.drawable.neptune);

        planetsArrayList.add(planet1);
        planetsArrayList.add(planet2);
        planetsArrayList.add(planet3);
        planetsArrayList.add(planet4);
        planetsArrayList.add(planet5);
        planetsArrayList.add(planet6);
        planetsArrayList.add(planet7);
        planetsArrayList.add(planet8);

        // Adapter:
        adapter = new CustomAdapters(planetsArrayList,getApplicationContext());

        listView.setAdapter(adapter);

        // Handling Click Events
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Planet Name"+adapter.getItem(i).getPlanetName(),
                        Toast.LENGTH_LONG).show();

            }
        });


    }
}