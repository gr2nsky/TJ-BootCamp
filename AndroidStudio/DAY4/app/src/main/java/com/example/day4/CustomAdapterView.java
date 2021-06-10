package com.example.day4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomAdapterView extends AppCompatActivity {

    private ArrayList<Weather> data = null;
    private WeatherAdapter adapter = null;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter_view);

        data = new ArrayList<Weather>();
        data.add(new Weather("월", R.drawable.w1, "맑음"));
        data.add(new Weather("월", R.drawable.w2, "맑음"));
        data.add(new Weather("월", R.drawable.w3, "맑음"));
        data.add(new Weather("월", R.drawable.w4, "맑음"));
        data.add(new Weather("월", R.drawable.w5, "맑음"));
        data.add(new Weather("월", R.drawable.w6, "맑음"));

        adapter = new WeatherAdapter(this, R.layout.custom_layout, data);

        listView = findViewById(R.id.listView01);
        listView.setAdapter(adapter);

    }
}