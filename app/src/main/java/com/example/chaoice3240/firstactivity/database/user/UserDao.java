package com.example.chaoice3240.firstactivity.database.user;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import java.util.List;

/**
 * Created by Admin on 2018/3/22.
 */

@Dao
public interface UserDao {

    @Insert
    public long[] insertUsers(UserEntity... users);

    @Insert
    public void insertUserList(List<UserEntity> users);

    @Update
    public void updateUsers(UserEntity... users);

    @Delete
    public void deleteUsers(UserEntity... users);

    @Query("select * from UserEntity")
    public List<UserEntity> searchAllUsers();

    @Query("select * from UserEntity where :age > 18")
    public List<UserEntity> searchUsersByAge(int age);

    @Query("select firstName,age from UserEntity")
    public List<SimpleUser> searchAllSimpleUsers();

    @Query("select * from UserEntity where firstName like :name limit 1")
    public UserEntity searchUserByName(String name);
} 
