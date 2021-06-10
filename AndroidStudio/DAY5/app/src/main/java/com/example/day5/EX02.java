package com.example.day5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EX02 extends AppCompatActivity {

    TextView frText;
    Button appleBtn;
    Button orangeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_x02);

        frText = findViewById(R.id.frText);
        appleBtn = findViewById(R.id.appleBtn);
        orangeBtn = findViewById(R.id.orangeBtn);


        appleBtn.setOnClickListener(onClickListener);
        orangeBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.appleBtn:
                    frText.setText(appleBtn.getText().toString());
                    frText.setTextColor(Color.parseColor("#FF0000"));
                    break;
                case R.id.orangeBtn:
                    frText.setText(orangeBtn.getText().toString());
                    frText.setTextColor(Color.parseColor("#FF8C0A"));
                    break;
            }
        }
    };
}