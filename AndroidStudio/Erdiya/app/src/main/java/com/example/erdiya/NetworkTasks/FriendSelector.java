package com.example.erdiya.NetworkTasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.erdiya.Beans.Friend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class FriendSelector extends AsyncTask<Integer, String, Object> {

    String TAG = "@@@FriendSelector@@@";

    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    ArrayList<Friend> friends = null;
    //Network Task를 하나로 사용하기 위해 생성자 사용
    String where = null;

    public FriendSelector(Context context, String mAddr, String where) {
        this.context = context;
        this.mAddr = mAddr;
        this.where = where;
        this.friends = new ArrayList<>();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.v(TAG, "onPreExecute: 실행");
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("data load...");
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Log.v(TAG, "onPostExecute: run");
        progressDialog.dismiss();
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
        Log.v(TAG, "onCancelled: run");
        progressDialog.dismiss();
    }

    @Override
    protected Object doInBackground(Integer... integers) {

        Log.v(TAG, "doInBackground: run");
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String result = null;

        try {
            URL url = new URL(mAddr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true) {
                    String str = bufferedReader.readLine();
                    if (str == null) break;
                    stringBuffer.append(str + "\n");
                }

                Log.v(TAG, "doInBackground get resource : " + stringBuffer.toString());

                if (where.equals("select")) {
                    parserSelect(stringBuffer.toString());
                } else {
                    result = parserAction(stringBuffer.toString());
                }

                Log.v(TAG, "doInBackground: complete");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (inputStreamReader != null) inputStreamReader.close();
                if (inputStream != null) inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (where.equals("select")) {
            return friends;
        }
        Log.v(TAG, "doInBackground: exit");
        return result;
    }

    private void parserSelect(String str) {
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("friends_select_all"));
            friends.clear();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                int no = jsonObject1.getInt("no");
                String name = jsonObject1.getString("name");
                String phone = jsonObject1.getString("phone");
                String email = jsonObject1.getString("email");
                String relation = jsonObject1.getString("relation");
                String group = jsonObject1.getString("group");
                String img = jsonObject1.getString("img");

                Friend friend = new Friend(no, name, phone, email, relation, group, img);
                friends.add(friend);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String parserAction(String str) {
        String returnValue = null;
        try {
            JSONObject jsonObject = new JSONObject(str);
            returnValue = jsonObject.getString("result");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

}
