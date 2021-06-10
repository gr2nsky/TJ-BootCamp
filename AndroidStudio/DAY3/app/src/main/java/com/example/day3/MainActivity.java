package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<TextView> tvs;

    TextView lec01;
    TextView lec02;
    TextView lec03;
    TextView lec04;
    TextView lec05;
    TextView lec06;
    TextView lec07;

    TextView ex01;
    TextView ex02;
    TextView ex03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvs = new ArrayList<TextView>();
        lec01 = findViewById(R.id.lec01);
        tvs.add(lec01);
        lec02 = findViewById(R.id.lec02);
        tvs.add(lec02);
        lec03 = findViewById(R.id.lec03);
        tvs.add(lec03);
        lec04 = findViewById(R.id.lec04);
        tvs.add(lec04);
        lec05 = findViewById(R.id.lec05);
        tvs.add(lec05);
        lec06 = findViewById(R.id.lec06);
        tvs.add(lec06);
        lec07 = findViewById(R.id.lec07);
        tvs.add(lec07);

        ex01 = findViewById(R.id.ex01);
        tvs.add(ex01);
        ex02 = findViewById(R.id.ex02);
        tvs.add(ex02);
        ex03 = findViewById(R.id.ex03);
        tvs.add(ex03);

        for(TextView tv : tvs){
            tv.setOnClickListener(onClickListener);
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        Intent intent = null;

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.lec01:
                    intent = new Intent(getApplicationContext(), TextViewAttr02.class);
                    startActivity(intent);
                    break;
                case R.id.lec02:
                    intent = new Intent(getApplicationContext(), EditLimit.class);
                    startActivity(intent);
                    break;
                case R.id.lec03:
                    intent = new Intent(getApplicationContext(), CheckBoxLce.class);
                    startActivity(intent);
                    break;
                case R.id.lec04:
                    intent = new Intent(getApplicationContext(), RadioBtn.class);
                    startActivity(intent);
                    break;
                case R.id.lec05:
                    intent = new Intent(getApplicationContext(),ProgressBarLec.class);
                    startActivity(intent);
                    break;
                case R.id.lec06:
                    intent = new Intent(getApplicationContext(), ScrollViewLec.class);
                    startActivity(intent);
                    break;
                case R.id.lec07:
                    intent = new Intent(getApplicationContext(), SlidingDrawerLec.class);
                    startActivity(intent);
                    break;



                case R.id.ex01:
                    intent = new Intent(getApplicationContext(), EX02editableTest.class);
                    startActivity(intent);
                    break;
                case R.id.ex02:
                    intent = new Intent(getApplicationContext(), EX02.class);
                    startActivity(intent);
                    break;
                case R.id.ex03:
                    intent = new Intent(getApplicationContext(), EX03BMICalc.class);
                    startActivity(intent);
                    break;

            }
        }

    };

}