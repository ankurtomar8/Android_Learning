package com.example.blessednumberapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textView);
        editText = findViewById(R.id.edit_text);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editText.getText().toString();

                //Explicit
                Intent i = new Intent(
                       getApplicationContext(),
                       SecondActivity.class
                );
                //  Passing name to the second activity
                i.putExtra("name",userName);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId  = item.getItemId();

        if(itemId == R.id.action_home){
            Toast.makeText(this, "You Selected Home", Toast.LENGTH_LONG).show();
        }
        else if(itemId == R.id.action_search){
            Toast.makeText(this, "You Selected Search", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}