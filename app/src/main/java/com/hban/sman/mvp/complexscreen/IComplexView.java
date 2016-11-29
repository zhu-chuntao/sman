package com.hban.sman.mvp.complexscreen;

import com.hban.sman.mvp.base.IView;
import com.hban.sman.mvp.data.LoginUser;

import java.util.List;

/**
 * Created by zhuchuntao on 16-11-22.
 */

public interface IComplexView extends IView {

    void setUserList(List<LoginUser> userList);

    void setLoginUser(LoginUser user);

}
