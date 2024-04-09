package com.app.my_gallery_image_fragment;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Image_Adepter extends BaseAdapter {
    Context context;
    int[] image;
    public Image_Adepter(Context context, int[] image) {

        this.context=context;
        this.image=image;
    }

    @Override
    public int getCount() {
        return image.length;
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
    public View getView(int position, View view, ViewGroup parent) {
        view= LayoutInflater.from(context).inflate(R.layout.all_img_item,parent,false);
        ImageView img1=view.findViewById(R.id.img1);

      img1.setImageResource(image[position]);
        return view;
    }
}
