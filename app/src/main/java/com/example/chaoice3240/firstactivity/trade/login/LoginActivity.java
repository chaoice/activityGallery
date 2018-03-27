package com.example.chaoice3240.firstactivity.trade.login;


import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.chaoice3240.firstactivity.R;
import com.example.chaoice3240.firstactivity.customView.DaggerCustomViewModelComponent;
import com.example.chaoice3240.firstactivity.database.user.UserEntity;
import com.example.chaoice3240.firstactivity.repository.user.UserRepository;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private static final String TAG = "LoginActivity";
    private  LoginContract.Presenter mPresenter;
    private  EditText etUserName;
    private EditText etPwd;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName=(EditText) findViewById(R.id.et_username);
        etPwd=(EditText) findViewById(R.id.et_password);
        mProgressBar=(ProgressBar)findViewById(R.id.gb_login);

        UserRepository userRepository=new UserRepository();
        mPresenter=new LoginPresenter(userRepository);
        mPresenter.bind(this);
    }


    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        presenter=presenter;
    }

    @Override
    public void showSuccess(Boolean flag) {
        if(flag) {
            Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(LoginActivity.this,"注册失败",Toast.LENGTH_SHORT).show();

        }
        Log.d(TAG, "showSuccess: "+flag);
        //goto loginpage
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(LoginActivity.this,"注册失败"+e.getMessage(),Toast.LENGTH_LONG).show();
        Log.d(TAG, "showError: "+e.getMessage());
    }

    public void onClick(View view) {
        UserEntity userEntity=new UserEntity();
        userEntity.firstName=etUserName.getText().toString();
        mPresenter.Login(userEntity);
    }
}

