package com.example.day7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FragmentTest extends AppCompatActivity implements ToolbarFragment.ToolbarListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
    }

    @Override
    public void onBtnClick(int position, String text) {
        TextFragment textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.frg02);
        textFragment.changeTextProperties(position, text);
    }
}