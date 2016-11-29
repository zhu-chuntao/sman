package com.hban.sman.mvpp.model;

import com.hban.sman.mvpp.base.EMvppModel;
import com.hban.sman.mvpp.base.IMvppModel;
import com.hban.sman.mvpp.presenter.ILoginDOWNpresenter;
import com.hban.sman.mvpp.presenter.ILoginUPpresenter;
import com.hban.sman.mvpp.presenter.LoginMvppUpPresenter;

/**
 * Created by zhuchuntao on 16-11-22.
 */

public class LoginMvppModel extends EMvppModel<LoginMvppUpPresenter> implements ILoginDOWNpresenter,ILoginUPpresenter {


    @Override
    public void destroy() {
        super.destroy();
    }


    public void login(){
        //开始访问网络数据，异步拿到数据之后，可以调用下边的函数
        getUpPresenter().displayData();
    }

    @Override
    public void getPassword() {
        passwordGetSuccess();
    }

    @Override
    public void passwordGetSuccess() {
        getUpPresenter().passwordGetSuccess();
    }
}
