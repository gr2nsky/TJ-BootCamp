package com.example.networkjsonex01;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {

    String TAG = "NetworkTask";

    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    ArrayList<Student> students;

    public NetworkTask(Context context, String mAddr) {
        this.context = context;
        this.mAddr = mAddr;
        students = new ArrayList<>();
    }

    @Override
    protected void onPreExecute() {
        Log.e(TAG, "onPreExecute");
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dalog");
        progressDialog.setMessage("download ...");
        progressDialog.show();
    }

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
                    Log.v(TAG, stringBuffer.toString());
                }
                parser(stringBuffer.toString());
            }
            Log.e(TAG, "doInBackground수행 완료");
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
        return students;
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
            JSONArray jsonArray = new JSONArray(jsonObject.getString("students_info"));
            students.clear();

            for(int i = 0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String code = jsonObject1.getString("code");
                String name = jsonObject1.getString("name");
                String dept = jsonObject1.getString("dept");
                String phone = jsonObject1.getString("phone");
                String img = jsonObject1.getString("img");


                Student student = new Student(code, name, dept, phone, img);
                students.add(student);
                Log.e(TAG, "parser 완료");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
