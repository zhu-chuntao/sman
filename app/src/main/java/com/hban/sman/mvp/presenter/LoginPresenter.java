package com.hban.sman.mvp.presenter;

import com.hban.sman.mvp.base.EPresenter;
import com.hban.sman.mvp.base.Ipresenter;
import com.hban.sman.mvp.base.LoginError;
import com.hban.sman.mvp.data.LoginUser;
import com.hban.sman.mvp.model.LoginModel;
import com.hban.sman.mvp.simplescreen.ILoginView;

/**
 * Created by zhuchuntao on 16-11-21.
 */

public class LoginPresenter extends EPresenter<ILoginView, LoginModel> implements Ipresenter, LoginModel.LoginListener {


    public LoginPresenter(ILoginView iView) {
        super(iView);
    }

    @Override
    protected LoginModel createModel() {
        return new LoginModel(this);
    }

    @Override
    protected void destroySelf() {

    }

    public void login(String name, String password) {
        getModel().setLoginListener(this);
        getModel().login(name, password);
    }

    public void getLastLogin() {
        LoginUser user = getModel().getLastLoginUser();
        getView().setData(user);
    }

    @Override
    public void loginSuccess(LoginUser user) {
        getView().showHint("login success!");
        getView().gotoNextPage();
    }

    @Override
    public void loginFailed(LoginError error) {
        getView().showHint(error.getHint());
        switch (error.getType()) {
            case LoginError.NAME_EMPTY:
                break;
            case LoginError.PASSWORD_EMPTY:
                break;
            case LoginError.PASSWORD_ERROR:
                getView().emptyPassword();
                break;
            case LoginError.SERVER_ERROR:
                break;
        }
    }


}
