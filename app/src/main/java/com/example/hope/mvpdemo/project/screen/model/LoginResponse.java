package com.example.hope.mvpdemo.project.screen.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hope on 2/22/2018.
 */

public class LoginResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("needslogin")
    @Expose
    private String needslogin;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNeedslogin() {
        return needslogin;
    }

    public void setNeedslogin(String needslogin) {
        this.needslogin = needslogin;
    }

}
