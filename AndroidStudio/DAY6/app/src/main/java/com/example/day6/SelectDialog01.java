package com.example.day6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectDialog01 extends AppCompatActivity {

    Button select01_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dialog01);

        select01_call = findViewById(R.id.select01_call);

        select01_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getApplicationContext())
                        .setTitle("음식을 선택하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        .setItems(R.array.foods,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String[] foods = getResources().getStringArray(R.array.foods);
                                        TextView textView = findViewById(R.id.select01_text);
                                        textView.setText("선택한 음식 : " + foods[which]);
                                    }
                                }
                        )
                        .show();
            }
        });
    }
}