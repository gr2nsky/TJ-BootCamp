package com.example.day4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lec01;
    TextView lec02;
    TextView lec03;
    TextView lec04;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lec01 = findViewById(R.id.lec01);
        lec01.setOnClickListener(onClickListener);
        lec02 = findViewById(R.id.lec02);
        lec02.setOnClickListener(onClickListener);
        lec03 = findViewById(R.id.lec03);
        lec03.setOnClickListener(onClickListener);
        lec04 = findViewById(R.id.lec04);
        lec04.setOnClickListener(onClickListener);


    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        Intent intent;
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.lec01:
                    intent = new Intent(getApplicationContext(), DateTime.class);
                    startActivity(intent);
                case R.id.lec02:
                    intent = new Intent(getApplicationContext(), ListTest.class);
                    startActivity(intent);
                case R.id.lec03:
                    intent = new Intent(getApplicationContext(), ListFromArray.class);
                    startActivity(intent);
                case R.id.lec04:
                    intent = new Intent(getApplicationContext(), Weather.class);
                    startActivity(intent);
            }
        }
    };
}