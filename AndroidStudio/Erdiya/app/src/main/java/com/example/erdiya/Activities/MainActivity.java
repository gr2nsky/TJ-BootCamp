package com.example.erdiya.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.Manifest;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.erdiya.Beans.Friend;
import com.example.erdiya.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String TAG = "@@@@@@@@@@Main@@@@@@@@@@@@@";

    Fragment home;
    Fragment dial;
    Fragment group;

    ImageView goList;
    ImageView goGroup;
    ImageView goDial;

    public static ArrayList<Friend> fArr = new ArrayList<>();

    //dial : 0, list:1, group: 2
    int nowFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = new Home(MainActivity.this);
        dial = new Dial(MainActivity.this);
        group = new GroupFragment(MainActivity.this);

        goList = findViewById(R.id.btn_main_goList);
        goGroup = findViewById(R.id.btn_main_goGroup);
        goDial = findViewById(R.id.btn_main_goDial);

        goList.setOnClickListener(flagBtn);
        goGroup.setOnClickListener(flagBtn);
        goDial.setOnClickListener(flagBtn);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragment_section, dial);
        fragmentTransaction.commit();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[] {Manifest.permission.CALL_PHONE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }
    } //onCreate


    View.OnClickListener flagBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int requestFlag = 0;

            switch (v.getId()){
                case R.id.btn_main_goList:
                    requestFlag = 1;
                    break;
                case R.id.btn_main_goDial:
                    requestFlag = 0;
                    break;
                case R.id.btn_main_goGroup:
                    requestFlag = 2;
                    break;
            }
            switchFragment(requestFlag);
        }
    };

    public void switchFragment(int requestFlag){
        Log.v(TAG, "now : " + nowFragment + ", request : " + requestFlag);
        Fragment fr = null;

        if (nowFragment == requestFlag){
            return;
        }

        switch (requestFlag){
            case 0:
                fr = dial;
                break;
            case 1:
                fr = home;
                break;
            case 2:
                fr = group;
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_section, fr);
        fragmentTransaction.commit();
        nowFragment = requestFlag;
    }

    @Override
    public void onBackPressed() {
        if(nowFragment != 0){
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_section, dial);
            fragmentTransaction.commit();
            nowFragment = 0;
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("종료");
        builder.setMessage("정말 종료하시겠습니까?");
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}