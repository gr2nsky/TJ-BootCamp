package com.example.day5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EX03 extends AppCompatActivity {

    TextView ex3_topTV;
    Button ex3_btn;
    ImageView ex3_iv;

    int tvToken = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_x03);


        ex3_topTV = findViewById(R.id.ex3_topTV);
        ex3_btn = findViewById(R.id.ex3_btn);
        ex3_iv = findViewById(R.id.ex3_iv);

        ex3_topTV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (tvToken == 0){
                    ex3_topTV.setText("그만 보기");
                    ex3_btn.setVisibility(View.VISIBLE);

                }else {
                    ex3_topTV.setText("강아지 사 보기");
                    ex3_btn.setVisibility(View.INVISIBLE);
                    ex3_iv.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });

        ex3_btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ex3_iv.setVisibility(View.VISIBLE);
                return true;
            }
        });

        ex3_iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(EX03.this, "때리진 마세용", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    } //onCreate
}