package com.hban.sman.mvp.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by zhuchuntao on 16-11-18.
 */

public abstract class MvpBaseActivity<T extends Ipresenter> extends Activity {


    private T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=createPresenter();
    }

    /**
     * 设置presenter,如果界面不需要,可以不用配置
     */
    public abstract T createPresenter();

    protected T getPresenter(){
        return presenter;
    }

}
