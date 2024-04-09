package com.app.my_gallery_image_fragment;

import android.os.Environment;

import java.io.File;

public class Config {

    public static File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    public static int[] image1 = {R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
            R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10};

    public static int[] image2 = {R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4, R.drawable.f5,
            R.drawable.f6, R.drawable.f7, R.drawable.f8, R.drawable.f9, R.drawable.f10};
    public static int[] C_img ={R.drawable.chocolat,R.drawable.flower};
    public static String[]name={"Chocolate","Flower"};
}
