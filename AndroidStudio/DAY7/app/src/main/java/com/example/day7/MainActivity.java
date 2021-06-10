package com.example.day7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lec01;
    TextView lec02;
    TextView lec03;

    TextView ex01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lec01 = findViewById(R.id.lec01);
        lec01.setOnClickListener(onClickListener);
        lec02 = findViewById(R.id.lec02);
        lec02.setOnClickListener(onClickListener);
        lec03 = findViewById(R.id.lec03);
        lec03.setOnClickListener(onClickListener);

        ex01 = findViewById(R.id.ex01);
        ex01.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.lec01:
                    intent = new Intent(getApplicationContext(), FragmentTest.class);
                    startActivity(intent);
                case R.id.lec02:
                    intent = new Intent(getApplicationContext(), tapLefc.class);
                    startActivity(intent);
                case R.id.lec03:
                    intent = new Intent(getApplicationContext(), BottomSheetMain.class);
                    startActivity(intent);
            }
        }
    };
}