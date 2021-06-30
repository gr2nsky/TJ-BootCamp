package com.example.retrofittest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    // @GET( EndPoint-자원위치(URI) )
    @GET("test/{jsp}")
    Call<PostResult> getJspFile(@Path("jsp") String post);

    /*
    URL = 프로토콜 + URL
    https://jsonplaceholder.typicode.com/posts/
    baseUrl : https://jsonplaceholder.typicode.com/
    EndPdoint : posts/{입력할값}

     */


    //http://192.168.2.4:8080/MogaStyle/Hair/Reservation/reservationListLoad.jsp?userNo=1
    @GET("Hair/Reservation/reservationListLoad.jsp?")
    Call<ReservationList> getList(@Query("userNo") String userNo);

    @GET("Hair/Reservation/reservationListLoad.jsp?")
    Call<String> getListString(@Query("userNo") String userNo);
}
