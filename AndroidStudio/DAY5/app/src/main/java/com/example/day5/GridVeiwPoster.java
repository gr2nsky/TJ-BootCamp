package com.example.day5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridVeiwPoster extends AppCompatActivity {

    GridView posters = null;
    int[] data = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_veiw_poster);

        posters = findViewById(R.id.gridView_poster);
        PostAdapter postAdapter = new PostAdapter(this);
        posters.setAdapter(postAdapter);

    }

    public class PostAdapter extends BaseAdapter{

        Context mContext;

        public PostAdapter(Context mContext) {
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
            ImageView imageView;

            if(convertView == null){
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(200, 300));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(5, 5, 5, 5);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(data[position]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = View.inflate(GridVeiwPoster.this, R.layout.poster_dialog, null);

                    AlertDialog.Builder dlg = new AlertDialog.Builder(GridVeiwPoster.this);
                    ImageView posterIV = dialogView.findViewById(R.id.posterIV);
                    posterIV.setImageResource(data[position]);

                    dlg.setTitle(" >>> Poster <<< ");
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageView;
        }
    }

}