package com.example.chaoice3240.firstactivity.trade.login;

import com.example.chaoice3240.firstactivity.database.user.UserEntity;
import com.example.chaoice3240.firstactivity.repository.user.UserDataSource;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by luthfihariz on 5/20/17.
 */

class LoginPresenter implements LoginContract.Presenter {


    private UserDataSource mRepository;

    private LoginContract.View mView;

    public LoginPresenter(UserDataSource mRepository) {
        this.mRepository = mRepository;
    }

    @Override
    public void bind(LoginContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }
    @Override
    public void unbind() {
        mView.setPresenter(null);
        mView = null;
    }

    @Override
    public void Login(UserEntity userEntity) {
        mView.showProgress();
        mRepository.getUser(userEntity.firstName)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(new Func1<UserEntity, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(UserEntity userEntity1) {
                        if(userEntity1==null) {
                            return mRepository.insertUser(userEntity);
                        }
                        return Observable.just(false);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(this::showSuccess)
                .doOnError(this::showError)
                .subscribe();

    }

    private void showError(Throwable throwable) {
        mView.showError(throwable);
        mView.hideProgress();
    }

    private void showSuccess(Boolean flag) {
        mView.showSuccess(flag);
        mView.hideProgress();
    }

}