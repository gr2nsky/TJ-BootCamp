package com.example.erdiya.Activities;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.erdiya.Beans.Friend;
import com.example.erdiya.Common.CommonInfo;
import com.example.erdiya.Common.LoginedUserInfo;
import com.example.erdiya.CustomAdapter.FriendListAdapter;
import com.example.erdiya.NetworkTasks.FriendSelector;
import com.example.erdiya.NetworkTasks.PostTasks;
import com.example.erdiya.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Home extends Fragment {

    String TAG = "@@@HOME@@@";
    Context con = null;

    String jspName = "friendSelector.jsp?requester=" + LoginedUserInfo.user.getId();

    public ListView friendsListView;

    ArrayList<Friend> friends;
    FriendListAdapter friendListAdapter;
    public LinearLayout hide_linear;
    ImageView cancel_btn;
    ImageView ok_btn;
    public LinearLayout main_menu;
    ImageView myinfo_btn;
    ImageView insertFriends_btn;
    EditText search_et;

    public Home(Context con){
        this.con = con;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View home = inflater.inflate(R.layout.fragment_home, container, false);

        main_menu = home.findViewById(R.id.main_menu);
        friendsListView = home.findViewById(R.id.main_friends_list_view);
        hide_linear = home.findViewById(R.id.main_friends_btn_linear);
        cancel_btn = home.findViewById(R.id.main_friends_list_cancel_btn);
        ok_btn = home.findViewById(R.id.main_friends_list_ok_btn);
        myinfo_btn = home.findViewById(R.id.main_friends_myinfo_btn);
        insertFriends_btn = home.findViewById(R.id.main_friends_add_btn);
        search_et = home.findViewById(R.id.main_friends_search_et);

        cancel_btn.setOnClickListener(onClickListener);
        ok_btn.setOnClickListener(onClickListener);
        insertFriends_btn.setOnClickListener(onClickListener);
        myinfo_btn.setOnClickListener(onClickListener);

        connectGetData();
        friendListAdapter.hideCheckbox();

        Log.v(TAG, jspName);
        return home;
    }

    @Override
    public void onResume() {
        super.onResume();
        connectGetData();
        friendListAdapter.hideCheckbox();
    }

    private void connectGetData(){
        try{
            FriendSelector networkTask = new FriendSelector(con, CommonInfo.hostRootAddr+jspName, "select");
            Log.v(TAG, "Connect Addr : " + CommonInfo.hostRootAddr+jspName);
            Object object = networkTask.execute().get();
            friends = (ArrayList<Friend>) object;
            MainActivity.fArr = friends;
            friendListAdapter = new FriendListAdapter(this, con, R.layout.layout_friend_list_item, friends);
            friendsListView.setAdapter(friendListAdapter);

            //friendsListView.setOnItemLongClickListener(onItemLongClickListener);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.main_friends_myinfo_btn:
                    Intent intent = new Intent(con, FriendDetail.class);
                    //이후엔 진짜로 되도록 수정해
                    LoginedUserInfo li = new LoginedUserInfo();
                    intent.putExtra("no", li.user.getNo());
                    intent.putExtra("id", li.user.getId());
                    intent.putExtra("name", li.user.getName());
                    intent.putExtra("phone", li.user.getPhone());
                    intent.putExtra("email", li.user.getEmail());
                    intent.putExtra("content", li.user.getContent());
                    intent.putExtra("img", li.user.getImg());
                    intent.putExtra("accessToken", 1);

                    startActivity(intent);
                    break;
                case R.id.main_friends_add_btn:
                    Intent intent1 = new Intent(con, InsertFriend.class);
                    startActivity(intent1);
                    break;
                case R.id.main_friends_list_ok_btn:
                    deleteBtnEvent();
                    break;
                case R.id.main_friends_list_cancel_btn:
                    friendListAdapter.hideCheckbox();
            }
        }

    };

    public void deleteBtnEvent(){
        ArrayList<Integer> temp = friendListAdapter.getSelectedCheckboxPosition();
        ArrayList<Integer> selectedFriendsNos = new ArrayList<>();

        for(int i : temp){
            Log.v(TAG, friendListAdapter.getFriends().get(i).printAll());
            selectedFriendsNos.add(friendListAdapter.getFriends().get(i).getNo());
        }

        if (selectedFriendsNos.size() == 0){
            Toast.makeText(con, "삭제할 친구를 선택해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(con);
        dialog.setTitle("친구 삭제");
        dialog.setMessage("정말로 삭제하시겠습니까?");
        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (selectedFriendsNos.size() == 1) {
                    deleteFriend(selectedFriendsNos);
                } else {
                    deleteFriends(selectedFriendsNos);
                }
            }
        });
        dialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        dialog.show();
    }

    public void deleteFriends(ArrayList<Integer> nos){
        String jspName = "mulitDelete.jsp";
        Object object = null;
        String result = "0";

        String data = "";
        for(int i = 0; i < nos.size(); i ++){
            data += Integer.toString(nos.get(i));
            if(i != nos.size()-1){
                data += ",";
            }
        }
        PostTasks postTasks = new PostTasks(con, CommonInfo.hostRootAddr+jspName, data);

        try {
            object = postTasks.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = (String) object;

        deleteReuslt(result);
    }

    public void deleteFriend(ArrayList<Integer> nos){
        String result = "0";
        String data = "&no=" + nos.get(0);
        result = requestDBWork("delete", data);
        deleteReuslt(result);
    }

    public void deleteReuslt(String result){
        if (result.equals("1")) {
            Toast.makeText(con, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
            onResume();
        } else {
            Toast.makeText(con, "삭제에 실패했습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    private String requestDBWork(String work, String data){
        String result = "0";
        String jspName = "friendDelete.jsp?requester=" + LoginedUserInfo.user.getId() + data;

        try{
            FriendSelector networkTask = new FriendSelector(con, CommonInfo.hostRootAddr+jspName, work);
            Log.v(TAG, "Connect Addr : " + CommonInfo.hostRootAddr+jspName);
            Object object = networkTask.execute().get();
            result = (String) object;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}