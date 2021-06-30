package com.example.erdiya.Beans;

import java.util.ArrayList;

public class Group {

    int no;
    String name;
    ArrayList<Friend> friends;

    public Group(int no, String name, ArrayList<Friend> friends) {
        this.no = no;
        this.name = name;
        this.friends = friends;
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

    public ArrayList<Friend> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Friend> friends) {
        this.friends = friends;
    }
}
