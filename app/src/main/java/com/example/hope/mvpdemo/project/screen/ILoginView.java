package com.example.hope.mvpdemo.project.screen;

import com.example.hope.mvpdemo.project.screen.model.LoginResponse;

/**
 * Created by hope on 2/22/2018.
 */

public interface ILoginView {

    void init();
    void errMsg(String str);
    void submitLogin();
    void setLoginRes(LoginResponse loginRes);
    void showProgress();
    void hideProgress();
}
