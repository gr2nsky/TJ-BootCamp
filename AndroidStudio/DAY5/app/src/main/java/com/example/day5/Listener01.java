package com.example.day5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Listener01 extends AppCompatActivity {

    ConstraintLayout cl = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener01);

        cl = findViewById(R.id.cl01);

        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Listener01.this, "OnClicked", Toast.LENGTH_SHORT).show();
            }
        });

        cl.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(Listener01.this, "OnLongClicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}