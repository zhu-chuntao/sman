package com.hban.sman.mvp.simplescreen;

import com.hban.sman.mvp.base.IView;
import com.hban.sman.mvp.data.LoginUser;

/**
 * Created by zhuchuntao on 16-11-22.
 */

public interface ILoginView extends IView {

    void emptyPassword();

    void setData(LoginUser user);

    void gotoNextPage();
}
