package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;

public class EditLimit extends AppCompatActivity {

    EditText unlimit;
    EditText limit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_limit);

        unlimit = findViewById(R.id.unlimit);
        limit = findViewById(R.id.limit);

        limit.setFilters(new InputFilter[]{
           new InputFilter.LengthFilter(3)
        });
    }
}