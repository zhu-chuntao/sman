package com.hban.sman.mvp.complexscreen;

import com.hban.sman.mvp.base.EPresenter;
import com.hban.sman.mvp.complexscreen.presenter.IFirstPresenter;
import com.hban.sman.mvp.complexscreen.presenter.ISecondPresenter;
import com.hban.sman.mvp.data.LoginUser;

import java.util.List;

/**
 * Created by zhuchuntao on 16-11-21.
 */

public class ComplexPresenter extends EPresenter<IComplexView, ComplexModel> implements IFirstPresenter, ISecondPresenter {


    public ComplexPresenter(IComplexView iView) {
        super(iView);
    }

    @Override
    protected ComplexModel createModel() {
        return new ComplexModel(this);
    }

    @Override
    protected void destroySelf() {
        //暂时没有全局变量，如果有，记得在这里释放
    }

    @Override
    public void sendRequestList() {
        getModel().getUserList();
    }

    @Override
    public void getListSuccess(List<LoginUser> userList) {
        getView().setUserList(userList);
    }


    @Override
    public void sendRequestLoginUser() {
        getModel().getLoginUser();
    }

    @Override
    public void getLoginUser(LoginUser user) {
        getView().setLoginUser(user);
    }
}
