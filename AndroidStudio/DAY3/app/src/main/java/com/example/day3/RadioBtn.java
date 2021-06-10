package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioBtn extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_btn);

        radioGroup = findViewById(R.id.rg_01);
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            RadioButton rb = (RadioButton)findViewById(checkedId);
            String area = rb.getText().toString();
            Toast.makeText(RadioBtn.this, area + "을/를 선택하셨습니다.", Toast.LENGTH_SHORT).show();

        }
    };
}