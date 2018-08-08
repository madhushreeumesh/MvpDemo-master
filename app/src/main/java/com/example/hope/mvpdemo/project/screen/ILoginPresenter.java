package com.example.hope.mvpdemo.project.screen;

/**
 * Created by hope on 2/22/2018.
 */

public interface ILoginPresenter {

    boolean validate(String name ,String pass);
    void callLoginApi(String name ,String pass);

}
