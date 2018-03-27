package com.example.chaoice3240.firstactivity.repository.user;
import com.example.chaoice3240.firstactivity.database.DbMng;
import com.example.chaoice3240.firstactivity.database.user.UserEntity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by luthfihariz on 5/20/17.
 */

public class UserLocalDataSource implements UserDataSource {

    @Inject
    DbMng dbMng;
    @Inject
    public UserLocalDataSource() {
    }

    @Override
    public Observable<Boolean> insertUser(UserEntity userEntity)
    {
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
    @Override
    public Observable<UserEntity> getUser(String firstName)
    {
        return Observable.just(firstName)
                .observeOn(Schedulers.io())
                .flatMap(new Func1<String, Observable<UserEntity>>() {
                    @Override
                    public Observable<UserEntity> call(String firstName) {
                        UserEntity userEntity=dbMng.userDao().searchUserByName(firstName);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return Observable.just(userEntity);
                    }
                });
    }

    @Override
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
