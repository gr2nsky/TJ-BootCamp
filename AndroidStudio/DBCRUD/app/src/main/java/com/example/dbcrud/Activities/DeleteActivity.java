package com.example.dbcrud.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dbcrud.NetworkTask.NetworkTask;
import com.example.dbcrud.R;

public class DeleteActivity extends AppCompatActivity {

    String TAG = "DeleteActivity";

    String urlAddr = null;
    String scode, sname, sdept, sphone, macIP;
    TextView ecode, ename, edept, ephone;
    Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Intent intent = getIntent();

        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/studentDeleteReturn.jsp?";
        Log.d(TAG, "onCreate: " + urlAddr);

        scode = intent.getStringExtra("code");
        sname = intent.getStringExtra("name");
        sdept = intent.getStringExtra("dept");
        sphone = intent.getStringExtra("phone");

        ecode = findViewById(R.id.delete_code);
        ename = findViewById(R.id.delete_name);
        edept = findViewById(R.id.delete_dept);
        ephone = findViewById(R.id.delete_phone);
        deleteBtn = findViewById(R.id.delete_btn);

        //받아온 자료 입력
        ecode.setText(scode);
        ename.setText(sname);
        edept.setText(sdept);
        ephone.setText(sphone);

        deleteBtn.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            scode = ecode.getText().toString();
            sname = ename.getText().toString();
            sdept = edept.getText().toString();
            sphone = ephone.getText().toString();

            urlAddr = urlAddr + "code=" + scode;

            String result = connectInsertData();
            if (result.equals("1")){
                Toast.makeText(DeleteActivity.this, scode + " 가 삭제되었습니더.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(DeleteActivity.this, scode + " 가 삭제에 실패했습니더.", Toast.LENGTH_SHORT).show();
            }
            finish();
        }
    };

    private String connectInsertData(){
        String result = null;
        try{
            NetworkTask networkTask = new NetworkTask(DeleteActivity.this, urlAddr, "update");
            Object object = networkTask.execute().get();
            result = (String) object;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}