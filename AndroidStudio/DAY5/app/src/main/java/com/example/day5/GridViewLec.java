package com.example.day5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class GridViewLec extends AppCompatActivity {

    private int[] data = {R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1,  R.drawable.w1,
            R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1,
            R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1,
            R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1,
            R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1,
            R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1, R.drawable.w1};

    private CustomAdapter adapter = null;
    private GridView gridView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_lec);

        adapter = new CustomAdapter(this, data);
        gridView = findViewById(R.id.gridView01);
        gridView.setAdapter(adapter);
    }
}