package com.example.planetsnameapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapters extends ArrayAdapter<Planet> {

    // Using Custom Layouts --> MyCustomAdapter
    // Using Custom Objects --> extends ArrayAdapter<Planet>

    private ArrayList<Planet> planetsArrayList;
    Context context;

    public CustomAdapters(ArrayList<Planet> planetsArrayList, Context context) {
        super(context, R.layout.items_list_layout,planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;
    }
    private static class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }
    //getView(): used to create and return a view for a specific item in the list


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

       // 1- get the planet object for the current position
        Planet planets = getItem(position);

       // 2- Inflate Layout:
        MyViewHolder myViewHolder;
        final View result;

        if(convertView != null)
        {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.items_list_layout,parent,false
            );
          // Finding views
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.plane_name);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.moonCount);
            myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;

            convertView.setTag(myViewHolder);
        }else {
            // the view is recycled
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }
        // Getting Data from Model class
        myViewHolder.planetName.setText(planets.getPlanetName());
        myViewHolder.moonCount.setText(planets.getMoonCount());
        myViewHolder.planetImg.setImageResource(planets.getPlanetImage());

        return  result;
    }
}
