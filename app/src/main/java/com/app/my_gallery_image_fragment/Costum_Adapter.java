package com.app.my_gallery_image_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Costum_Adapter extends BaseAdapter {
    Context context;
    int[] cImg;
    String[] name;
    public Costum_Adapter(Context context, int[] cImg, String[] name) {
        this.context=context;
        this.cImg=cImg;
        this.name=name;

    }

    @Override
    public int getCount() {
        return cImg.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     View view= LayoutInflater.from(context).inflate(R.layout.catogary_item,parent,false);
        ImageView i1=view.findViewById(R.id.i1);
        TextView t1=view.findViewById(R.id.t1);
        i1.setImageResource(cImg[position]);
        t1.setText(name[position]);

        return view;
    }
}
