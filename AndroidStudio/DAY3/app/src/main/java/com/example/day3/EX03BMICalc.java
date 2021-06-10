package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EX03BMICalc extends AppCompatActivity {

    Spinner spinner_field;
    EditText height;
    EditText weight;
    Button clacBtn;

    String selectedGender;
    String[] str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_x03_b_m_i_calc);

        selectedGender = "";
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        clacBtn = findViewById(R.id.clacBtn);

        spinner_field = findViewById(R.id.combo);
        str = getResources().getStringArray(R.array.spinnerArray);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, str);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_field.setAdapter(adapter);

        spinner_field.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinner_field.getSelectedItemPosition() > 0){
                    selectedGender = spinner_field.getSelectedItem().toString();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedGender = "";
            }
        });

        clacBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedGender.equals("")){
                    Toast.makeText(getApplicationContext(), "성별은 선택해 주세요", Toast.LENGTH_SHORT).show();
                }else {
                    //BMI 계산할 것
                }
            }
        });
    } //onCreate




















}