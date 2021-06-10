package com.example.networkjsonex01;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private Context con = null;
    private int layout = 0;
    private ArrayList<Student> data = null;
    private LayoutInflater inflater = null;

    private int delMode = 0; //0 : off, 1: on함
    private ArrayList<CheckBox> checkBoxes;
    private ArrayList<Integer> checkedItemPositions;

    String imgRootUrl = "http://192.168.2.4:8080/test/img/";

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_code;
        public TextView tv_name;
        public TextView tv_dept;
        public TextView tv_phone;
        public CheckBox cb_checkbox;
        public WebView wv_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_code = itemView.findViewById(R.id.tv_code);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_dept = itemView.findViewById(R.id.tv_dept);
            tv_phone = itemView.findViewById(R.id.tv_phone);
            wv_img = itemView.findViewById(R.id.wv_img);
            cb_checkbox = itemView.findViewById(R.id.cb_checkbox);
            checkBoxes.add(cb_checkbox);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (delMode == 0) {
                        delMode = 1;
                        for(CheckBox cb : checkBoxes){
                            cb.setVisibility(View.VISIBLE);
                        }
                    } else {
                        delMode = 0;
                        for(CheckBox cb : checkBoxes){
                            cb.setVisibility(View.INVISIBLE);
                        }
                    }
                    return true;
                }
            });
        }
    }

    public StudentAdapter(Context con, int layout, ArrayList<Student> data) {
        this.con = con;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        checkBoxes = new ArrayList<>();
        checkedItemPositions = new ArrayList<>();
    }

    //초기값만드는친구
    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_student_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    //재사용하는친구
    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder, int position) {
        holder.tv_code.setText(data.get(position).getCode());
        holder.tv_name.setText(data.get(position).getName());
        holder.tv_dept.setText(data.get(position).getDept());
        holder.tv_phone.setText(data.get(position).getPhone());
        imgBinder(holder.wv_img, data.get(position).getImg());


        holder.cb_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkedItemPositions.add(position);
                } else {
                    for(int i = 0; i < checkedItemPositions.size(); i++){
                        if (position == checkedItemPositions.get(i)){
                            checkedItemPositions.remove(i);
                        }
                    }
                }
            }
        });

        //보일지 말지 제어: 재활용되기때문에 관리해주어야
        if(delMode == 1){
            holder.cb_checkbox.setVisibility(View.VISIBLE);
        }else {
            holder.cb_checkbox.setVisibility(View.INVISIBLE);
        }

        holder.cb_checkbox.setChecked(false);
        for(int i : checkedItemPositions){
            if (position == i){
                holder.cb_checkbox.setChecked(true);
            }
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public int getDelMode(){
        return delMode;
    }
    public void setDelMode(int delMode){
        this.delMode = delMode;
    }

    public void checkBoxesSetInVisible(){
        for(CheckBox cb: checkBoxes){
            cb.setVisibility(View.INVISIBLE);
        }
    }

    public void imgBinder(WebView webView, String img){
        String filePath = imgRootUrl + img;

        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"+
                "<html><head>"+
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"+
                "<head><body>";
        String content = "<img src =\"" + filePath + "\" style=\"width:auto; height:100%;\"";
        Log.v("[imgBinder]", "filePath : " + content);
        String bottom = "</body></html>";
        String html = header + content + bottom;

        webView.loadData(html, "text/html; charset=utf-8", "UTF-8");
    }

}
