package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarLec extends AppCompatActivity {

    ProgressBar pb01, pb02;

    Button progressBtn, resetBtn, showBtn, hideBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_lec);

        pb01 = findViewById(R.id.proBar01);
        pb02 = findViewById(R.id.proBar02);

        progressBtn = findViewById(R.id.progressBtn);
        resetBtn = findViewById(R.id.resetBtn);
        showBtn = findViewById(R.id.showBtn);
        hideBtn = findViewById(R.id.hideBtn);

        progressBtn.setOnClickListener(onClickListener);
        resetBtn.setOnClickListener(onClickListener);
        showBtn.setOnClickListener(onClickListener);
        hideBtn.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.progressBtn:
                    pb01.incrementProgressBy(10);
                    pb01.incrementSecondaryProgressBy(10);
                    break;
                case R.id.resetBtn:
                    pb01.setProgress(0);
                    pb01.setSecondaryProgress(10);
                    break;
                case R.id.showBtn:
                    pb02.setVisibility(ProgressBar.VISIBLE);
                    break;
                case R.id.hideBtn:
                    pb02.setVisibility(ProgressBar.INVISIBLE);
                    break;
            }
        }
    };



}