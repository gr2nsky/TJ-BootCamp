package com.example.erdiya.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erdiya.Beans.Friend;
import com.example.erdiya.Common.CommonInfo;
import com.example.erdiya.Common.LoginedUserInfo;
import com.example.erdiya.CustomAdapter.FriendListAdapter;
import com.example.erdiya.NetworkTasks.FriendSelector;
import com.example.erdiya.NetworkTasks.ImageUploader;
import com.example.erdiya.NetworkTasks.LoginTask;
import com.example.erdiya.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;

public class FriendDetail extends AppCompatActivity {
    String devicePath = Environment.getDataDirectory().getAbsolutePath() + "/data/com.example.erdiya/";
    String urlAddr = CommonInfo.hostRootAddr + "/multipartRequest.jsp";

    String TAG = "###FriendDetail###";
    private final int REQ_CODE_SELECT_IMAGE = 300; // Gallery Return Code
    private String img_path = null; // 최종 file name
    private String f_ext = null;    // 최종 file extension
    File tempSelectFile;

    // <<<<<<<<<<< 레이아웃 아이템 선언 >>>>>>>>>>>>
    ImageView iv;
    ImageView background_iv;
    EditText name_tv;
    EditText phone_tv;
    EditText email_tv;
    EditText relation_tv;
    EditText group_tv;
    TextView cGroup_tv;
    TextView cRelation_tv;
    Button modiftBtn;
    Button deleteBtn;
    int no;

    //어디서 진입했는지 알려줌 0:주소록에서 접근
    int accessToken = 0;
    //수정모드 토큰
    int modifyToken = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_detail);

        // <<<<<<<<<<<<<<<<< 인텐트 획득 >>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Intent intent = getIntent();
        no = intent.getIntExtra("no", 0);
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");
        String relation = intent.getStringExtra("relation");
        String group = "";
        String img = intent.getStringExtra("img");
        accessToken = intent.getIntExtra("accessToken", 0);

        if (email.equals("null") || email.equals("") || email == null) email = "";
        if (accessToken == 0 ) {
            if (relation.equals("null") || relation.equals("") || relation == null) relation = "";
        }

        // <<<<<<<<<<<<<<<<< 레이아웃 아이템 바인딩 >>>>>>>>>>>>>>>>>>>>>>>>>
        iv = findViewById(R.id.friend_detail_img);
        background_iv = findViewById(R.id.friend_detail_background_img);
        name_tv = findViewById(R.id.friend_detail_name);
        phone_tv = findViewById(R.id.friend_detail_phone);
        email_tv = findViewById(R.id.friend_detail_email);
        relation_tv = findViewById(R.id.friend_detail_relation);
        group_tv = findViewById(R.id.friend_detail_group);
        cGroup_tv = findViewById(R.id.chacngeable_group_tv);
        cRelation_tv = findViewById(R.id.chacngeable_elation_tv);
        modiftBtn = findViewById(R.id.friend_modify_btn);
        deleteBtn = findViewById(R.id.friend_detail_btn);

        Picasso.get()
                .load(CommonInfo.hostRootAddr+img)
                .error(R.drawable.friend_default_img)
                .into(iv);

        iv.setOnClickListener(onClickListener);
        modiftBtn.setOnClickListener(onClickListener);
        deleteBtn.setOnClickListener(onClickListener);

        //<<<<<<<<<<<<<<<<< 데이터 바인딩 >>>>>>>>>>>>>>>>>>>>>>>>
        name_tv.setText(name);
        phone_tv.setText(phone);
        email_tv.setText(email);
        relation_tv.setText(relation);
        group_tv.setText(group);

        if (accessToken == 1){
            deleteBtn.setVisibility(View.INVISIBLE);
            cGroup_tv.setText("비밀번호");
            cGroup_tv.setInputType(TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            cRelation_tv.setText("한마디");
            relation_tv.setText(LoginedUserInfo.user.getContent());
        }


        Log.v(TAG, "access token : " + accessToken);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.friend_detail_btn:
                    if (modifyToken == 0){
                        deleteFriend();
                    } else {
                        doModify();
                    }
                    break;
                case R.id.friend_modify_btn:
                    if(modifyToken == 0){
                        modifyMode();
                    } else {
                        modifyModeOff();
                    }
                    break;
                case R.id.friend_detail_img:
                    selectProfilePhoto();
                    break;
            }
        }
    };

    public void modifyMode(){
        modifyToken = 1;
        modiftBtn.setText("취소");
        deleteBtn.setText("완료");
        name_tv.setEnabled(true);
        name_tv.setBackgroundColor(Color.parseColor("#ffffff"));
        phone_tv.setEnabled(true);
        phone_tv.setBackgroundColor(Color.parseColor("#ffffff"));
        email_tv.setEnabled(true);
        email_tv.setBackgroundColor(Color.parseColor("#ffffff"));
        relation_tv.setEnabled(true);
        relation_tv.setBackgroundColor(Color.parseColor("#ffffff"));
        group_tv.setEnabled(true);
        group_tv.setBackgroundColor(Color.parseColor("#ffffff"));
        if (accessToken == 1){
            deleteBtn.setVisibility(View.VISIBLE);
        }
    }
    public void modifyModeOff(){
        modifyToken = 0;
        modiftBtn.setText("수정");
        deleteBtn.setText("삭제");
        name_tv.setEnabled(false);
        name_tv.setBackgroundColor(Color.parseColor("#00ffffff"));
        phone_tv.setEnabled(false);
        phone_tv.setBackgroundColor(Color.parseColor("#00ffffff"));
        email_tv.setEnabled(false);
        email_tv.setBackgroundColor(Color.parseColor("#00ffffff"));
        relation_tv.setEnabled(false);
        relation_tv.setBackgroundColor(Color.parseColor("#00ffffff"));
        group_tv.setEnabled(false);
        group_tv.setBackgroundColor(Color.parseColor("#00ffffff"));
        if (accessToken == 1){
            deleteBtn.setVisibility(View.INVISIBLE);
        }
    }


    public void deleteFriend(){
        if (no == 0){
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            return;
        }
        AlertDialog.Builder dialog = new AlertDialog.Builder(FriendDetail.this);
        dialog.setTitle("친구 삭제");
        dialog.setMessage("정말로 삭제하시겠습니까?");
        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String result = requestDBWork("delete", no, null);
                if (result.equals("1")){
                    Toast.makeText(FriendDetail.this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(FriendDetail.this, "삭제에 실패했습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public void doModify(){
        String fno = "&no=" + no;
        String name = "&name=" + name_tv.getText().toString();
        String phone = "&phone=" + phone_tv.getText().toString();
        String email = "";
        String relation = "";
        String group = "";
        String data = "";
        String result = "0";

        if(!email_tv.getText().toString().equals("")){
            email = "&email=" + email_tv.getText().toString();
        }
        if(!relation_tv.getText().toString().equals("")){
            relation = "&relation=" + relation_tv.getText().toString();
        }
        if(!group_tv.getText().toString().equals("")){
            group = "&group=" + group_tv.getText().toString();
        }
        data = name + phone + email + relation + group + fno;

        Log.v(TAG, "modifyData : " + data);
        if (accessToken == 1){
            result = requestDBWork("selfUpdate", no, data);
            Log.v(TAG, "run selfUpdate");
        } else {
            result = requestDBWork("update", no, data);
            Log.v(TAG, "run update");
        }

        if (result.equals("1")){
            Toast.makeText(FriendDetail.this, "수정되었습니다.", Toast.LENGTH_SHORT).show();
            if(accessToken == 1) {
                initUser();
                Log.v(TAG, "run initUser");
            }
            modifyModeOff();
        } else {
            Toast.makeText(FriendDetail.this, "수정에 실패했습니다.", Toast.LENGTH_SHORT).show();
        }
    }
    private void initUser(){
        String result = "0";
        try{
            LoginTask loginTask = new LoginTask(FriendDetail.this, no);
            Object object = loginTask.execute().get();
            result = (String) object;
        }catch (Exception e){
            e.printStackTrace();
        }
        if (result.equals("1")){
            Toast.makeText(FriendDetail.this, "정보가 성공적으로 갱신되었습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    private String requestDBWork(String work, int user_no, String data) {
        String jspName = "";
        String result = "0";
        if (work.equals("update")) {
            jspName = "friendModify.jsp?requester=" + LoginedUserInfo.user.getId() + data;
        } else if (work.equals("selfUpdate")){
            jspName = "selfUpdate.jsp?requester=" + LoginedUserInfo.user.getId() + data;
        } else {
            jspName = "friendDelete.jsp?requester=" + LoginedUserInfo.user.getId() + "&no=" + user_no;
        }
        try{
            FriendSelector networkTask = new FriendSelector(FriendDetail.this, CommonInfo.hostRootAddr+jspName, work);
            Log.v(TAG, "Connect Addr : " + CommonInfo.hostRootAddr+jspName);
            Object object = networkTask.execute().get();
            result = (String) object;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    private void selectProfilePhoto(){

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);

        //image upload to server
        Log.v(TAG, "img_path : " + img_path);
//        ImageUploader imageUploader = new ImageUploader(FriendDetail.this, iv, img_path, urlAddr);
//        try {
//            Integer result = imageUploader.execute(100).get();
//            switch (result){
//                case 1:
//                    Toast.makeText(FriendDetail.this, "Success!", Toast.LENGTH_SHORT).show();
//                    File file = new File(img_path);
//                    file.delete();
//                    break;
//                case 0:
//                    Toast.makeText(FriendDetail.this, "Error", Toast.LENGTH_SHORT).show();
//                    break;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.v(TAG, "Data :" + String.valueOf(data));

        if (requestCode == REQ_CODE_SELECT_IMAGE && resultCode == Activity.RESULT_OK) {
            try {
                //이미지의 URI를 얻어 경로값으로 반환.
                img_path = getImagePathToUri(data.getData());
                Log.v(TAG, "image path :" + img_path);
                Log.v(TAG, "Data :" +String.valueOf(data.getData()));

                //이미지를 비트맵형식으로 반환
                Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());

                //image_bitmap 으로 받아온 이미지의 사이즈를 임의적으로 조절함. width: 400 , height: 300
                Bitmap image_bitmap_copy = Bitmap.createScaledBitmap(image_bitmap, 400, 300, true);
                iv.setImageBitmap(image_bitmap_copy);

                // 파일 이름 및 경로 바꾸기(임시 저장, 경로는 임의로 지정 가능)
                String date = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());
                String imageName = date + "." + f_ext;
                tempSelectFile = new File(devicePath , imageName);
                OutputStream out = new FileOutputStream(tempSelectFile);
                image_bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

                // 임시 파일 경로로 위의 img_path 재정의
                img_path = devicePath + imageName;
                Log.v(TAG,"fileName :" + img_path);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable()  {
            public void run() {
                // 시간 지난 후 실행할 코딩
            }
        }, 2000); // 2초후

        ImageUploader imageUploader = new ImageUploader(FriendDetail.this, iv, img_path, urlAddr, Integer.toString(accessToken), Integer.toString(no));
        try {
            Integer result = imageUploader.execute(100).get();
            switch (result){
                case 1:
                    Toast.makeText(FriendDetail.this, "Success!", Toast.LENGTH_SHORT).show();
                    File file = new File(img_path);
                    file.delete();
                    break;
                case 0:
                    Toast.makeText(FriendDetail.this, "Error", Toast.LENGTH_SHORT).show();
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private String getImagePathToUri(Uri data) {

        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(data, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();

        //이미지의 경로 값
        String imgPath = cursor.getString(column_index);
        Log.v(TAG, "Image Path :" + imgPath);

        //이미지의 이름 값
        String imgName = imgPath.substring(imgPath.lastIndexOf("/") + 1);

        // 확장자 명 저장
        f_ext = imgPath.substring(imgPath.length()-3, imgPath.length());

        return imgPath;
    }

}