package com.hban.sman.mvpp.base;


import com.hban.sman.mvp.base.IView;

/**
 * 此类是Presenter层的基类，作用是保存每一个view和model的引用
 * Created by zhuchuntao on 16-11-22.
 */

public abstract class EMvppDownPresenter<T extends IView, V extends EMvppModel, S extends EMvppUpPresenter>{

    private V iModel;
    private T iView;
    private S iUpPresenter;

    public EMvppDownPresenter(T iView) {
        this.iView = iView;
        this.iUpPresenter = createUpPresenter();
        iUpPresenter.setiView(iView);
        iModel = createModel();
        iModel.setPresenter(iUpPresenter);
    }


    protected final V getModel() {
        return iModel;
    }

    public void destroy() {
        iModel.destroy();
        iUpPresenter.destroy();
        iView = null;
        iModel = null;
        iUpPresenter=null;
    }

    protected abstract S createUpPresenter();

    protected abstract V createModel();


}
