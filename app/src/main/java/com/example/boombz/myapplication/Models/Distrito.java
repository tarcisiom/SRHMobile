package com.example.boombz.myapplication.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by boombz on 27/09/16.
 */
public class Distrito {

    @SerializedName("Nome")
    private String nome;

    @SerializedName("id")
    private Integer id;

    @SerializedName("aviso")
    private Aviso aviso;

    /**
     *
     * @return
     * The nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     * The Nome
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * The aviso
     */
    public Aviso getAviso() {
        return aviso;
    }

    /**
     *
     * @param aviso
     * The aviso
     */
    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    @Override
    public String toString() {
        return "Distrito{" +
                "nome='" + nome + '\'' +
                ", aviso=" + aviso.toString() +
                '}';
    }
}
