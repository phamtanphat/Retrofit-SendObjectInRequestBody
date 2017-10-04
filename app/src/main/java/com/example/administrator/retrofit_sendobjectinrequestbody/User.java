package com.example.administrator.retrofit_sendobjectinrequestbody;

/**
 * Created by Administrator on 10/4/2017.
 */

public class User {
    private int id;
    private String name;
    private String email;
    private int age;
    private String[] topics;

    public User(String name, String email, int age, String[] topics) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.topics = topics;
    }

    public int getId() {
        return id;
    }
}
