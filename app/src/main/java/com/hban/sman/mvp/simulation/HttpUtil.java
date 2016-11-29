package com.hban.sman.mvp.simulation;

import com.hban.sman.mvp.http.HttpCallback;

/** 这是一个模拟类，来模拟网络请求以及数据返回的过程
 * Created by zhuchuntao on 16-11-23.
 */

public class HttpUtil {

    public static void sendRequest(int type,CallBack callBack) {
        HttpCallback callback=new HttpCallback(type);
        callback.setResponse("requestSuccess");
        callBack.requestSuccess(callback);
    }

    public interface CallBack<HttpCallback> {
        void requestSuccess(HttpCallback response);
    }
}
