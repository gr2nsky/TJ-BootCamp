package com.example.day7;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


public class ToolbarFragment extends Fragment {

    EditText et = null;
    Button btn = null;
    SeekBar seekBar = null;
    int seekValue = 0;

    ToolbarListener activityCallback;

    //FragmentTest와 통신을 위해 사용
    public interface ToolbarListener {
        public void onBtnClick(int position, String text);
    }

    //Fragmentsms onAttach()가 제일먼저 실행
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            activityCallback = (ToolbarListener) context;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);

        et = view.findViewById(R.id.frg_toolbar_et);
        btn = view.findViewById(R.id.frg_toolbar_btn);
        seekBar = view.findViewById(R.id.tfg_toolbar_seekbar);

        btn.setOnClickListener(onClickListener);
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);

        return view;
    }

    //FragmentTest의 onButton 클릭 받아옴
    SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seekValue = progress;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            activityCallback.onBtnClick(seekValue, et.getText().toString());
        }
    };
}