package com.example.day5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerLec extends AppCompatActivity {

    ArrayAdapter adapter;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_lec);

        adapter = ArrayAdapter.createFromResource(this, R.array.travelArea, android.R.layout.simple_spinner_dropdown_item);
        spinner = findViewById(R.id.spinner01);
        spinner.setAdapter(adapter);
    }
}