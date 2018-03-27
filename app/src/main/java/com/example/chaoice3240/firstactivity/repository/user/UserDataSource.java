package com.example.chaoice3240.firstactivity.repository.user;

import com.example.chaoice3240.firstactivity.database.user.UserEntity;
import rx.Observable;

/**
 * @author Admin
 *用户数据仓库
 */
public interface UserDataSource {
    public Observable<UserEntity> getUsers();
    public Observable<UserEntity> getUser(String firstName);
    public Observable<Boolean> insertUser(UserEntity userEntity);

}
