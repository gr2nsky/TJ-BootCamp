package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EX02editableTest extends AppCompatActivity {

    EditText et;

    int[] btnIDs;
    Button[] btns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_x02editable_test);

        btnIDs = new int[] {R.id.insBtn, R.id.delBtn, R.id.appBtn, R.id.repBtn, R.id.clearBtn};
        btns = new Button[5];
        for(int i = 0; i < 5; i++){
            btns[i] = findViewById(btnIDs[i]);
            btns[i].setOnClickListener(onClickListener);
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Editable edit = et.getText();
            switch (v.getId()){
                case R.id.insBtn:
                    edit.insert(0, "INS");
                    break;
                case R.id.delBtn:
                    edit.delete(2, 5);
                    break;
                case R.id.appBtn:
                    edit.append("APP");
                    break;
                case R.id.repBtn:
                    edit.replace(2, 5,"REP");
                    break;
                case R.id.clearBtn:
                    edit.clear();
                    break;
            }
        }
    };
}