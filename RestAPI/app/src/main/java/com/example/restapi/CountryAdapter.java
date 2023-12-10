package com.example.restapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private ArrayList<CountryModel> countryModelArrayList;

    public CountryAdapter(ArrayList<CountryModel> countryModelArrayList) {
        this.countryModelArrayList = countryModelArrayList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.textView.setText(countryModelArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countryModelArrayList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

}
