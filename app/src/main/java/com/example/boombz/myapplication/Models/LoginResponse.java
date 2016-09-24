package com.example.boombz.myapplication.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by boombz on 23/09/16.
 */
public class LoginResponse {


    @SerializedName("id")
    private String accessToken;

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
