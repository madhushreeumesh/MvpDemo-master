package com.example.hope.mvpdemo.project.network;

import android.util.Log;

import com.google.gson.JsonObject;

/**
 * Created by hope on 2/25/2018.
 */

public class ApiRequestParam {

    static ApiRequestParam apiRequestParam = null;
    private JsonObject respParamObj;

    private ApiRequestParam() {

    }

    public static ApiRequestParam getInstance() {
        if (apiRequestParam == null)
            return new ApiRequestParam();
        else
            return apiRequestParam;
    }

    public JsonObject reqLogin(String email, String password) {
        try {
            respParamObj = new JsonObject();
            if (!email.equalsIgnoreCase("")) respParamObj.addProperty("phone", email);
            if (!password.equalsIgnoreCase("")) respParamObj.addProperty("password", password);
            return respParamObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
