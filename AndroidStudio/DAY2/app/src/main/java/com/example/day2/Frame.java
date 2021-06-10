package com.example.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Frame extends AppCompatActivity {

    Button button;
    View image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

    button = findViewById(R.id.button);
    image = findViewById(R.id.doggy);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(image.getVisibility() == v.INVISIBLE){
                image.setVisibility(v.VISIBLE);
            } else {
                image.setVisibility(v.INVISIBLE);
            }
        }
    });


    }
}