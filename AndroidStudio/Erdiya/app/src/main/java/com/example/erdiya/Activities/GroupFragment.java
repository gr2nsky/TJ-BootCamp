package com.example.erdiya.Activities;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.erdiya.Beans.Friend;
import com.example.erdiya.Common.CommonInfo;
import com.example.erdiya.Common.LoginedUserInfo;
import com.example.erdiya.CustomAdapter.FriendListAdapter;
import com.example.erdiya.CustomAdapter.GroupListAdapter;
import com.example.erdiya.NetworkTasks.FriendSelector;
import com.example.erdiya.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GroupFragment extends Fragment {

    String TAG = "GroupFragment";

    Context con;

    ListView listView;

    public GroupFragment(Context con) {
        this.con = con;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View groupFragment = inflater.inflate(R.layout.fragment_group, container, false);

        listView = groupFragment.findViewById(R.id.group_listView);
        connectGetData();
        return groupFragment;
    }

    private void connectGetData(){
        String jspName = "friendSelector.jsp?requester=" + LoginedUserInfo.user.getId();
        ArrayList<Friend> friends = MainActivity.fArr;
        try{
            FriendSelector networkTask = new FriendSelector(con, CommonInfo.hostRootAddr+jspName, "select");
            Log.v(TAG, "Connect Addr : " + CommonInfo.hostRootAddr+jspName);
            Object object = networkTask.execute().get();
            friends = (ArrayList<Friend>) object;

            Map<Integer, ArrayList<Friend>> map = new HashMap<>();

            for(Friend f : friends){
                int gn = Integer.parseInt(f.getGroup());
                if(gn == 0) continue;

                for(int i = 1; i <= 6; i ++){
                    if (gn == i) {
                        if(!map.containsKey(i)){
                            ArrayList<Friend> fArr = new ArrayList<>();
                            fArr.add(f);
                            map.put(i, fArr);
                        } else {
                            ArrayList<Friend> fArr = map.get(i);
                            fArr.add(f);
                            map.put(i, fArr);
                        }
                    }
                }
            }

            GroupListAdapter groupListAdapter = new GroupListAdapter(con, map, R.layout.layout_list_gruop);
            listView.setAdapter(groupListAdapter);

            //friendsListView.setOnItemLongClickListener(onItemLongClickListener);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}