package com.hban.sman.mvp.base;


/**此类是Presenter层的基类，作用是保存每一个view和model的引用
 * Created by zhuchuntao on 16-11-22.
 */

public abstract class EPresenter<T extends IView, V extends IModel> {

    private V iModel;
    private T iView;

    public EPresenter(T iView){
        this.iView = iView;
        iModel=createModel();
    }


    protected V getModel() {
        return iModel;
    }

    protected T getView() {
        return iView;
    }

    public void destroy(){
        destroySelf();
        iModel.destroy();
        iView=null;
        iModel=null;
    }

    protected abstract V createModel();

    protected abstract void destroySelf();





}
