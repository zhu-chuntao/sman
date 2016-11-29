package com.hban.sman.mvp.model;

import android.text.TextUtils;

import com.hban.sman.mvp.base.EModel;
import com.hban.sman.mvp.base.IModel;
import com.hban.sman.mvp.base.LoginError;
import com.hban.sman.mvp.data.LoginUser;
import com.hban.sman.mvp.presenter.LoginPresenter;

/**
 * Created by zhuchuntao on 16-11-22.
 */

public class LoginModel extends EModel<LoginPresenter> implements IModel {

    private LoginListener loginListener;

    public LoginModel(LoginPresenter presenter) {
        super(presenter);
    }

    public void login(final String name, final String password) {

        if (TextUtils.isEmpty(name)) {
            LoginError error = new LoginError(LoginError.NAME_EMPTY);
            error.setHint("please input your name!");
            loginListener.loginFailed(error);
            return;
        }

        if (TextUtils.isEmpty(password)) {
            LoginError error = new LoginError(LoginError.PASSWORD_EMPTY);
            error.setHint("please input your password!");
            loginListener.loginFailed(error);
            return;
        }
        //模拟登录成功
        if ("aaa".equals(name) && "123".equals(password)) {
            LoginUser user = new LoginUser(name,password);
            loginListener.loginSuccess(user);
        } else {
            LoginError error = new LoginError(LoginError.PASSWORD_ERROR);
            error.setHint("password is wrong,please input again!");
            loginListener.loginFailed(error);
        }
    }

    public LoginUser getLastLoginUser() {
        LoginUser user = new LoginUser("aaa","123");
        return user;
    }


    @Override
    public void destroy() {

    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public interface LoginListener {
        void loginSuccess(LoginUser user);

        void loginFailed(LoginError error);
    }
}
