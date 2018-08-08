package com.example.hope.mvpdemo.project.screen;

import com.example.hope.mvpdemo.project.AppController;
import com.example.hope.mvpdemo.project.apipresenter.ApiResponsePresenter;
import com.example.hope.mvpdemo.project.commoninterface.IRequestInterface;
import com.example.hope.mvpdemo.project.commoninterface.IResponseInterface;
import com.example.hope.mvpdemo.project.network.ApiRequestParam;
import com.example.hope.mvpdemo.project.network.ApiRequestTypes;
import com.example.hope.mvpdemo.project.screen.model.LoginResponse;
import com.example.hope.mvpdemo.project.util.StringUtil;

import retrofit.Response;

/**
 * Created by hope on 2/22/2018.
 */

public class LoginPresenter implements ILoginPresenter, IResponseInterface {

    ILoginView loginView;
    IRequestInterface requestInterface;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        requestInterface = new ApiResponsePresenter(this);
    }

    @Override
    public boolean validate(String name, String pass) {
        if (!StringUtil.isValidString(name)) {
            loginView.errMsg("not a valid name");
            return false;
        }

        if (!StringUtil.isValidString(pass)) {
            loginView.errMsg("not a valid pass");
            return false;
        }

        return true;
    }

    @Override
    public void callLoginApi(String name, String pass) {
        requestInterface.callApi(AppController.getInstance().service.getLoginRes(ApiRequestParam.getInstance().reqLogin(name, pass)), ApiRequestTypes.LOGIN);
    }

    @Override
    public void onResponseSuccess(Response response, String reqType) {
        loginView.hideProgress();
        if (response.isSuccess()) {
            if (reqType.equals(ApiRequestTypes.LOGIN)) {
                LoginResponse loginResponse = (LoginResponse) response.body();
                loginView.setLoginRes(loginResponse);
            }
        } else
            loginView.errMsg("something went wrong");
    }

    @Override
    public void onResponseFailure(String responseError) {
        loginView.hideProgress();
        loginView.errMsg(responseError);
    }
}
