package com.example.day5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lec01;
    TextView lec02;
    TextView lec03;
    TextView lec04;
    TextView lec05;
    TextView lec06;

    TextView ex01;
    TextView ex02;
    TextView ex03;
    TextView ex04;


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
        lec05 = findViewById(R.id.lec05);
        lec05.setOnClickListener(onClickListener);
        lec06 = findViewById(R.id.lec06);
        lec06.setOnClickListener(onClickListener);

        ex01 = findViewById(R.id.ex01);
        ex01.setOnClickListener(onClickListener);
        ex02 = findViewById(R.id.ex02);
        ex02.setOnClickListener(onClickListener);
        ex03 = findViewById(R.id.ex03);
        ex03.setOnClickListener(onClickListener);
        ex04 = findViewById(R.id.ex04);
        ex04.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        Intent intent;
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.lec01:
                    intent = new Intent(getApplicationContext(), GridViewLec.class);
                    startActivity(intent);
                case R.id.lec02:
                    intent = new Intent(getApplicationContext(), GridVeiwPoster.class);
                    startActivity(intent);
                case R.id.lec03:
                    intent = new Intent(getApplicationContext(), GalleryLec.class);
                    startActivity(intent);
                case R.id.lec04:
                    intent = new Intent(getApplicationContext(), ListAddAndDel.class);
                    startActivity(intent);
                case R.id.lec05:
                    intent = new Intent(getApplicationContext(), SpinnerLec.class);
                    startActivity(intent);
                case R.id.lec06:
                    intent = new Intent(getApplicationContext(), Listener01.class);
                    startActivity(intent);

                case R.id.ex01:
                    intent = new Intent(getApplicationContext(), EX01.class);
                    startActivity(intent);
                case R.id.ex02:
                    intent = new Intent(getApplicationContext(), EX02.class);
                    startActivity(intent);
                case R.id.ex03:
                    intent = new Intent(getApplicationContext(), EX03.class);
                    startActivity(intent);
                case R.id.ex04:
                    intent = new Intent(getApplicationContext(), EX04.class);
                    startActivity(intent);
            }
        }
    };
}