package com.example.chaoice3240.firstactivity.injectSource;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.chaoice3240.firstactivity.base.MyApplictaion;
import com.example.chaoice3240.firstactivity.customView.Product;
import com.example.chaoice3240.firstactivity.database.DbMng;
import com.example.chaoice3240.firstactivity.netservice.netinterface;

import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 2018/3/18.
 */
@dagger.Module
public class Module {

    Retrofit retrofit;
    public Module() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.111:9080/") // 设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create()) // 设置数据解析器
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 支持RxJava平台
                .build();
    }

    @Provides
    Product providerModelProduct()
    {
        return new Product(){{setGetU("module indext");}};
    }
    @Provides
    netinterface providerNetinterface()
    {
        return retrofit.create(netinterface.class);
    }

    @Provides
    DbMng providerDbMng()
    {
        DbMng database = Room.databaseBuilder(MyApplictaion.getContext(),DbMng.class, "room.db")
                //.addMigrations(MIGRATION_1_2)
                .fallbackToDestructiveMigration()
                .build();
        return database;
    }
    @Provides
    Context providerContext()
    {
        return MyApplictaion.getContext();
    }

}
