package com.example.boombz.myapplication.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by boombz on 23/09/16.
 */
public class Estrada implements Serializable{



    @SerializedName("Tipo")
    @Expose
    private String tipo;
    @SerializedName("Estrada")
    @Expose
    private String estrada;
    @SerializedName("Concelho")
    @Expose
    private String concelho;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lon")
    @Expose
    private String lon;
    @SerializedName("Data")
    @Expose
    private String data;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_distrito")
    @Expose
    private Integer idDistrito;


    public Estrada(String tipo, String estrada, String concelho, String lat, String lon, String data, Integer id, Integer idDistrito) {
        this.tipo = tipo;
        this.estrada = estrada;
        this.concelho = concelho;
        this.lat = lat;
        this.lon = lon;
        this.data = data;
        this.id = id;
        this.idDistrito = idDistrito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstrada() {
        return estrada;
    }

    public void setEstrada(String estrada) {
        this.estrada = estrada;
    }

    public String getConcelho() {
        return concelho;
    }

    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }
}
