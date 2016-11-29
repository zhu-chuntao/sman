package com.hban.sman.mvpp.base;

/**此类是model层的基类，作用是保存每一个model对presenter的引用，避免使用回调的方式
 * Created by zhuchuntao on 16-11-23.
 */

public abstract class EMvppModel<T extends EMvppUpPresenter> {
    private T presenter;

    public T getUpPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    public void destroy(){
        this.presenter=null;
    }
}
