package com.example.erdiya.CustomAdapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.erdiya.Activities.FriendDetail;
import com.example.erdiya.Activities.Home;
import com.example.erdiya.Activities.MainActivity;
import com.example.erdiya.Beans.Friend;
import com.example.erdiya.Common.CommonInfo;
import com.example.erdiya.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FriendListAdapter extends BaseAdapter {

    String TAG = "@@FriendListAdapter@@";

    private Context con = null;
    private int layout = 0;
    private ArrayList<Friend> friends = null;
    private LayoutInflater inflater = null;
    private Home main = null;

    private ArrayList<CheckBox> cbs;
    private ArrayList<ImageView> ivs;
    private ArrayList<Integer> selectedCheckboxPosition;
    private int dellMode = 0;

    public FriendListAdapter(Home main, Context con, int layout, ArrayList<Friend> friends) {
        this.main = main;
        this.con = con;
        this.layout = layout;
        this.friends = friends;
        this.inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        cbs = new ArrayList<>();
        ivs = new ArrayList<>();
        selectedCheckboxPosition = new ArrayList<>();

        for(int i = 0; i < friends.size(); i++){
            Log.v(TAG, "friends item : " + friends.get(i).printAll());
        }
    }

    public ArrayList<Integer> getSelectedCheckboxPosition() {
        return selectedCheckboxPosition;
    }

    public int getDellMode() {
        return dellMode;
    }

    public void setDellMode(int dellMode) {
        this.dellMode = dellMode;
    }

    public ArrayList<Friend> getFriends() {
        return friends;
    }

    @Override
    public int getCount() {
        return friends.size();
    }

    @Override
    public Object getItem(int position) {
        return friends.get(position);
    }

    @Override
    public long getItemId(int position) {
        return friends.get(position).getNo();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    convertView = inflater.inflate(this.layout, parent, false);

        // <<<<<<<<<<<<<<<< 컨버터뷰 아이템 선언 >>>>>>>>>>>>>>>>>>>
        ImageView img = convertView.findViewById(R.id.layout_friend_item_img);
        TextView name = convertView.findViewById(R.id.layout_friend_item_name);
        TextView phone = convertView.findViewById(R.id.layout_friend_item_phone);
        ImageView call = convertView.findViewById(R.id.layout_friend_item_call_btn);
        CheckBox cb = convertView.findViewById(R.id.layout_friend_item_checkbox);
        cbs.add(cb);
        ivs.add(img);

        // <<<<<<<<<<<<< 아이템에 데이터 주입 >>>>>>>>>>>>>>>>>>>>>
        //img 추가 요함
        Picasso.get()
                .load(CommonInfo.hostRootAddr+friends.get(position).getImg())
                .error(R.drawable.friend_default_img)
                .into(img);
        name.setText(friends.get(position).getName());
        phone.setText(friends.get(position).getPhone());

        //<<<<<<<<<<<<<<<< 클릭 리스너 부착 >>>>>>>>>>>>>>>>>>>>>>

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + friends.get(position).getPhone()));
                try {
                    con.startActivity(callIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Friend friend = friends.get(position);
                Intent intent = new Intent(con, FriendDetail.class);
                //이후엔 no만 넘겨서 sqlite에서 불러오도록 수정
                intent.putExtra("no", friend.getNo());
                intent.putExtra("name", friend.getName());
                intent.putExtra("phone", friend.getPhone());
                intent.putExtra("email", friend.getEmail());
                intent.putExtra("relation", friend.getRelation());
                intent.putExtra("group", friend.getGroup());
                intent.putExtra("img", friend.getImg());
                intent.putExtra("accessToken", 0);

                con.startActivity(intent);
            }
        });

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                useCheckbox();
                return true;
            }
        });

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    selectedCheckboxPosition.add(position);
                } else {
                    for(int i = 0; i < selectedCheckboxPosition.size(); i++){
                        if (position == selectedCheckboxPosition.get(i)){
                            selectedCheckboxPosition.remove(i);
                        }
                    }
                }
            }
        });


        return convertView;
    }

    public void useCheckbox(){
        for(int i = 0; i < cbs.size(); i++){
            selectedCheckboxPosition.clear();
            main.main_menu.setVisibility(View.GONE);
            main.hide_linear.setVisibility(View.VISIBLE);
            ivs.get(i).setVisibility(View.INVISIBLE);
            cbs.get(i).setVisibility(View.VISIBLE);
        }
    }

    public void hideCheckbox(){
        for(int i = 0; i < cbs.size(); i++){
            selectedCheckboxPosition.clear();
            main.main_menu.setVisibility(View.VISIBLE);
            main.hide_linear.setVisibility(View.GONE);
            ivs.get(i).setVisibility(View.VISIBLE);
            cbs.get(i).setVisibility(View.INVISIBLE);
            selectInit();
        }
    }

    public void selectInit(){
        for(CheckBox cb : cbs){
            cb.setChecked(false);
        }
    }
}
