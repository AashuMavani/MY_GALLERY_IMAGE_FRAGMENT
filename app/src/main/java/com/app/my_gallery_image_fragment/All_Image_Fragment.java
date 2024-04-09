package com.app.my_gallery_image_fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


public class All_Image_Fragment extends Fragment {


    GridView gridview;
    Image_Adepter imageAdepter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all__image_, container, false);
        gridview = view.findViewById(R.id.gridview);

        imageAdepter = new Image_Adepter(getContext(), Config.image1);

        gridview.setAdapter(imageAdepter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Image_Activity.class);
                intent.putExtra("position",position);
                intent.putExtra("position", Config.image1[position]);
                startActivity(intent);
            }
        });


//     recyclerView.setOnClickListener(new View.OnClickListener() {
//         @Override
//         public void onClick(View v) {
//             Intent intent=new Intent(getActivity(),Image_Activity.class);
//             intent.putExtra("key", image);
//             startActivity(intent);
//         }
//     });

        return view;
    }
}