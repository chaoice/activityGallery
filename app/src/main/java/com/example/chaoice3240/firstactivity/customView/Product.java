package com.example.chaoice3240.firstactivity.customView;

import android.os.Handler;
import android.util.Log;

import com.example.chaoice3240.firstactivity.database.DbMng;
import com.example.chaoice3240.firstactivity.database.user.UserEntity;
import com.example.chaoice3240.firstactivity.netservice.dto.PerDetailsRes;
import com.example.chaoice3240.firstactivity.netservice.netinterface;

import java.util.List;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Admin on 2018/3/18.
 */

public class Product {
    private String getU;
    private static final String TAG = "Product";
    private Handler handler;
    @Inject
    DbMng dbMng;
    @Inject
    netinterface netinterface;
    @Inject
    public Product() {
        Log.d(TAG, "ConstructProduct: ");
        getU="catch me";
        handler=new Handler();
    }
    public void getuserinfos()
    {
        // 创建 网络请求接口 的实例
        String postData="{\"head\" : {\"tx_code\": \"1372303\",\"chnl_type\": \"TBNK\",\"cif_no\": \"10039089\"},\"body\" : {\"tellerNo\": \"0403\"}}";
        MediaType mediaType = MediaType.parse("application/json");
        netinterface.getUser(RequestBody.create(mediaType,postData))
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<PerDetailsRes, Observable<PerDetailsRes>>() {
                    @Override
                    public Observable<PerDetailsRes> call(PerDetailsRes perDetailsRes) {
                        Log.d(TAG, "call: "+perDetailsRes.getCifName());
                        String postData="{\"head\" : {\"tx_code\": \"1372303\",\"chnl_type\": \"TBNK\",\"cif_no\": \"10039089\"},\"body\" : {\"tellerNo\": \"0403\"}}";
                        MediaType mediaType = MediaType.parse("application/json");
                        return netinterface.getUser(RequestBody.create(mediaType,postData));
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PerDetailsRes>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PerDetailsRes perDetailsRes) {
                        Log.d(TAG, "onNext: "+perDetailsRes.getCifName());
                    }
                });
        //测试



// 发送网络请求（同步）
//        try {
//            Response<PerDetailsRes> response = call.execute();
//            Log.d(TAG, "syn get from server"+response.body().getCifName());
//        } catch (IOException e) {
//            Log.d(TAG, "userinfo: exception"+e);
//        }

    }

    public String getGetU() {
        return getU;
    }

    public void setGetU(String getU) {
        this.getU = getU;
    }
    public Observable<Boolean> insertUser()
    {
        UserEntity userEntity=new UserEntity(){{
            firstName="zhang";
            lastName="chao";
            age=29;
        }};
        return Observable.just(userEntity)
                .observeOn(Schedulers.io())
                .flatMap(new Func1<UserEntity, Observable<Boolean>>() {
            @Override
            public Observable<Boolean> call(UserEntity userEntity) {
                dbMng.userDao().insertUsers(userEntity);
                return Observable.just(true);
            }
        });
    }
    public Observable<UserEntity> getUser(String firstName)
    {
        return Observable.just(firstName)
                .observeOn(Schedulers.io())
                .flatMap(new Func1<String, Observable<UserEntity>>() {
                    @Override
                    public Observable<UserEntity> call(String firstName) {
                        UserEntity userEntity=dbMng.userDao().searchUserByName(firstName);
                        return Observable.just(userEntity);
                    }
                });
    }


    public Observable<UserEntity> getUsers()
    {
        return Observable.just("1")
                .observeOn(Schedulers.io())
                .flatMap(new Func1<String, Observable<UserEntity>>() {
            @Override
            public Observable<UserEntity> call(String s) {
                List<UserEntity> userEntities= dbMng.userDao().searchAllUsers();
                return Observable.from(userEntities);
            }
        });
    }

}

