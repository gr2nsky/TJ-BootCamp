package com.example.networkjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "MAIN";

    Button loadBtn;
    ListView listView;

    String urlAddr = "http://192.168.2.4:8080/test/json_members.json";
    ArrayList<JsonMember> members;
    MemberAdapter adapter;


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
                            members = (ArrayList<JsonMember>) object;

                            Log.e(TAG, "adapter 생성");
                            adapter = new MemberAdapter(MainActivity.this, R.layout.layout_network_jsom_custom, members);

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