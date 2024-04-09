package com.app.my_gallery_image_fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class View_Pager_Adepter extends FragmentPagerAdapter {
    public View_Pager_Adepter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==-0){
            return new All_Image_Fragment();
        }else {
            return new Select_Image_Fragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       if (position==0){
           return "All Images";
       }else {
           return "Selected Images";
       }
    }
}
