package com.example.boombz.myapplication.Service;

import com.example.boombz.myapplication.Models.Estrada;
import com.example.boombz.myapplication.Models.EstradasResponse;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by boombz on 23/09/16.
 */
public interface EstradasService {


    @GET("Estradas")
    Call<List<Estrada>> listEstradas();
}
