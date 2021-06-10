package com.example.day6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectDialog02 extends AppCompatActivity {

    Button select02_call;
    int mSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dialog02);

        select02_call = findViewById(R.id.select02_call);

        select02_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getApplicationContext())
                        .setTitle("음식을 선택하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        .setSingleChoiceItems(R.array.foods, mSelect, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mSelect = which;
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String[] foods = getResources().getStringArray(R.array.foods);
                                TextView tv = findViewById(R.id.select02_text);
                                tv.setText("선택한 음식 : " + foods[mSelect]);
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
            }
        });
    }
}