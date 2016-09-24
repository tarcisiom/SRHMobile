package com.example.boombz.myapplication.Service;

import com.example.boombz.myapplication.Models.User;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by boombz on 23/09/16.
 */
public interface UserService {


    @GET("Users/{id}")
    Call<User> getUser(@Path("id") int userId);

    /**
     * Remote Call used to get the current user
     * @return A Call representing the remote procedure that retrieves the Guest object of the current user
     */
    @GET("Users/me")
    Call<User> getCurrentUser();

    @GET("Users/")
    Call<List<User>> getUsers();

}
