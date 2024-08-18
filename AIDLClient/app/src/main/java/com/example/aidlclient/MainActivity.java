package com.example.aidlclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aidlserver.IAIDLColorInterface;

import java.security.Provider;

public class MainActivity extends AppCompatActivity {
    IAIDLColorInterface iADILColorService;
    private static final String TAG="MainActivity";

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iADILColorService = IAIDLColorInterface.Stub.asInterface(iBinder);
            Log.d(TAG,"Remote config Service Connected");
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

       // iADILColorInterface.getColor();
        Intent intent = new Intent("AIDLColorService");
        intent.setPackage("com.example.aidlserver");

        bindService(intent,mConnection,BIND_AUTO_CREATE);
        Log.d(TAG,"binderService called  ");

        //Create an onclick listener to button

        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int color = iADILColorService.getColor();
                    view.setBackgroundColor(color);
                }
                catch (RemoteException e){

                }
            }
        });


    }
}