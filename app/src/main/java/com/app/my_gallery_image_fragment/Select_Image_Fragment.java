package com.app.my_gallery_image_fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class Select_Image_Fragment extends Fragment {
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_select__image_, container, false);

        listView=view.findViewById(R.id.listview);
        Costum_Adapter costumAdapter=new Costum_Adapter(getContext(),Config.C_img,Config.name);
        listView.setAdapter(costumAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),Selected_img_Activity.class);
                intent.putExtra("position",position);

                startActivity(intent);
            }
        });
        return view;
    }
}