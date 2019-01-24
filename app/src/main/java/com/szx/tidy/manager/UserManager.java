package com.szx.tidy.manager;

import com.mob.ums.User;

public class UserManager {
    private static UserManager instance = null;

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public static final int NOT_LOGIN = -1; // 未登录
    public static final int LOGIN_SUCCESS = 0; // 登录成功
    public static final int LOGIN_MISTAKE = 1; // 用户名或密码错误
    public static final int LOGIN_FAIL = 2; // 登录失败（其它原因）
    private int isLogin = NOT_LOGIN; // -1:未登录，0：登录成功，1：用户名或密码错误，2：登录失败（其它原因）

    User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public boolean isLogin() {
        return isLogin == 0;
    }

    public int getIsLogin() {
        return isLogin;
    }

    public void setLogin(int isLogin) {
        this.isLogin = isLogin;
    }


}
