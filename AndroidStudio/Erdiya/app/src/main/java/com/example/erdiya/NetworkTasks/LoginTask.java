package com.example.erdiya.NetworkTasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.erdiya.Beans.Friend;
import com.example.erdiya.Beans.User;
import com.example.erdiya.Common.CommonInfo;
import com.example.erdiya.Common.LoginedUserInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class LoginTask extends AsyncTask<Integer, String, Object> {
    String TAG = "@@@LoginTask@@@";

    Context context = null;
    String mAddr = CommonInfo.hostRootAddr + "login.jsp";
    String data = null;
    ProgressDialog progressDialog = null;
    //로그인시 0, 수정시 1
    int type = 0;

    public LoginTask(Context context, String id, String pw) {
        this.context = context;
        data = "id=" + id + "&pw=" + pw + "&type=" + type + "&no=0";
    }

    public LoginTask(Context context, int no) {
        this.context = context;
        this.type = 1;
        data = "id=null&pw=null" + "&no=" + no + "&type="+type;
        mAddr = CommonInfo.hostRootAddr + "init.jsp";

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
        String result = "0";

        Log.v(TAG, "doInBackground: run");
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();

        try {
            URL url = new URL(mAddr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestMethod("POST");
            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
            Log.v(TAG, "sendMsg : " + data);
            osw.write(data);
            osw.flush();

            Log.v(TAG, "getResponseCode : " + conn.getResponseCode());
            if(conn.getResponseCode() == conn.HTTP_OK) {
                inputStream = conn.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true) {
                    String str = bufferedReader.readLine();
                    Log.v(TAG, "bufferedReader.readLine() : " + str);
                    if (str == null) break;
                    stringBuffer.append(str + "\n");
                }

                Log.v(TAG, "doInBackground get resource : " + stringBuffer.toString());

                JSONObject jsonObject = new JSONObject(stringBuffer.toString());
                JSONObject responseData = jsonObject.getJSONObject("login_result");

                Log.v(TAG, "doInBackground get resource : " + stringBuffer.toString());

                result = parserSelect(responseData);
                Log.v(TAG, "doInBackground: complete");

            } else {
                Log.i("통신 결과", conn.getResponseCode()+"에러");
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

        Log.v(TAG, "doInBackground: exit");
        return result;
    }

    private String parserSelect(JSONObject jsonObject) {
        String result = "0";
        try {
            int no = jsonObject.getInt("no");
            String id = jsonObject.getString("id");
            String name = jsonObject.getString("name");
            String phone = jsonObject.getString("phone");
            String email = jsonObject.getString("email");
            String content = jsonObject.getString("content");
            String img = jsonObject.getString("img");

            User user = new User(no, id, name, phone, email, content, img);
            Log.v(TAG, "logined data : " + no + id + name + phone + email + content + img);
            LoginedUserInfo.user = user;
            if(no != 0){
                result = "1";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
