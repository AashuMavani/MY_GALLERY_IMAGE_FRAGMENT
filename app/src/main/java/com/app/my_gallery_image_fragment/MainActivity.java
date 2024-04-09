package com.app.my_gallery_image_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewpager);

        View_Pager_Adepter viewPagerAdepter=new View_Pager_Adepter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdepter);
        tablayout.setupWithViewPager(viewPager);
    }
}