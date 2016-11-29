package com.hban.sman.mvpp.presenter;

import com.hban.sman.mvp.simplescreen.ILoginView;
import com.hban.sman.mvpp.base.EMvppDownPresenter;
import com.hban.sman.mvpp.model.LoginMvppModel;

/**
 * Created by zhuchuntao on 16-11-21.
 */

public class LoginMvppDownPresenter extends EMvppDownPresenter<ILoginView, LoginMvppModel, LoginMvppUpPresenter> implements ILoginDOWNpresenter {


    public LoginMvppDownPresenter(ILoginView iView) {
        super(iView);
    }

    @Override
    protected LoginMvppUpPresenter createUpPresenter() {
        return new LoginMvppUpPresenter();
    }

    @Override
    protected LoginMvppModel createModel() {
        return new LoginMvppModel();
    }

    public void login() {
        getModel().login();
    }

    @Override
    public void destroy() {
        super.destroy();
        //释放全局变量
    }

    @Override
    public void getPassword() {
        getModel().getPassword();
    }
}
