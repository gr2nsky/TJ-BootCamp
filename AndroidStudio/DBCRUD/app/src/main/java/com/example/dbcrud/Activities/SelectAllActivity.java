package com.example.dbcrud.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dbcrud.Bean.Student;
import com.example.dbcrud.CustomAdapter.StudentAdapter;
import com.example.dbcrud.NetworkTask.NetworkTask;
import com.example.dbcrud.R;

import java.util.ArrayList;

public class SelectAllActivity extends AppCompatActivity {

    String urlAddr = null;
    ArrayList<Student> students = null;
    StudentAdapter adapter = null;
    ListView listView = null;
    String macIP = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_all);

        Intent intent = getIntent();
        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/student_query_all.jsp";

        listView = findViewById(R.id.select_list_student);

    }

    @Override
    protected void onResume() {
        super.onResume();
        connectGetData();
    }

    private void connectGetData(){
        try{
            NetworkTask networkTask = new NetworkTask(SelectAllActivity.this, urlAddr, "select");
            Object object = networkTask.execute().get();
            students = (ArrayList<Student>) object;

            adapter = new StudentAdapter(SelectAllActivity.this, R.layout.layout_student_item, students);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(onItemClickListener);
            listView.setOnItemLongClickListener(onItemLongClickListener);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(SelectAllActivity.this, UpdateActivity.class);
            intent.putExtra("code", students.get(position).getCode());
            intent.putExtra("name", students.get(position).getName());
            intent.putExtra("dept", students.get(position).getDept());
            intent.putExtra("phone", students.get(position).getPhone());
            intent.putExtra("macIP", macIP);
            startActivity(intent);
        }
    };

    AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(SelectAllActivity.this, DeleteActivity.class);
            intent.putExtra("code", students.get(position).getCode());
            intent.putExtra("name", students.get(position).getName());
            intent.putExtra("dept", students.get(position).getDept());
            intent.putExtra("phone", students.get(position).getPhone());
            intent.putExtra("macIP", macIP);
            startActivity(intent);
            return true;
        }
    };





















}