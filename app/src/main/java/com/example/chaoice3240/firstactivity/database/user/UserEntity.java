package com.example.chaoice3240.firstactivity.database.user;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;
import android.location.Address;

/**
 * Created by Admin on 2018/3/22.
 */

@Entity(indices = {@Index(value = "firstName", unique = false)})
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String firstName;
    public String lastName;
    public int age;

    @Ignore
    private Bitmap bitmap;

//    @Embedded
//    public Address address;

    public UserEntity() {
    }

    public UserEntity(int id, String firstName, String lastName, int age, Bitmap bitmap, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bitmap = bitmap;
//        this.address = address;
    }
}