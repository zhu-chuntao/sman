package com.hban.sman.mvp.complexscreen.presenter;

import com.hban.sman.mvp.base.Ipresenter;
import com.hban.sman.mvp.data.LoginUser;

import java.util.List;

/**
 * Created by zhuchuntao on 16-11-23.
 */

public interface IFirstPresenter extends Ipresenter {
    void sendRequestList();

    void getListSuccess(List<LoginUser> userList);
}
