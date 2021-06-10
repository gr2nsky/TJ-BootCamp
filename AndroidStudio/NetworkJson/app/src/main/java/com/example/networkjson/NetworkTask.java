package com.example.networkjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {

    String TAG = "networkTask";

    Context con = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    ArrayList<JsonMember> members;

    //main에서 new해서 쓸거므로 생성자 생성


    public NetworkTask(Context con, String mAddr) {
        this.con = con;
        this.mAddr = mAddr;
        this.members = new ArrayList<JsonMember>();
    }

    @Override
    protected void onPreExecute() {
        Log.e(TAG, "onPreExecute");
        progressDialog = new ProgressDialog(con);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dalog");
        progressDialog.setMessage("download ...");
        progressDialog.show();
    }

    // ...은 복수일수도 다수일수도 있음을 뜻함
    @Override
    protected Object doInBackground(Integer... integers) {
        Log.e(TAG, "doInBackground");
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try{
            URL url = new URL(mAddr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);

            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                while(true){
                    String strLine = bufferedReader.readLine();
                    if(strLine == null) break;

                    stringBuffer.append(strLine+"\n");
                }
                parser(stringBuffer.toString());
            }


        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (inputStreamReader != null) inputStreamReader.close();
                if (inputStream != null) inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return members;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        Log.e(TAG, "onProgressUpdate");
    }

    @Override
    protected void onPostExecute(Object o) {
        Log.e(TAG, "onPostExecute");
        super.onPostExecute(o);
        progressDialog.dismiss();
    }

    private void parser(String s){
        Log.e(TAG, "parser");
        try{
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("members_info"));
            members.clear();

            for(int i = 0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String name = jsonObject1.getString("name");
                int age = jsonObject1.getInt("age");
                ArrayList<String> hobbies = new ArrayList<>();
                JSONArray jsonArray1 = jsonObject1.getJSONArray("hobbies");
                for(int j = 0; j < jsonArray1.length(); j++){
                    String hobby = jsonArray1.getString(j);
                    hobbies.add(hobby);
                }

                JSONObject jsonObject2 = jsonObject1.getJSONObject("info");
                int no = jsonObject2.getInt("no");
                String id = jsonObject2.getString("id");
                String pw = jsonObject2.getString("pw");

                JsonMember member = new JsonMember(name, age, hobbies, no, id, pw);
                members.add(member);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
