package com.example.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class ex02 extends AppCompatActivity {

    Button btn1;
    Button btn2;
    LinearLayout frame1;
    LinearLayout frame2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex02);

        btn1 = findViewById(R.id.linear1);
        btn2 = findViewById(R.id.linear2);

        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);

        frame1 = findViewById(R.id.frame1);
        frame2 = findViewById(R.id.frame2);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.linear1:
                    frame1.setVisibility(v.VISIBLE);
                    frame2.setVisibility(v.INVISIBLE);
                    break;
                case R.id.linear2:
                    frame2.setVisibility(v.VISIBLE);
                    frame1.setVisibility(v.INVISIBLE);
                    break;
            }
        }
    };
}