package com.example.boombz.myapplication.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by boombz on 27/09/16.
 */
public class Cidade {


    @SerializedName("Nome")
    private String nome;

    @SerializedName("id")
    private Integer id;

    @SerializedName("id_distrito")
    private Integer idDistrito;

    @SerializedName("distrito")
    private Distrito distrito;

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

    /**
     *
     * @return
     * The distrito
     */
    public Distrito getDistrito() {
        return distrito;
    }

    /**
     *
     * @param distrito
     * The distrito
     */
    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", distrito=" + distrito.toString() +
                '}';
    }
}
