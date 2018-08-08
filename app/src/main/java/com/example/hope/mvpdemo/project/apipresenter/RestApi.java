package com.example.hope.mvpdemo.project.apipresenter;


import com.example.hope.mvpdemo.project.network.ApiConstants;
import com.example.hope.mvpdemo.project.screen.model.LoginResponse;
import com.google.gson.JsonObject;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

public interface RestApi {
    @POST(ApiConstants.LOGIN)
    Call<LoginResponse> getLoginRes(@Body JsonObject jObj);
}
