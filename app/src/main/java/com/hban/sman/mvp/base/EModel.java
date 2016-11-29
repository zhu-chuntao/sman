package com.hban.sman.mvp.base;

/**此类是model层的基类，作用是保存每一个model对presenter的引用，避免使用回调的方式
 * Created by zhuchuntao on 16-11-23.
 */

public abstract class EModel<T extends Ipresenter> {
    private T presenter;

    /**
     * 实例化时，就保存一个presenter的引用
     * @param presenter
     */
    public EModel(T presenter) {
        this.presenter = presenter;
    }

    public T getPresenter() {
        return presenter;
    }
}
