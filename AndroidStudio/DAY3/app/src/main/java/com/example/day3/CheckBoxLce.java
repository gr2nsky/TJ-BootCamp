package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class CheckBoxLce extends AppCompatActivity {

    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;


    LinkedHashMap<CheckBox, String> chMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        chMaps = new LinkedHashMap<>();
        
        cb1 = (CheckBox)findViewById(R.id.cb1);
        chMaps.put(cb1, "운동 ");

        cb2 = (CheckBox)findViewById(R.id.cb2);
        chMaps.put(cb2, "요리 ");

        cb3 = (CheckBox)findViewById(R.id.cb3);
        chMaps.put(cb3, "독서 ");

        cb4 = (CheckBox)findViewById(R.id.cb4);
        chMaps.put(cb4, "여행 ");

        cb1.setOnCheckedChangeListener(onCheckedChangeListener);
        cb2.setOnCheckedChangeListener(onCheckedChangeListener);
        cb3.setOnCheckedChangeListener(onCheckedChangeListener);
        cb4.setOnCheckedChangeListener(onCheckedChangeListener);

    }

    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int hobbyCnt = 4;
            String result = "";
            for(CheckBox ch : chMaps.keySet()){
                String hobby = chMaps.get(ch);
                if (ch.isChecked()){
                    result += hobby;
                    //Toast.makeText(CheckBoxLce.this, hobby + "체크", Toast.LENGTH_SHORT).show();
                } else {
                    result.replaceAll(hobby, "");
                    hobbyCnt --;
                    //Toast.makeText(CheckBoxLce.this, hobby + "체크해제", Toast.LENGTH_SHORT).show();
                }
            }
            if(hobbyCnt == 0){
                Toast.makeText(CheckBoxLce.this, "선택한 취미가 없습니다.", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(CheckBoxLce.this, hobbyCnt + "개의 취미 " + result + "들을 선택했습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    };
}