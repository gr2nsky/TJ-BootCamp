package com.example.erdiya.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.erdiya.R;

public class Dial extends Fragment {
    TextView num1;
    TextView num2;
    TextView num3;
    TextView num4;
    TextView num5;
    TextView num6;
    TextView num7;
    TextView num8;
    TextView num9;
    TextView num0;
    TextView starBtn;
    TextView shopBtn;
    ImageView callBtn;
    ImageView removeBtn;
    TextView tv;

    Context con;

    public Dial(Context con) {
        this.con = con;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View dial = inflater.inflate(R.layout.activity_dial, container, false);
        num1 = dial.findViewById(R.id.btn_dial_1);
        num2 = dial.findViewById(R.id.btn_dial_2);
        num3 = dial.findViewById(R.id.btn_dial_3);
        num4 = dial.findViewById(R.id.btn_dial_4);
        num5 = dial.findViewById(R.id.btn_dial_5);
        num6 = dial.findViewById(R.id.btn_dial_6);
        num7 = dial.findViewById(R.id.btn_dial_7);
        num8 = dial.findViewById(R.id.btn_dial_8);
        num9 = dial.findViewById(R.id.btn_dial_9);
        starBtn = dial.findViewById(R.id.btn_dial_star);
        shopBtn = dial.findViewById(R.id.btn_dial_shop);
        num0 = dial.findViewById(R.id.btn_dial_0);
        callBtn = dial.findViewById(R.id.btn_dial_call);
        removeBtn = dial.findViewById(R.id.btn_dial_remove);

        tv = dial.findViewById(R.id.tv_dial);

        num1.setOnClickListener(inputEvent);
        num2.setOnClickListener(inputEvent);
        num3.setOnClickListener(inputEvent);
        num4.setOnClickListener(inputEvent);
        num5.setOnClickListener(inputEvent);
        num6.setOnClickListener(inputEvent);
        num7.setOnClickListener(inputEvent);
        num8.setOnClickListener(inputEvent);
        num9.setOnClickListener(inputEvent);
        num0.setOnClickListener(inputEvent);

        removeBtn.setOnClickListener(phyicalEvent);
        callBtn.setOnClickListener(phyicalEvent);
        removeBtn.setOnLongClickListener(onLongClickListener);

        return dial;
    } //onCreateView

    View.OnClickListener inputEvent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView btn = (TextView) v;
            String oldStr = tv.getText().toString();
            String newStr = oldStr += btn.getText().toString();
            tv.setText(newStr);

        }
    };

    View.OnClickListener phyicalEvent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String oldStr = tv.getText().toString();
            switch (v.getId()){
                case R.id.btn_dial_remove:
                    String newStr = oldStr.substring(0, oldStr.length()-1);
                    tv.setText(newStr);
                    break;
                case R.id.btn_dial_call:
                    Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + oldStr));
                    con.startActivity(callIntent);
                    break;
            }
        }
    };

    View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            String oldStr = tv.getText().toString();
            String newStr = oldStr.substring(0, oldStr.length()-1);
            tv.setText(newStr);
            return true;
        }
    };

























}