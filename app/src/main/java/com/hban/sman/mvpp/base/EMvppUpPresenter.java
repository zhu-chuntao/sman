package com.hban.sman.mvpp.base;


import com.hban.sman.mvp.base.IView;

/**此类是Presenter层的基类，作用是保存每一个view和model的引用
 * Created by zhuchuntao on 16-11-22.
 */

public abstract class EMvppUpPresenter<T extends IView> {

    private T iView;

    public EMvppUpPresenter(){
    }

    public void setiView(T iView) {
        this.iView = iView;
    }

    protected T getView() {
        return iView;
    }

    public void destroy(){
        iView=null;
    }
}
