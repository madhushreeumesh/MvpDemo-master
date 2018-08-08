package com.example.hope.mvpdemo.project.commoninterface;

import retrofit.Call;

/**
 * Created by Teja on 30 May, 2017
 * Fugenx Technologies, Bengaluru
 * HRMS
 * Version 1.0
 */

public interface IRequestInterface {

    void callApi(Call call, final String reqType);
}
