package com.example.yoon;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.yoon.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    EditText edit2;
    TextView resultTv;

    ArrayList<Button> calBtns;

    Button initBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가감승제 계산기");

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        resultTv = findViewById(R.id.resultTv);

        calBtns = new ArrayList<>();
        calBtns.add(findViewById(R.id.sumBtn));
        calBtns.add(findViewById(R.id.subBtn));
        calBtns.add(findViewById(R.id.mulBtn));
        calBtns.add(findViewById(R.id.divBtn));

        for(Button btn : calBtns){
            btn.setOnClickListener(calcEvent);
        }

    }   //onCreat;;

    View.OnClickListener calcEvent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resultTv.setText("");
            int num1 = Integer.parseInt(edit1.getText().toString());
            int num2 = Integer.parseInt(edit2.getText().toString());
            int iResult = 0;
            switch (v.getId()){
                case R.id.sumBtn:
                    iResult = num1 + num2;
                    break;
                case R.id.subBtn:
                    iResult = num1 - num2;
                    break;
                case R.id.mulBtn:
                    iResult = num1 * num2;
                    break;
                case R.id.divBtn:
                    double result = (double)num1 / (double)num2;
                    resultTv.setText(Double.toString(result));
                    return;
            }
            resultTv.setText(Integer.toString(iResult));

        }
    };

}