package com.example.tesseract;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    TextView tessResult;
    TessBaseAPI tess;
    String dataPath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tessResult = findViewById(R.id.tessResult);
        checkPermission();

        dataPath = getFilesDir().toString() + "/tesseract/";
//        dataPath = "/data/com.example.tesseract/files" + "/tesseract/";
//        dataPath = "/data/data/com.example.tesseract/files" + "/tesseract/";
//        Log.d("TAG", "onCreate: " + dataPath);

        checkFile(new File(dataPath + "tessdata/"), "kor");
        checkFile(new File(dataPath + "tessdata/"), "eng");

        String lang = "kor+eng";
        tess = new TessBaseAPI();
        tess.init(dataPath, lang);
        processImage(BitmapFactory.decodeResource(getResources(),R.drawable.test));
    }

    public void processImage(Bitmap bitmap){
        Toast.makeText(this, "복잡한 이미지일수록 시간이 오래걸릴 수 있습니다.", Toast.LENGTH_SHORT).show();
        String OCResult = null;
        tess.setImage(bitmap);
        OCResult = tess.getUTF8Text();
        tessResult.setText(OCResult);
    }

    private void copyFiles(String lang){
        try{
            String filepath = dataPath + "/tessdata/" + lang + ".traineddata";
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("tessdata/"+lang+".traineddata");
            OutputStream outputStream = new FileOutputStream(filepath);

            byte[] buffer = new byte[1024];
            int read;
            while((read = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, read);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            Log.e("tesseract", "copyFiles: FileNotFoundException", e);
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("tesseract", "copyFiles: IOException", e);
            e.printStackTrace();
        }
    }

    private void checkFile(File dir, String lang){
        if(!dir.exists() && dir.mkdirs()){
            copyFiles(lang);
        }

        if(dir.exists()){
            String datafilePath = dataPath + "/tessdata/" + lang + ".traineddata";
            File datafile = new File(datafilePath);
            if(!datafile.exists()){
                copyFiles(lang);
            }
        }
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // 마시멜로우 버전과 같거나 이상이라면
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if(shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "외부 저장소 사용을 위해 읽기/쓰기 필요", Toast.LENGTH_SHORT).show();
                }

                requestPermissions(new String[]
                                {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                        2);  //마지막 인자는 체크해야될 권한 갯수

            } else {
                //Toast.makeText(this, "권한 승인되었음", Toast.LENGTH_SHORT).show();
            }
        }
    }
}