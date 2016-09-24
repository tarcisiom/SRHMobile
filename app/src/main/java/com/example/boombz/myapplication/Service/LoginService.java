package com.example.boombz.myapplication.Service;

import com.example.boombz.myapplication.Models.LoginRequest;
import com.example.boombz.myapplication.Models.LoginResponse;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Path;


/**
 * Created by boombz on 23/09/16.
 */
public interface LoginService {

    @POST("Users/login")
    Call<LoginResponse> login(@Body LoginRequest credentials);

    @POST("Users")
    Call<LoginResponse> registration(@Path("email") String email, @Path("password") String password);

}
