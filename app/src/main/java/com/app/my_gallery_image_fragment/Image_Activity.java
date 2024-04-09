package com.app.my_gallery_image_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Image_Activity extends AppCompatActivity {
    ImageView img;
    Button shear;
    int pos;
    private File downloadedFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image2);
        img = findViewById(R.id.img);
        shear = findViewById(R.id.shear);

        pos = getIntent().getIntExtra("position", 0);

        img.setImageResource(pos);
        shear.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v)
            {
                Bitmap icon = getBitmapFromView(img);
                //Intent share = new Intent(Intent.ACTION_SEND);
                Intent share =new Intent(Intent.ACTION_SEND);
                share.setType("image/jpeg");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                String currentDateandTime = sdf.format(new Date());

                downloadedFile= new File(Config.file.getAbsolutePath() + "/IMG_"+currentDateandTime+".jpg");
                try
                {
                    downloadedFile.createNewFile();
                    FileOutputStream fo = new FileOutputStream(downloadedFile);
                    fo.write(bytes.toByteArray());
                    Toast.makeText(Image_Activity.this,"File Downloaded",Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                share.putExtra(Intent.EXTRA_STREAM, Uri.parse(downloadedFile.getAbsolutePath()));
                startActivity(Intent.createChooser(share, "Share Image"));
            }
        });

    }
    private Bitmap getBitmapFromView(ImageView img)
    {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(img.getWidth(), img.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = img.getBackground();
        if (bgDrawable != null)
        {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }
        else
        {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        img.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }
}