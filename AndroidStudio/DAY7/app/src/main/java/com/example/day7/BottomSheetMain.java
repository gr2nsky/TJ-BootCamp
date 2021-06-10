package com.example.day7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class BottomSheetMain extends AppCompatActivity {

    BottmSheet bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_main);

        findViewById(R.id.bot_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet = new BottmSheet();
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
    }
}