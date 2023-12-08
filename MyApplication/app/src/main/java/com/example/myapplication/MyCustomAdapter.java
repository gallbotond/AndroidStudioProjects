package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomAdapter extends BaseAdapter {
    private Context context;
    private String[] items;

    public MyCustomAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // displays the data at the specified position in the data set
        ViewHolder holder;

        if (convertView == null) {
            // inflate the layout for an item
            convertView = LayoutInflater.from(context).inflate(R.layout.my_list_item, parent, false);
//            convertView = View.inflate(context, R.layout.my_list_item, null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(items[position]);
        return convertView;
    }

    static class ViewHolder {
        // holds references to the views within an item layout
        TextView textView;
    }
}
