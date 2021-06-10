package com.example.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class snackBarLec extends AppCompatActivity {

    Button snackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar_lec);

        snackBtn = findViewById(R.id.snackBtn);

        snackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "이게 SnackBar 입니다,", Snackbar.LENGTH_SHORT).show();
            }
        });

    }
}