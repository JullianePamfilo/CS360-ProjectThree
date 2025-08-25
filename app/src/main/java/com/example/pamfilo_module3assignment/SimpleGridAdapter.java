package com.example.pamfilo_module3assignment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SimpleGridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> items;

    // I use this constructor to pass in the list of items
    public SimpleGridAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        this.items = items;
    }

    // Returns the total number of items to display
    @Override
    public int getCount() {
        return items.size();
    }

    // Returns the item at a given position
    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    // Returns the item's ID — in this case, just its position
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Creates each grid item view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;

        // If a view can be reused, use it; otherwise create a new one
        if (convertView == null) {
            textView = new TextView(context);
            textView.setPadding(24, 24, 24, 24);
            textView.setTextSize(16);
        } else {
            textView = (TextView) convertView;
        }

        textView.setText(items.get(position));
        return textView;
    }
}
