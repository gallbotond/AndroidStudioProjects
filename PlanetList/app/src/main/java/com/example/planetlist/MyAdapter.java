package com.example.planetlist;

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

public class MyAdapter extends ArrayAdapter<Planet> {
    private ArrayList<Planet> planetList;
    Context context;

    public MyAdapter( ArrayList<Planet> planetList, Context context) {
        super(context, R.layout.item_list_layout, planetList);
        this.planetList = planetList;
        this.context = context;
    }

    private static class MyViewHolder {
        TextView planetName;
        TextView moonCount;
        ImageView planetImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planet = getItem(position);

        MyViewHolder viewHolder;
        final View result;

        if(convertView == null) {
            viewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_layout, parent, false);
            viewHolder.planetName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.moonCount = (TextView) convertView.findViewById(R.id.tv_moons);
            viewHolder.planetImage = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.planetName.setText(planet.getPlanetName());
        viewHolder.moonCount.setText(String.valueOf(planet.getMoonCount()));
        viewHolder.planetImage.setImageResource(planet.getPlanetImage());

        return result;
    }
}
