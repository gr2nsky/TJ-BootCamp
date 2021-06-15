package com.example.erdiya.Beans;

public class Friend {
    int no;
    String name;
    String phone;
    String email;
    String relation;
    String group;
    String img;

    public Friend(int no, String name, String phone, String email, String relation, String group, String img) {
        this.no = no;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.relation = relation;
        this.group = group;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String printAll(){
        String str =  "no : " + no + ", name : " + name + ", phone : " + phone + ", reation : " +
                relation + ", group : " + group + ", img : " + img;
        return str;
    }
}
