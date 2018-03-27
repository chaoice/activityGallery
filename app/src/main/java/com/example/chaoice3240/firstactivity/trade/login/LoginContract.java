package com.example.chaoice3240.firstactivity.trade.login;

import com.example.chaoice3240.firstactivity.base.BasePresenter;
import com.example.chaoice3240.firstactivity.base.BaseView;
import com.example.chaoice3240.firstactivity.database.user.UserEntity;

/**
 * Created by luthfihariz on 5/20/17.
 */

public class LoginContract {
    interface Presenter extends BasePresenter<View> {
        void Login(UserEntity userEntity);
    }

    interface View extends BaseView<Presenter> {
        void showSuccess(Boolean flag);
        void hideProgress();
        void showProgress();
        void showError(Throwable e);
    }
}
