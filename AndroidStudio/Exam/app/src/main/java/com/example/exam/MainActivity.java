package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button dogBtn;
    Button catBtn;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogBtn = findViewById(R.id.dogBtn);
        catBtn = findViewById(R.id.catBtn);
        img = findViewById(R.id.img);

        dogBtn.setOnClickListener(onClickListener);
        catBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.dogBtn:
                    img.setImageResource(R.drawable.dog);
                    break;
                case R.id.catBtn:
                    img.setImageResource(R.drawable.cat);
                    break;
            }
        }
    };
}