package com.example.adaptersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AdapterView Class in UI android framework
        // Will display Vertical list

        // 1- AdapterView : ListView
        listView = findViewById(R.id.listview);

        // 2-Data Source : String Array
        String[] countries = {"India","Japan","USA","UK"};

        // Adapter acts as bridge between the data source and the AdapterView
        // 3- Adapter:

  /*      ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                countries
        );*/  // REMOVING THIS TO CALL MyCustomAdapter created

        MyCustomAdapter adapter = new MyCustomAdapter(this,countries); // Calling Custom Adapter to display data


        // Link ListView with the Adapter
        listView.setAdapter(adapter);

    }
}