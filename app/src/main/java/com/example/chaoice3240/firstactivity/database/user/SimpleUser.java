package com.example.chaoice3240.firstactivity.database.user;

import java.io.Serializable;

/**
 * Created by Admin on 2018/3/22.
 */

public class SimpleUser implements Serializable {
    private String firstName;
    private    int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SimpleUser() {
    }

    public SimpleUser(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }
}
