package com.example.erdiya.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.erdiya.Beans.Friend;
import com.example.erdiya.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroupListAdapter extends BaseAdapter {

    private Context con;
    private Map<Integer, ArrayList<Friend>> sortedFreindWithGroup;
    private int layout = 0;
    private LayoutInflater inflater = null;
    String[] nameData = {"겜친구", "가족", "중학교", "더존"};
    String[] numData = {"11", "3", "4", "9"};

    public GroupListAdapter(Context con, Map<Integer, ArrayList<Friend>> sortedFreindWithGroup, int layout) {
        this.con = con;
        this.sortedFreindWithGroup = sortedFreindWithGroup;
        this.layout = layout;
        this.inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return sortedFreindWithGroup.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(this.layout, parent, false);

        TextView name = convertView.findViewById(R.id.layout_list_group_name);
        TextView num = convertView.findViewById(R.id.layout_list_group_num);

        ArrayList<Friend> fArr = sortedFreindWithGroup.get(position);
        name.setText(nameData[position-1]);
        num.setText(numData[position-1]);

        return convertView;
    }

    private String convertGroup(int i){
        switch (i){
            case 1:
                return "친구";
            case 2:
                return "게임친구";
            case 3:
                return "가족";
            case 4:
                return "더존";
            case 5:
                return "누구더라";
            case 6:
                return "선배";
        }
        return "";
    }
}
