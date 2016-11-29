package com.hban.sman.mvp.base;

/**
 * Created by zhuchuntao on 16-11-22.
 */

public class LoginError {

    //1:name is empty,2:password is empty 3:password is error 4:server error
    private int type;

    public static final int NAME_EMPTY = 1;

    public static final int PASSWORD_EMPTY = 2;

    public static final int PASSWORD_ERROR = 3;
    public static final int SERVER_ERROR = 4;

    //hint message;
    private String hint;

    public LoginError(int type) {
        this.type = type;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getType() {
        return type;
    }

    public String getHint() {
        return hint;
    }
}
