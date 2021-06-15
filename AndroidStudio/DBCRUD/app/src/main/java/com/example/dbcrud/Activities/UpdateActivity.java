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

public class UpdateActivity extends AppCompatActivity {
    String TAG = "UpdateActivity";

    String urlAddr = null;
    String scode, sname, sdept, sphone, macIP;
    TextView ecode;
    EditText ename, edept, ephone;
    Button updateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent();

        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/studentUpdateReturn.jsp?";
        Log.d(TAG, "onCreate: " + urlAddr);

        scode = intent.getStringExtra("code");
        sname = intent.getStringExtra("name");
        sdept = intent.getStringExtra("dept");
        sphone = intent.getStringExtra("phone");

        ecode = findViewById(R.id.update_code);
        ename = findViewById(R.id.update_name);
        edept = findViewById(R.id.update_dept);
        ephone = findViewById(R.id.update_phone);
        updateBtn = findViewById(R.id.update_btn);

        //입력시 자리수 제한
        ecode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        ename.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        edept.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        ephone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});

        //받아온 자료 입력
        ecode.setText(scode);
        ename.setText(sname);
        edept.setText(sdept);
        ephone.setText(sphone);

        updateBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            scode = ecode.getText().toString();
            sname = ename.getText().toString();
            sdept = edept.getText().toString();
            sphone = ephone.getText().toString();

            urlAddr = urlAddr + "code=" + scode + "&name=" + sname + "&dept=" + sdept + "&phone=" + sphone;
            Log.d(TAG, "onClick: " + urlAddr);

            String result = connectInsertData();
            if (result.equals("1")){
                Toast.makeText(UpdateActivity.this, scode + " 가 수정되었습니더.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(UpdateActivity.this, scode + " 가 수정에 실패했습니더.", Toast.LENGTH_SHORT).show();
            }
            finish();
        }
    };

    private String connectInsertData(){
        String result = null;
        try{
            NetworkTask networkTask = new NetworkTask(UpdateActivity.this, urlAddr, "update");
            Object object = networkTask.execute().get();
            result = (String) object;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}