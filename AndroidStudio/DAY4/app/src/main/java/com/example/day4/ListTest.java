package com.example.day4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ListTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_test);

        //data 준비
        ArrayList<String> arGeneral = new ArrayList<>();
        arGeneral.add("김유신");
        arGeneral.add("이순신");
        arGeneral.add("강감찬");
        arGeneral.add("을지문덕");
        arGeneral.add("김유신");
        arGeneral.add("이순신");
        arGeneral.add("강감찬");
        arGeneral.add("을지문덕");
        arGeneral.add("김유신");
        arGeneral.add("이순신");
        arGeneral.add("강감찬");
        arGeneral.add("을지문덕");

        //Adapter 준비
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arGeneral);

        //Adapter와 view 연결
    }
}