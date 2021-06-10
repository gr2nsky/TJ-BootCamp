package com.example.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ex03 extends AppCompatActivity {

    EditText edit1;
    EditText edit2;
    TextView resultTv;

    int[] numBtnIDs;
    Button[] numBtns;

    Button sumBtn;
    Button subBtn;
    Button mulBtn;
    Button divBtn;
    Button initBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex03);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        resultTv = findViewById(R.id.resultTv);
        initBtn = findViewById(R.id.initBtn);

        numBtnIDs = new int[] {R.id.numBtn_0, R.id.numBtn_1, R.id.numBtn_2, R.id.numBtn_3,
                R.id.numBtn_4, R.id.numBtn_5, R.id.numBtn_6, R.id.numBtn_7, R.id.numBtn_8,
                R.id.numBtn_9};

        numBtns = new Button[10];
        for (int i = 0; i < 10; i ++){
            numBtns[i] = findViewById(numBtnIDs[i]);
        }

        for(Button btn : numBtns){
            btn.setOnClickListener(numBtnClickEvent);
        }

        sumBtn = findViewById(R.id.sumBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);
    }

    View.OnClickListener numBtnClickEvent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String result = "";
            EditText taget = null;
            Button clickedBtn = findViewById(v.getId());
            String clickedBtnValue = clickedBtn.getText().toString();

            if(edit1.isFocused()){
                taget = edit1;
            } else if(edit2.isFocused()){
                taget = edit2;
            } else {
                Toast.makeText(ex03.this, "입력할 곳을 선택해주세요", Toast.LENGTH_SHORT).show();
                return;
            }

            result = taget.getText().toString();
            taget.setText(result + clickedBtnValue);
        }
    };

    View.OnClickListener calcEvent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resultTv.setText("");
            int num1 = Integer.parseInt(edit1.getText().toString());
            int num2 = Integer.parseInt(edit2.getText().toString());

            switch (v.getId()){
                case R.id.sumBtn:
                    resultTv.setText(num1 + num2);
                    break;
                case R.id.subBtn:
                    resultTv.setText(num1 - num2);
                    break;
                case R.id.mulBtn:
                    resultTv.setText(num1 * num2);
                    break;
                case R.id.divBtn:
                    resultTv.setText(num1 / num2);
                    break;
            }

        }
    };
}