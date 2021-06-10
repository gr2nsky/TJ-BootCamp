package com.example.networkjsonex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String TAG = "MAIN";

    Button loadBtn;
    ListView listView;

    String urlAddr = "http://192.168.2.4:8080/test/students.json";
    ArrayList<Student> members;
    StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadBtn = findViewById(R.id.btn_net_json_con);
        listView = findViewById(R.id.list_net_json);

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_net_json_con:
                        Log.e(TAG, "버튼 클릭");
                        try{
                            Log.e(TAG, "networkTask선언");
                            NetworkTask networkTask = new NetworkTask(MainActivity.this, urlAddr);
                            Object object = networkTask.execute().get();
                            members = (ArrayList<Student>) object;

                            Log.e(TAG, "adapter 생성");
                            adapter = new StudentAdapter(MainActivity.this, R.layout.layout_student_list_item, members);

                            Log.e(TAG, "adapter 적용");
                            listView.setAdapter(adapter);
                            loadBtn.setText("Result");
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        break;
                }
            }
        });

    }
}