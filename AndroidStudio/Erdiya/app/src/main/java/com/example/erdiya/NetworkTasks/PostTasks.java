package com.example.erdiya.NetworkTasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.erdiya.Beans.Friend;
import com.example.erdiya.Common.CommonInfo;
import com.example.erdiya.Common.LoginedUserInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PostTasks extends AsyncTask<Integer, String, Object> {

    String TAG = "@@@PostTasks@@@";

    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    String data = null;

    public PostTasks(Context context, String mAddr, String data) {
        this.context = context;
        this.mAddr = mAddr;
        this.data = data;
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
        String result = null;

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
            String sendMsg = "requester=" + LoginedUserInfo.user.getId() + "&nos=" + data;
            Log.v(TAG, "sendMsg : " + sendMsg);
            osw.write(sendMsg);
            osw.flush();

            if(conn.getResponseCode() == conn.HTTP_OK) {
                inputStream = conn.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream, "EUC-KR");
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true) {
                    String str = bufferedReader.readLine();
                    if (str == null) break;
                    stringBuffer.append(str + "\n");
                }

                Log.v(TAG, "doInBackground get resource : " + stringBuffer.toString());

                JSONObject jsonObject = new JSONObject(stringBuffer.toString());
                result = jsonObject.getString("result");

                Log.v(TAG, "doInBackground: complete");

            } else {
                Log.i("통신 결과", conn.getResponseCode()+"에러");
            }

        } catch (Exception e){
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

}
