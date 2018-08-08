package com.example.hope.mvpdemo.project.commoninterface;

import retrofit.Response;


public interface IResponseInterface {

    void onResponseSuccess(Response response, String reqType);

    void onResponseFailure(String responseError);

}
