package com.example.erdiya.NetworkTasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.example.erdiya.Activities.Login;
import com.example.erdiya.Common.LoginedUserInfo;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ImageUploader extends AsyncTask<Integer, String, Integer> {

    final static String TAG = "@@@@ImageUploader@@@@";
    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    String devicePath;
    ImageView imageView;
    String type = null;
    String no = null;

    public ImageUploader(Context context, ImageView imageView, String devicePath, String mAddr, String type, String no) {
        this.context = context;
        this.mAddr = mAddr;
        this.devicePath = devicePath;
        this.imageView = imageView;
        this.type = type;
        this.no = no;

        Log.v(TAG, "mAddr : " + mAddr);
        Log.v(TAG, "devicePath : " + devicePath);
    }

    @Override
    protected void onPreExecute() {
        Log.v(TAG, "onPreExecute()");
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Status");
        progressDialog.setMessage("Uploading ....");
        progressDialog.show();

    }

    @Override
    protected void onProgressUpdate(String... values) {
        Log.v(TAG, "onProgressUpdate()");
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        Log.v(TAG, "onPostExecute()");
        progressDialog.dismiss();

    }

    @Override
    protected void onCancelled() {
        Log.v(TAG, "onCancelled()");
        super.onCancelled();
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        File file = new File(devicePath);
        Log.v(TAG, "file.getAbsolutePath() : " + file.getAbsolutePath());
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("image", file.getName(), RequestBody.create(file, MediaType.parse("image/jpeg")))
                .addFormDataPart("type", type)
                .addFormDataPart("no", no)
                .addFormDataPart("requester", LoginedUserInfo.user.getId())
                .build();

        Request request = new Request.Builder()
                .url(mAddr)
                .post(requestBody)
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            Log.v(TAG, "Success : " + response.body().string());
            return 1;
        } catch (IOException e) {
            Log.v(TAG, "###IOException###");
            e.printStackTrace();
            return 0;
        } catch (Exception e) {
            Log.v(TAG, "Error");
            e.printStackTrace();
            return 0;
        }
    }

}
