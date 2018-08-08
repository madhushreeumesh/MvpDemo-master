package com.example.hope.mvpdemo.project;

import android.app.Application;
import android.content.Context;

import com.example.hope.mvpdemo.project.apipresenter.RestApi;
import com.example.hope.mvpdemo.project.network.ApiConstants;
import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by hope on 2/23/2018.
 */

public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();

    public static AppController mInstance;
    public static Context context;
    public RestApi service;
    public ArrayList<String> list_state = new ArrayList<String>();
    public ArrayList<String> list_town = new ArrayList<String>();
    public String json = null;

    @Override
    public void onCreate() {
        super.onCreate();
        //ActiveAndroid

        mInstance = this;
        context = this;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(getRequestHeader())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        service = retrofit.create(RestApi.class);

    }
    private OkHttpClient getRequestHeader() {
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setConnectTimeout(60, TimeUnit.SECONDS);
        httpClient.setReadTimeout(30, TimeUnit.SECONDS);
        return httpClient;
    }



    public static synchronized AppController getInstance() {

        return mInstance;
    }

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    private static boolean activityVisible;

}
