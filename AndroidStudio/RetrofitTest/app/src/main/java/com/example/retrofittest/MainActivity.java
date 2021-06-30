package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    String TAG = "############################";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callRestrofit2();
    }
    public void callRestrofit2() {
        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("http://192.168.2.4:8080/MogaStyle/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService service2 = retrofit2.create(RetrofitService.class);
        Call<ReservationList> call2 = service2.getList("1");

        call2.enqueue(new Callback<ReservationList>() {
            @Override
            public void onResponse(Call<ReservationList> call, Response<ReservationList> response) {
                ReservationList result = response.body();
                Log.d(TAG, "onResponse:성공");
                Log.d(TAG, "결과 : " + result.toString());
            }

            @Override
            public void onFailure(Call<ReservationList> call, Throwable t) {
                Log.d(TAG, "onResponse:실패");
                Log.d(TAG, "결과 : " + t.toString());
            }
        });
    }

     ///////////////////////////////////////////////////////////////
    //                        sample                             //
    ///////////////////////////////////////////////////////////////
    public void callRestrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.2.4:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<PostResult> call = service.getJspFile("retrofitTest.jsp");

        call.enqueue(new Callback<PostResult>() {
            @Override
            public void onResponse(Call<PostResult> call, Response<PostResult> response) {
                if(response.isSuccessful()){
                    PostResult result = response.body();
                    Log.d(TAG, "onResponse:성공");
                    Log.d(TAG, "결과 : " + result.toString());
                }
            }

            @Override
            public void onFailure(Call<PostResult> call, Throwable t) {
                Log.d(TAG, "onResponse:실패");
                Log.d(TAG, "결과 : " + t.toString());
            }
        });
    }
}