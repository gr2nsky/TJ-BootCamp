package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EX02 extends AppCompatActivity {

    CheckBox startCB;
    LinearLayout secondLinear;
    RadioGroup rg01;
    RadioButton selectedAnimal;
    Button selectAnimalBtn;
    ImageView animalImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_x02);

        startCB = findViewById(R.id.startCB);
        secondLinear = findViewById(R.id.secondLinear);
        rg01 = findViewById(R.id.rg01);
        selectAnimalBtn = findViewById(R.id.selectAnimalBtn);
        animalImage = findViewById(R.id.animalImage);

        startCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    secondLinear.setVisibility(View.VISIBLE);
                } else {
                    secondLinear.setVisibility(View.INVISIBLE);
                }
            }
        });

        rg01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                selectedAnimal = rb;
            }
        });

        selectAnimalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (selectedAnimal.getId()) {
                    case R.id.dogRB:
                        animalImage.setImageResource(R.drawable.dog);
                        break;
                    case R.id.catRB:
                        animalImage.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rabbitRB:
                        animalImage.setImageResource(R.drawable.rabbit);
                        break;
                }
            }
        });
    }
}