package com.example.networkjsonex01;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    private Context con = null;
    private int layout = 0;
    private ArrayList<Student> data = null;
    private LayoutInflater inflater = null;

    public StudentAdapter(Context con, int layout, ArrayList<Student> data) {
        this.con = con;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(this.layout, parent, false);
        TextView tv_code = convertView.findViewById(R.id.tv_code);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_dept = convertView.findViewById(R.id.tv_dept);
        TextView tv_phone = convertView.findViewById(R.id.tv_phone);

        tv_code.setText("Code : " + data.get(position).getCode());
        tv_name.setText("Name : " + data.get(position).getName());
        tv_dept.setText("Dept : " + data.get(position).getDept());
        tv_phone.setText("Phone : " + data.get(position).getPhone());

        if(position % 2 == 0){
            convertView.setBackgroundColor(Color.parseColor("#AEC848"));
        }else {
            convertView.setBackgroundColor(Color.parseColor("#DBD580"));
        }

        return convertView;
    }

}
