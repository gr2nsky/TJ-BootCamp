package com.example.erdiya.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.erdiya.Common.CommonInfo;
import com.example.erdiya.Common.LoginedUserInfo;
import com.example.erdiya.NetworkTasks.FriendSelector;
import com.example.erdiya.NetworkTasks.LoginTask;
import com.example.erdiya.R;

public class Login extends AppCompatActivity {

    String TAG = "@@@Login@@@";

    EditText id_et;
    EditText pw_et;
    Button btn;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_et = findViewById(R.id.login_id);
        pw_et = findViewById(R.id.login_password);
        btn = findViewById(R.id.login_btn);
        cb = findViewById(R.id.auto_login_cb);

//        SharedPreferences sharedPreferences = getSharedPreferences("autoLogin",MODE_PRIVATE);
//        int autoToken = sharedPreferences.getInt("token",0);
//        if(autoToken == 1){
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = requestDBWork();
                if (result.equals("1")){
                    Toast.makeText(Login.this, LoginedUserInfo.user.getId() + "님 환영합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
                }


            }
        });

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    SharedPreferences sharedPreferences = getSharedPreferences("autoLogin",MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putInt("token", 1);
//                    editor.commit();
//                }else {
//                    SharedPreferences sharedPreferences = getSharedPreferences("autoLogin",MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putInt("token", 0);
//                    editor.commit();
//                }
            }
        });
    }

    private String requestDBWork(){
        String result = "0";
        try{
            LoginTask loginTask = new LoginTask(Login.this, id_et.getText().toString(), pw_et.getText().toString());
            Object object = loginTask.execute().get();
            result = (String) object;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}