package com.example.boombz.myapplication.Alertas;

import com.example.boombz.myapplication.Models.Estrada;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boombz on 23/09/16.
 */
public class EstradasResponse {

    private List<Estrada> estradas;



    public EstradasResponse(){
        estradas = new ArrayList<Estrada>();

    }

    public static EstradasResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        EstradasResponse EstradasResponse = gson.fromJson(response, EstradasResponse.class);
        return EstradasResponse;
    }

}
