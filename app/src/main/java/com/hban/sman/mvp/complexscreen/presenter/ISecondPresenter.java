package com.hban.sman.mvp.complexscreen.presenter;

import com.hban.sman.mvp.base.Ipresenter;
import com.hban.sman.mvp.data.LoginUser;

/**
 * Created by zhuchuntao on 16-11-23.
 */

public interface ISecondPresenter extends Ipresenter {

    void sendRequestLoginUser();
    void getLoginUser(LoginUser user);
}
