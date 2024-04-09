package com.app.my_gallery_image_fragment;

import static com.app.my_gallery_image_fragment.Config.image1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Selected_img_Activity extends AppCompatActivity {
    GridView gridView;
    Image_Adepter imageAdepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_img);
        gridView = findViewById(R.id.gridview);


        int poss = getIntent().getIntExtra("position", 0);

        if (poss == 0) {
            imageAdepter = new Image_Adepter(Selected_img_Activity.this,Config.image1);
        } else {
            imageAdepter = new Image_Adepter(Selected_img_Activity.this, Config.image2);
        }
        gridView.setAdapter(imageAdepter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent  intent=new Intent(Selected_img_Activity.this,Image_Activity.class);
                intent.putExtra("position",position);
                if (position==0){
                    intent.putExtra("position", Config.image1[position]);
                }else {
                    intent.putExtra("position", Config.image2[position]);
                }
                startActivity(intent);
            }
        });


    }
}