package com.example.dbcrud.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dbcrud.Bean.Student;
import com.example.dbcrud.R;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    private Context context = null;
    private int layout = 0;
    private ArrayList<Student> data = null;
    private LayoutInflater inflater = null;

    public StudentAdapter(Context context, int layout, ArrayList<Student> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    // 터치시 getItemId에서 Position 획득 ->getItem에 position을 매개변수로 id 획득
    //getView는 getCount만큼 반복실행
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getCode();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(this.layout, parent, false);
        TextView tv_code = convertView.findViewById(R.id.student_item_tv_code);
        TextView tv_name = convertView.findViewById(R.id.student_item_tv_name);
        TextView tv_dept = convertView.findViewById(R.id.student_item_tv_dept);
        TextView tv_phone = convertView.findViewById(R.id.student_item_tv_phone);

        tv_code.setText("학번 : " + data.get(position).getCode());
        tv_name.setText("이름 : " + data.get(position).getName());
        tv_dept.setText("전공 : " + data.get(position).getDept());
        tv_phone.setText("전화번호 : " + data.get(position).getPhone());

        return convertView;
    }
}
