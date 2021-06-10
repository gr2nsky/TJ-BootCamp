package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class InputInfo extends AppCompatActivity {

    LinearLayout firstCheckLayout;
    LinearLayout secondCheckLayout;
    LinearLayout heightCheckLayout;
    LinearLayout weightCheckLayout;
    LinearLayout waitLayout;

    ProgressBar progressBar;
    TextView progressTv;

    Button beforeBtn;
    Button nextBtn;

    //0 man 1 woman
    int gender = 0;
    int age = 0;
    int height = 0;
    int weight = 0;
    //0 ~ 4
    int progressNum = 0;

    ImageView manMark;
    ImageView womanMark;
    NumberPicker agePicker;
    NumberPicker heightPicker;
    NumberPicker weightPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_info);
        firstCheckLayout = findViewById(R.id.firstCheckLayout);
        secondCheckLayout = findViewById(R.id.secondCheckLayout);
        heightCheckLayout = findViewById(R.id.heightCheckLayout);
        weightCheckLayout = findViewById(R.id.weightCheckLayout);
        waitLayout = findViewById(R.id.waitLayout);

        progressBar = findViewById(R.id.progress2);
        progressTv = findViewById(R.id.progressNum);


        beforeBtn = findViewById(R.id.beforeBtn);
        nextBtn = findViewById(R.id.nextBtn);

        agePicker = findViewById(R.id.agePicker);
        setNubmerPicker(agePicker);
        heightPicker = findViewById(R.id.heightPicker);
        heightPicker.setMaxValue(200);
        heightPicker.setValue(170);
        weightPicker = findViewById(R.id.weightPicker);
        weightPicker.setMaxValue(200);
        weightPicker.setValue(60);

        manMark = findViewById(R.id.manMark);
        womanMark = findViewById(R.id.woamnMark);

        manMark.setOnClickListener(genderListener);
        womanMark.setOnClickListener(genderListener);

        nextBtn.setOnClickListener(nextListener);
        agePicker.setOnValueChangedListener(onValueChangeListener);
        heightPicker.setOnValueChangedListener(onValueChangeListener);
        weightPicker.setOnValueChangedListener(onValueChangeListener);
    }

    private void setNubmerPicker(NumberPicker nubmerPicker){
        String[] numbers = {"10세 미만", "10대", "20대", "30대", "40대", "50대", "60대", "70대", "80대", "90대"};
        nubmerPicker.setMaxValue(numbers.length-1);
        nubmerPicker.setMinValue(0);
        nubmerPicker.setWrapSelectorWheel(true);
        nubmerPicker.setDisplayedValues(numbers);
    }

    View.OnClickListener genderListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.manMark:
                    gender = 0;
                    break;
                case R.id.woamnMark:
                    gender = 1;
                    break;
            }
            nextBtn.setVisibility(View.VISIBLE);
            beforeBtn.setVisibility(View.VISIBLE);
            progressNext();
            firstCheckLayout.setVisibility(View.GONE);
            secondCheckLayout.setVisibility(View.VISIBLE);
        }
    };

    View.OnClickListener nextListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (progressNum){
                case 1:
                    if(age == 0) {
                        Toast.makeText(InputInfo.this, "나이를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    secondCheckLayout.setVisibility(View.GONE);
                    heightCheckLayout.setVisibility(View.VISIBLE);
                    progressNext();
                    break;
                case 2:
                    if(height == 0) {
                        Toast.makeText(InputInfo.this, "키를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    heightCheckLayout.setVisibility(View.GONE);
                    weightCheckLayout.setVisibility(View.VISIBLE);
                    progressNext();
                    break;
                case 3:
                    if(weight == 0) {
                        Toast.makeText(InputInfo.this, "체중을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    weightCheckLayout.setVisibility(View.GONE);
                    waitLayout.setVisibility(View.VISIBLE);
                    nextBtn.setVisibility(View.GONE);
                    beforeBtn.setVisibility(View.GONE);
                    progressNext();
                    
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(getApplicationContext(), ResultPage.class); //화면 전환
                            double bmi = weight / (height * height);
                            bmi = Math.round((bmi*10)/10.0);
                            intent.putExtra("MBI", bmi);
                            startActivity(intent);
                            finish();
                        }
                    }, 3000);
            }
        }
    };

    NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            switch (picker.getId()){
                case R.id.agePicker:
                    age = newVal;
                    break;
                case R.id.heightPicker:
                    height = newVal;
                    break;
                case R.id.weightPicker:
                    weight = newVal;
                    break;
            }
        }
    };

    public void progressNext(){
        progressNum += 1;
        progressBar.setProgress(progressNum);
        progressTv.setText(Integer.toString(progressNum));
    }
}