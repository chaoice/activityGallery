package com.example.chaoice3240.firstactivity.repository.user;

import com.example.chaoice3240.firstactivity.customView.DaggerCustomViewModelComponent;
import com.example.chaoice3240.firstactivity.database.user.UserEntity;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by luthfihariz on 5/21/17.
 */

public class UserRepository implements UserDataSource {

    @Inject
    UserLocalDataSource userLocalDataSource;
    @Inject
    UserRemoteDataSource userRemoteDataSource;
    public UserRepository() {
        DaggerCustomViewModelComponent.create().inject(this);
    }

    @Override
    public Observable<UserEntity> getUsers() {
        return userLocalDataSource.getUsers();
    }

    @Override
    public Observable<UserEntity> getUser(String firstName) {
        return userLocalDataSource.getUser(firstName);
    }

    @Override
    public Observable<Boolean> insertUser(UserEntity userEntity) {
        return userLocalDataSource.insertUser(userEntity);
    }
}
