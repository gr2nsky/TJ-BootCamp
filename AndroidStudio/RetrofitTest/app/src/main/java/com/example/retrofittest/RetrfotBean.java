package com.example.retrofittest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrfotBean {

    @SerializedName("no")
    @Expose
    int no;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("age")
    @Expose
    int age;

    public RetrfotBean(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
