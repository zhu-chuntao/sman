package com.hban.sman.mvpp.presenter;

import com.hban.sman.mvp.simplescreen.ILoginView;
import com.hban.sman.mvpp.base.EMvppUpPresenter;

/**
 * Created by zhuchuntao on 16-11-21.
 */

public class LoginMvppUpPresenter extends EMvppUpPresenter<ILoginView> implements ILoginUPpresenter{

    @Override
    public void destroy() {
        super.destroy();
    }

    public void displayData() {
        getView().gotoNextPage();
    }


    @Override
    public void passwordGetSuccess() {
        getView().showHint("password get success");
    }
}
