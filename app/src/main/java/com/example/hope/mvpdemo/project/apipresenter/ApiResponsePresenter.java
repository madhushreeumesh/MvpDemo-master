package com.example.hope.mvpdemo.project.apipresenter;


import com.example.hope.mvpdemo.project.commoninterface.IRequestInterface;
import com.example.hope.mvpdemo.project.commoninterface.IResponseInterface;

import java.net.ConnectException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ApiResponsePresenter implements IRequestInterface {

    public IResponseInterface iResponseInterface;

    public ApiResponsePresenter(IResponseInterface iResponseInterface) {
        this.iResponseInterface = iResponseInterface;
    }
    @Override
    public void callApi(final Call call, final String reqType) {
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Response response, Retrofit retrofit) {
                iResponseInterface.onResponseSuccess(response, reqType);
            }

            @Override
            public void onFailure(Throwable throwable) {
                if (throwable instanceof ConnectException) {
                    iResponseInterface.onResponseFailure("No Internet Connection");
                } else {
                    throwable.printStackTrace();
                    iResponseInterface.onResponseFailure("Response Failed");
                }
            }
        });
    }
}
