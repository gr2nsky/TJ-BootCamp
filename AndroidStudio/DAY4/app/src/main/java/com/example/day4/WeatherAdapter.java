package com.example.day4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {

    //context = activity
    private Context mContext = null;
    private int layout = 0;
    private ArrayList<Weather> data = null;
    private LayoutInflater inflater = null;

    public WeatherAdapter(Context mContext, int layout, ArrayList<Weather> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getDay();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //리시트 아이템 하나하나가 컨버터 뷰임
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
        }
        TextView tv_day = convertView.findViewById(R.id.tv_day);
        ImageView iv_icon = convertView.findViewById(R.id.iv_weather);
        TextView tv_comment = convertView.findViewById(R.id.tv_weather);

        tv_day.setText(data.get(position).getDay() + " ");
        iv_icon.setImageResource(data.get(position).getIcon());
        tv_comment.setText(data.get(position).getComment());

        if(position % 2 == 0){
            convertView.setBackgroundColor(0x5000ff00);
        } else {

            convertView.setBackgroundColor(0x9000ff00);
        }
        return convertView;
    }
}
