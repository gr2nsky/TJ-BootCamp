package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {

    double bmi = 0;

    TextView bmiNum;
    TextView resultTranslate;
    TextView goWeb;
    Button goMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        Intent intent = getIntent();
        bmi = intent.getDoubleExtra("BMI", 0);

        bmiNum = findViewById(R.id.bmiNum);
        resultTranslate = findViewById(R.id.resultTranslate);
        goMain = findViewById(R.id.goMain);
        goWeb = findViewById(R.id.goWeb);

        bmiNum.setText(Double.toString(bmi));

        goWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://terms.naver.com/list.naver?cid=51033&categoryId=51033"));
                startActivity(intent);
            }
        });

        goMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bmi = 30.1;
        bmiNum.setText(Double.toString(bmi));
        resultApply();
    }

    public void resultApply(){
        if (bmi <= 18.5){
            resultTranslate.setText("저체중 입니다.");
            resultTranslate.setTextColor(Color.parseColor("#1EAAAA"));
        }else if (bmi < 23){
            resultTranslate.setText("정상 입니다.");
            resultTranslate.setTextColor(Color.parseColor("#148CFF"));
        }else if (bmi < 25){
            resultTranslate.setText("과체중 입니다.");
            resultTranslate.setTextColor(Color.parseColor("#8282FF"));
        }else if (bmi < 30){
            resultTranslate.setText("비만 입니다.");
            resultTranslate.setTextColor(Color.parseColor("#8572EE"));
        } else {
            resultTranslate.setText("고도비만 입니다.");
            resultTranslate.setTextColor(Color.parseColor("#FF6A89"));
        }
    }
}