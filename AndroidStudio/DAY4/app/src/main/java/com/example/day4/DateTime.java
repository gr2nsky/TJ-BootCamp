package com.example.day4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class DateTime extends AppCompatActivity {

    Chronometer chrono;
    Button startBtn, endBtn;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView yearTv, monthTv, dayTv, hourTv, minuteTv;

    int selectedYear, selectedMonth, selectedDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        setTitle("시간 예약");
        startBtn = findViewById(R.id.startBtn);
        endBtn = findViewById(R.id.endBtn);

        chrono = findViewById(R.id.chorometer1);

        rdoCal = findViewById(R.id.rddCal);
        rdoTime = findViewById(R.id.rdoTime);

        calView = findViewById(R.id.calendarView1);
        tPicker = findViewById(R.id.tiemPicker1);

        yearTv = findViewById(R.id.yearTv);
        monthTv = findViewById(R.id.monthTv);
        dayTv = findViewById(R.id.dayTv);
        hourTv = findViewById(R.id.hourTv);
        minuteTv = findViewById(R.id.minuteTv);

        //라디오 버튼으로 달력 또는 타임스피너 출력
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
            }
        });

        //시작버튼 터치시 크로미터 시작 및 색상변경
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        //달력 선택시 선택한 연/월/일 출력
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedYear = year;
                selectedMonth = month;
                selectedDay = dayOfMonth;
            }
        });

        //종료버튼 터치시 선택한 날짜 및 시간을 출력하고 크로미터를 멈춤
        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLACK);

                yearTv.setText(selectedYear);
                monthTv.setText(selectedMonth);
                dayTv.setText(selectedDay);

                hourTv.setText(Integer.toString(tPicker.getCurrentHour()));
                minuteTv.setText(Integer.toString(tPicker.getCurrentMinute()));
            }
        });

    }//onCreate
}