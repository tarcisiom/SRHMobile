package com.example.boombz.myapplication.Service;

import com.example.boombz.myapplication.Models.Estrada;
import com.example.boombz.myapplication.Models.Temperatura;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by boombz on 27/09/16.
 */
public interface TemperaturasService {


    @GET("Temperaturas?filter=%7B\"include\"%3A%20%7B\"relation\"%3A\"cidade\"%2C\"scope\"%3A%7B\"include\"%3A%7B\"relation\"%3A\"distrito\"%2C\"scope\"%3A%7B\"include\"%3A%7B\"relation\"%3A\"aviso\"%7D%7D%7D%7D%7D%7D")
    Call<List<Temperatura>> listTemperaturas();
}
