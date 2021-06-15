package com.example.erdiya.Beans;

public class User {

    int no;
    String id;
    String name;
    String phone;
    String email;
    String content;
    String img;

    public User() {
    }

    public User(int no, String id, String name, String phone, String email, String content, String img) {
        this.no = no;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.content = content;
        this.img = img;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
