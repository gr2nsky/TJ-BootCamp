package com.example.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView lec1;
    TextView lec2;
    TextView lec3;
    TextView lec4;
    TextView lec5;
    TextView lec6;
    TextView lec7;


    TextView ex1;
    TextView ex2;
    TextView ex3;

    ArrayList<TextView> tvs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvs = new ArrayList<TextView>();

        lec1 = findViewById(R.id.gravityBtn);
        tvs.add(lec1);
        lec2 = findViewById(R.id.weight01Btn);
        tvs.add(lec2);
        lec3 = findViewById(R.id.imageViewBtn);
        tvs.add(lec3);
        lec4 = findViewById(R.id.buttonEditBtn);
        tvs.add(lec4);
        lec5 = findViewById(R.id.frameBtn);
        tvs.add(lec5);
        lec5 = findViewById(R.id.snackBtn);
        tvs.add(lec6);
        lec5 = findViewById(R.id.tv01Btn);
        tvs.add(lec7);


        ex1 = findViewById(R.id.Exercise01Btn);
        tvs.add(ex1);
        ex2 = findViewById(R.id.Exercise02Btn);
        tvs.add(ex2);
        ex3 = findViewById(R.id.Exercise03Btn);
        tvs.add(ex3);

        for (TextView tv : tvs){
            tv.setOnClickListener(onClickListener);
        }
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.gravityBtn:
                    intent = new Intent(getApplicationContext(), Gravity.class);
                    startActivity(intent);
                    break;
                case R.id.weight01Btn:
                    intent = new Intent(getApplicationContext(), Weight01.class);
                    startActivity(intent);
                    break;
                case R.id.imageViewBtn:
                    intent = new Intent(getApplicationContext(), ImageView.class);
                    startActivity(intent);
                    break;
                case R.id.buttonEditBtn:
                    intent = new Intent(getApplicationContext(), ButtonEdit.class);
                    startActivity(intent);
                    break;
                case R.id.frameBtn:
                    intent = new Intent(getApplicationContext(), Frame.class);
                    startActivity(intent);
                    break;
                case R.id.snackBtn:
                    intent = new Intent(getApplicationContext(), snackBarLec.class);
                    startActivity(intent);
                    break;
                    case R.id.tv01Btn:
                    intent = new Intent(getApplicationContext(), TextViewAttr01.class);
                    startActivity(intent);
                    break;

                case R.id.Exercise01Btn:
                    intent = new Intent(getApplicationContext(), ex01.class);
                    startActivity(intent);
                    break;
                case R.id.Exercise02Btn:
                    intent = new Intent(getApplicationContext(), ex02.class);
                    startActivity(intent);
                    break;
                case R.id.Exercise03Btn:
                    intent = new Intent(getApplicationContext(), ex03.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}