package com.example.day5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryLec extends AppCompatActivity {

    Gallery gallery = null;
    ImageView iv = null;
    int[] data = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_lec);

        gallery  = findViewById(R.id.gallery01);
        MyGallertAdapter myGallertAdapter = new MyGallertAdapter(this);
        gallery.setAdapter(myGallertAdapter);

        setTitle("갤러리 영화 포스터");
    }


    public class MyGallertAdapter extends BaseAdapter{

        Context mContext;

        public MyGallertAdapter(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(data[position]);

            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView posterIV = findViewById(R.id.iv_gal);
                    posterIV.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    posterIV.setImageResource(data[position]);
                    return false;
                }
            });

            return imageView;
        }
    }
}