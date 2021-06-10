package com.example.day5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EX04 extends AppCompatActivity {

    TextView tv;
    Button up;
    Button down;

    float tvSize;
    TextView textSizeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_x04);

        tv = findViewById(R.id.ex04_tv);
        up = findViewById(R.id.fontSizeUpBtn);
        down = findViewById(R.id.fontSizeDownBtn);
        textSizeTv = findViewById(R.id.textSizeTv);

        up.setOnClickListener(onClickListener);
        down.setOnClickListener(onClickListener);

        tvSize = tv.getTextSize();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.fontSizeUpBtn:
                    tvSize ++;
                    tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, tvSize);
                    break;
                case R.id.fontSizeDownBtn:
                    tvSize --;
                    tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, tvSize);
                    break;
            }
            textSizeTv.setText(Float.toString(tv.getTextSize()));
        }
    };
}