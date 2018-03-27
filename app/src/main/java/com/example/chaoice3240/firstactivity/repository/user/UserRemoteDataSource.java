package com.example.chaoice3240.firstactivity.repository.user;

import com.example.chaoice3240.firstactivity.database.user.UserEntity;
import com.example.chaoice3240.firstactivity.netservice.dto.PerDetailsRes;
import com.example.chaoice3240.firstactivity.netservice.netinterface;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by luthfihariz on 5/20/17.
 */

public class UserRemoteDataSource implements UserDataSource {

    private static final String TAG = "UserRemoteDataSource";
    @Inject
    netinterface netinterface;
    @Inject
    public UserRemoteDataSource() {
    }

    @Override
    public Observable<UserEntity> getUsers() {
        // 创建 网络请求接口 的实例
        String postData="{\"head\" : {\"tx_code\": \"1372303\",\"chnl_type\": \"TBNK\",\"cif_no\": \"10039089\"},\"body\" : {\"tellerNo\": \"0403\"}}";
        MediaType mediaType = MediaType.parse("application/json");
        return netinterface.getUser(RequestBody.create(mediaType,postData))
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<PerDetailsRes, Observable<UserEntity>>() {
                    @Override
                    public Observable<UserEntity> call(PerDetailsRes perDetailsRes) {
                        UserEntity userEntity=new UserEntity();
                        userEntity.firstName=perDetailsRes.getCifName();
                        return Observable.just(userEntity);
                    }
                });
    }

    @Override
    public Observable<UserEntity> getUser(String firstName) {
        throw new RuntimeException("method not supported");
    }

    @Override
    public Observable<Boolean> insertUser(UserEntity userEntity) {
        throw new RuntimeException("method not supported");
    }
}
