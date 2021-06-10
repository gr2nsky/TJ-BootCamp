package com.example.databasesqlite01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button select, insert, update, delete;
    TextView textView;
    MemberInfo memberInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memberInfo = new MemberInfo(MainActivity.this);

        select = findViewById(R.id.btn_select);
        insert = findViewById(R.id.btn_insert);
        update = findViewById(R.id.btn_update);
        delete = findViewById(R.id.btn_delete);
        textView = findViewById(R.id.tv_result);

        select.setOnClickListener(onClickListener);
        insert.setOnClickListener(onClickListener);
        update.setOnClickListener(onClickListener);
        delete.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        SQLiteDatabase db;

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_select:
                    try {
                        //사용하는 메서드가 다름. 주의
                        db = memberInfo.getReadableDatabase();
                        String query = "SELECT username, userid, password FROM member";
                        StringBuffer stringBuffer = new StringBuffer();
                        //두번쨰 인자로 번호메기기가 가능
                        Cursor cursor = db.rawQuery(query, null);
                        while(cursor.moveToNext()){
                            String username = cursor.getString(0);
                            String suerid = cursor.getString(1);
                            int password = cursor.getInt(2);
                            stringBuffer.append("username : " + username + ", userid : " + suerid + ", password : " + password + "\n");
                        }
                        cursor.close();
                        textView.setText(stringBuffer.toString());
                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "Select ok", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Select Error", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_insert:
                    try {
                        db = memberInfo.getWritableDatabase();
                        String query = "INSERT INTO member(username, userid, password) VALUES ('홍길동', 'hkdong', '1234')";
                        db.execSQL(query);
                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "Insert ok", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Inset Error", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_update:
                    try {
                        db = memberInfo.getWritableDatabase();
                        String query = "UPDATE member SET username = '임꺽정' WHERE userid = 'hkdong'";
                        db.execSQL(query);
                        memberInfo.close();
                        Toast.makeText(MainActivity.this, "Update ok", Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Update Error", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_delete:
                    break;
            }
        }
    };
}