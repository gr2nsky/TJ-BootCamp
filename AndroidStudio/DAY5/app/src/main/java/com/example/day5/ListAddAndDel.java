package com.example.day5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAddAndDel extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ListView list;

    EditText ed;
    Button addBtn;
    Button delBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_add_and_del);

        items = new ArrayList<>();
        items.add("First");
        items.add("Second");
        items.add("Third");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, items);
        list = findViewById(R.id.list_AAD);

        ed = findViewById(R.id.ed);
        addBtn = findViewById(R.id.addBtn_AAD);
        delBtn = findViewById(R.id.delBtn_AAD);

        list.setAdapter(adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String message;
                message = "Selected Item = " + items.get(position);
                Toast.makeText(ListAddAndDel.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addStr = ed.getText().toString();
                if(addStr.length() != 0){
                    items.add(addStr);
                    ed.setText("");
                    adapter.notifyDataSetChanged();
                }

            }
        });
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedItem = list.getSelectedItemPosition();
                if(selectedItem != ListView.INVALID_POSITION){
                    items.remove(selectedItem);
                    //선택 초기화
                    list.clearChoices();
                    adapter.notifyDataSetChanged();
                }
            }
        });
    } //onCreate()
}