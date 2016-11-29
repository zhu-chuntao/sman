package com.hban.sman.mvp.simplescreen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hban.sman.R;
import com.hban.sman.mvp.base.MvpBaseActivity;
import com.hban.sman.mvp.complexscreen.MvpComplexActivity;
import com.hban.sman.mvp.data.LoginUser;
import com.hban.sman.mvp.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhuchuntao on 16-11-18.
 */

public class MvpActivity extends MvpBaseActivity<LoginPresenter> implements ILoginView {


    @BindView(R.id.login_name_input)
    EditText loginNameInput;
    @BindView(R.id.login_password_input)
    EditText loginPasswordInput;
    @BindView(R.id.login_user_info_layout)
    LinearLayout loginUserInfoLayout;
    @BindView(R.id.login_login_btn)
    Button loginLoginBtn;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_layout);
        ButterKnife.bind(this);
        getPresenter().getLastLogin();
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @OnClick(R.id.login_login_btn)
    public void onClick() {
        if (TextUtils.isEmpty(loginNameInput.getText())) {
            showHint("please input your name");
            return;
        }
        if (TextUtils.isEmpty(loginPasswordInput.getText())) {
            showHint("please input your password");
            return;
        }
        getPresenter().login(loginNameInput.getText().toString(), loginPasswordInput.getText().toString());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().destroy();
    }

    @Override
    public void showHint(String hint) {
        Toast.makeText(this, hint, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void emptyPassword() {
        loginPasswordInput.setText("");
        loginPasswordInput.requestFocus();
    }

    @Override
    public void setData(LoginUser user) {
        loginNameInput.setText(user.getUserName());
        loginPasswordInput.setText(user.getUserPassword());
    }

    @Override
    public void gotoNextPage() {
        Intent a = new Intent(this, MvpComplexActivity.class);
        startActivity(a);
    }
}
