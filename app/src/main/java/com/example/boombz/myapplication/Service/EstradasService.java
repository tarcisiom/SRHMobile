package com.example.boombz.myapplication.Service;

import com.example.boombz.myapplication.Alertas.EstradasResponse;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by boombz on 23/09/16.
 */
public interface EstradasService {


    @GET("Estradas")
    Call<EstradasResponse> listEstradas();
}
