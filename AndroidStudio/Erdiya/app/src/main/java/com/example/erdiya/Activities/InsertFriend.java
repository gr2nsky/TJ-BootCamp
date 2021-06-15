package com.example.erdiya.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.erdiya.Common.CommonInfo;
import com.example.erdiya.Common.LoginedUserInfo;
import com.example.erdiya.NetworkTasks.FriendSelector;
import com.example.erdiya.R;

public class InsertFriend extends AppCompatActivity {

    String TAG = "@@@@InsertFriend@@@@";

    String jspName = CommonInfo.hostRootAddr + "friendInsert.jsp?requester="+ LoginedUserInfo.user.getId();
    String data = "";

    EditText name_et;
    EditText phone_et;
    EditText email_et;
    EditText relation_et;
    EditText group_et;
    Button ok;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_friend);

        name_et = findViewById(R.id.insert_friend_name);
        phone_et = findViewById(R.id.insert_friend_phone);
        email_et = findViewById(R.id.insert_friend_email);
        relation_et = findViewById(R.id.insert_friend_relation);
        group_et = findViewById(R.id.insert_friend_group);

        ok = findViewById(R.id.insert_friend_ok_btn);
        cancel = findViewById(R.id.insert_friend_cancel_btn);

        ok.setOnClickListener(onClickListener);
        cancel.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.insert_friend_ok_btn:
                    String name = "&name=" + name_et.getText().toString();
                    String phone = "&phone=" + phone_et.getText().toString();
                    String email = "";
                    String relation = "";
                    String group = "";
                    if(email_et.getText().toString() != null && !email_et.getText().toString().equals("")){
                        email = "&email=" + email_et.getText().toString();
                    }
                    if(relation_et.getText().toString() != null && !relation_et.getText().toString().equals("")){
                        relation = "&relation=" + relation_et.getText().toString();
                    }
                    if(group_et.getText().toString() != null && !group_et.getText().toString().equals("")){
                        group = "&groupz=" + group_et.getText().toString();
                    }

                    //String email
                    data = name + phone + email + relation + group;
                    Log.v(TAG, "insertData : " + data);
                    insertFriend();
                    break;
                case R.id.insert_friend_cancel_btn:
                    finish();
                    break;
            }
        }
    };

    private void insertFriend(){
        String result = connectInsertData();
        if (result.equals("1")){
            Toast.makeText(InsertFriend.this, "주소가 성공적으로 추가되었습니다.", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(InsertFriend.this, "주소 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    private String connectInsertData(){
        String result = null;
        try{
            FriendSelector networkTask = new FriendSelector(InsertFriend.this, jspName + data, "insert");
            Object object = networkTask.execute().get();
            result = (String) object;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}