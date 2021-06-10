package com.example.networkjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MemberAdapter extends BaseAdapter {

    private Context con = null;
    private int layout = 0;
    private ArrayList<JsonMember> data = null;
    private LayoutInflater inflater = null;

    public MemberAdapter(Context con, int layout, ArrayList<JsonMember> data) {
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
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_age = convertView.findViewById(R.id.tv_age);
        TextView tv_hobbies = convertView.findViewById(R.id.tv_bohhies);
        TextView tv_no = convertView.findViewById(R.id.tv_no);
        TextView tv_id = convertView.findViewById(R.id.tv_id);

        tv_name.setText("Name : " + data.get(position).getName());
        tv_age.setText("Age : " + data.get(position).getAge());
        tv_hobbies.setText("Hobby : " + data.get(position).getHobbies());
        tv_no.setText("NO : " + data.get(position).getNo());
        tv_id.setText("ID : " + data.get(position).getId());

        if(position % 2 == 0){
            convertView.setBackgroundColor(0x500000ff);
        }else {
            convertView.setBackgroundColor(0x5000ff00);
        }

        return convertView;
    }
}
