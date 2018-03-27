package com.example.chaoice3240.firstactivity.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

import com.example.chaoice3240.firstactivity.database.user.UserDao;
import com.example.chaoice3240.firstactivity.database.user.UserEntity;

/**
 * Created by Admin on 2018/3/22.
 */


@Database(entities = {UserEntity.class}, version = 2)
public abstract class DbMng extends RoomDatabase {
    public abstract UserDao userDao();
    public static final Migration MIGRATION_1_2=new Migration(1,2) {

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("alter table UserEntity modify column firstName ");
        }
    };
}