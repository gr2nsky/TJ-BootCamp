package com.example.day6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Select03Dialog03 extends AppCompatActivity {

    Button call;
    int mSelect = 0;
    boolean[] mSlelectMulti = {false, false, false, false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dialog03);

        call = findViewById(R.id.select01_call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getApplicationContext())
                        .setTitle("음식을 선택하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMultiChoiceItems(R.array.foods, mSlelectMulti, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                mSlelectMulti[which] = isChecked;
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String[] foods = getResources().getStringArray(R.array.foods);
                                TextView tv = findViewById(R.id.select03_text);
                                String result = "선택한 음식 : ";
                                for(int i = 0; i < mSlelectMulti .length; i++){
                                    if (mSlelectMulti[i]){
                                        result += foods[i] + " / ";
                                    }
                                }
                                tv.setText(result);
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
            }
        });
    }
}