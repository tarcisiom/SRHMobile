package com.example.boombz.myapplication.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by boombz on 27/09/16.
 */
public class Aviso {

    @SerializedName("Cor")
    private String cor;

    @SerializedName("id")
    private Integer id;

    @SerializedName("id_distrito")
    private Integer idDistrito;

    /**
     *
     * @return
     * The cor
     */
    public String getCor() {
        return cor;
    }

    /**
     *
     * @param cor
     * The Cor
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The idDistrito
     */
    public Integer getIdDistrito() {
        return idDistrito;
    }

    /**
     *
     * @param idDistrito
     * The id_distrito
     */
    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    @Override
    public String toString() {
        return "Aviso{" +
                "cor='" + cor + '\'' +
                '}';
    }
}
