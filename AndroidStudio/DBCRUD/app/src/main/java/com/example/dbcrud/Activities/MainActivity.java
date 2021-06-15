package com.example.dbcrud.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dbcrud.R;

public class MainActivity extends AppCompatActivity {

    Button insertBrn, updateBtn, deleteBtn, selectBtn;
    EditText edtIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListener();
    }

    private void addListener(){
        edtIP = findViewById(R.id.edit_ipAddr);
        insertBrn = findViewById(R.id.btn_insert);
        updateBtn = findViewById(R.id.btn_update);
        deleteBtn = findViewById(R.id.btn_delete);
        selectBtn = findViewById(R.id.btn_select);

        insertBrn.setOnClickListener(onClickListener);
        updateBtn.setOnClickListener(onClickListener);
        deleteBtn.setOnClickListener(onClickListener);
        selectBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tempIP = edtIP.getText().toString();

            Intent intent;
            switch (v.getId()){
                case R.id.btn_insert:
                    intent = new Intent(MainActivity.this, InsertActivity.class);
                    intent.putExtra("macIP", tempIP);
                    startActivity(intent);
                break;
                case R.id.btn_update:
                    Toast.makeText(MainActivity.this, "검색후 선택을 짧게 누르면 수정으로 이동합니다.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_delete:
                    Toast.makeText(MainActivity.this, "검색후 선택을 짧게 누르면 삭제 이동합니다.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_select:
                    intent = new Intent(MainActivity.this, SelectAllActivity.class);
                    intent.putExtra("macIP", tempIP);
                    startActivity(intent);
                    break;
            }
        }
    };
}