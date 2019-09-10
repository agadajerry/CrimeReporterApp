package com.jerrySoft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String []items;
    private final Integer []logo;

    public CustomAdapter(Context context,String[] items, Integer[]logo) {
        super(context, R.layout.all_security_calls, items);
        this.context= context;
        this.items = items;
        this.logo = logo;

    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.all_security_calls, null,true);

        TextView title =(TextView)rowView.findViewById(R.id.imageText);
        ImageView image = (ImageView)rowView.findViewById(R.id.imageId);
        title.setText(items[position]);
        image.setImageResource(logo[position]);
        return rowView;
    }
}
