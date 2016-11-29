package com.hban.sman.mvpp.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by zhuchuntao on 16-11-18.
 */

public abstract class MvppBaseActivity<T extends EMvppDownPresenter> extends Activity {


    private T downPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        downPresenter=createDownPresenter();
    }

    /**
     * 设置presenter,如果界面不需要,可以不用配置
     */
    public abstract T createDownPresenter();

    protected T getDownPresenter(){
        return downPresenter;
    }

}
