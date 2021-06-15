package com.example.dbcrud.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dbcrud.NetworkTask.NetworkTask;
import com.example.dbcrud.R;

public class InsertActivity extends AppCompatActivity {

    String TAG = "InsertActivity";

    String urlAddr = null;
    String scode, sname, sdept, sphone, macIP;
    EditText ecode, ename, edept, ephone;
    Button insertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Intent intent = getIntent();
        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/studentInsertReturn.jsp?";
        Log.d(TAG, "onCreate: " + urlAddr);

        ecode = findViewById(R.id.insert_code);
        ename = findViewById(R.id.insert_name);
        edept = findViewById(R.id.insert_dept);
        ephone = findViewById(R.id.insert_phone);
        insertBtn = findViewById(R.id.insert_btn);

        //입력시 자리수 제한
        ecode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        ename.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        edept.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        ephone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});

        insertBtn.setOnClickListener(onClickListener);


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
                Toast.makeText(InsertActivity.this, scode + " 가 입력되었습니더.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(InsertActivity.this, scode + " 가 입력되지 못하였습니더.", Toast.LENGTH_SHORT).show();
            }
            finish();
        }
    };

    private String connectInsertData(){
        String result = null;
        try{
            NetworkTask networkTask = new NetworkTask(InsertActivity.this, urlAddr, "insert");
            Object object = networkTask.execute().get();
            result = (String) object;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}