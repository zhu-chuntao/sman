package com.hban.sman.mvp.http;

/**
 * Created by zhuchuntao on 16-11-23.
 */

public class HttpCallback<T> {
    private int callbackType;
    private T response;

    public HttpCallback(int callbackType) {
        this.callbackType = callbackType;
    }

    public int getCallbackType() {
        return callbackType;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
