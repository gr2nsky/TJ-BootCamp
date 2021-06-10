package com.example.day7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class TextFragment extends Fragment {
    TextView tv;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        tv = view.findViewById(R.id.frg_txt_tv01);

        return view;
    }

    public void changeTextProperties(int fontSize, String str){
        tv.setTextSize(fontSize);
        tv.setText(str);
    }
}