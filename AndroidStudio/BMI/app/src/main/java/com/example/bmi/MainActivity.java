package com.example.bmi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainLayout;
    LinearLayout introLayout;

    Button goCalBtn;
    TextView goIntroBtn;

    int goIntroToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mainLayout = findViewById(R.id.mainLayout);
        introLayout = findViewById(R.id.introLayout);

        goCalBtn = findViewById(R.id.goCalBtn);
        goIntroBtn = findViewById(R.id.goIntroBtn);

        goCalBtn.setOnClickListener(onClickListener);
        goIntroBtn.setOnClickListener(onClickListener);
        goIntroToken = 0;


    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.goCalBtn:
                    Intent intent = new Intent(getApplicationContext(), InputInfo.class);
                    startActivity(intent);
                    break;
                case R.id.goIntroBtn:
                    if(goIntroToken == 0){
                        goIntroToken = 1;
                        goIntroBtn.setText("설명 닫기");
                        mainLayout.setVisibility(v.INVISIBLE);
                        introLayout.setVisibility(v.VISIBLE);
                    } else {
                        goIntroToken = 0;
                        goIntroBtn.setText("BMI란?");
                        mainLayout.setVisibility(v.VISIBLE);
                        introLayout.setVisibility(v.INVISIBLE);
                    }
                    break;
            }
        }
    };
}