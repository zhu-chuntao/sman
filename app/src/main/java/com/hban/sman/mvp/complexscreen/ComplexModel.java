package com.hban.sman.mvp.complexscreen;

import com.hban.sman.mvp.base.EModel;
import com.hban.sman.mvp.complexscreen.model.IFirstModel;
import com.hban.sman.mvp.complexscreen.model.ISecondModel;
import com.hban.sman.mvp.data.LoginUser;
import com.hban.sman.mvp.http.HttpCallback;
import com.hban.sman.mvp.simulation.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuchuntao on 16-11-22.
 */

public class ComplexModel extends EModel<ComplexPresenter> implements IFirstModel, ISecondModel, HttpUtil.CallBack<HttpCallback> {


    public ComplexModel(ComplexPresenter presenter) {
        super(presenter);
    }

    @Override
    public void destroy() {
        //暂时没有全局变量，如果有，记得在这里释放

    }

    @Override
    public void getUserList() {
        HttpUtil.sendRequest(1, this);
    }

    @Override
    public void getLoginUser() {
        HttpUtil.sendRequest(2, this);
    }


    @Override
    public void requestSuccess(HttpCallback response) {
        switch (response.getCallbackType()) {
            case 1:
                ArrayList<LoginUser> list= new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    LoginUser user = new LoginUser("Login user:last "+i, " he's passowrd is test");
                    list.add(user);
                }
                getPresenter().getListSuccess(list);
                break;
            case 2:
                LoginUser user = new LoginUser("Login user:test", " he's passowrd is test");
                getPresenter().getLoginUser(user);
                break;
            default:
                break;
        }
    }


}
