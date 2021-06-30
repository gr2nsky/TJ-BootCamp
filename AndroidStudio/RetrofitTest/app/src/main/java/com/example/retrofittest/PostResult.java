package com.example.retrofittest;
/*
{
	"userId": 1,
	"id": 1,
	"title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
	"body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
 */

import com.google.gson.annotations.SerializedName;

public class PostResult {

    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int id;
    // @SerializedName으로 일치시켜 주지않을 경우엔 클래스 변수명이 일치해야함

    private String title;
    // @SerializedName()로 변수명을 입치시켜주면 클래스 변수명이 달라도 알아서 매핑시켜줌

    @SerializedName("body")
    private String bodyValue;

    @SerializedName("none")
    private String none;

    // toString()을 Override 해주지 않으면 객체 주소값을 출력함
    @Override
    public String toString() {
        return "PostResult{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", bodyValue='" + bodyValue + '\'' +
                ", none='" + none + '\'' +
                '}';
    }

}
