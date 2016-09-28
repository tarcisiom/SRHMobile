package com.example.boombz.myapplication.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by boombz on 27/09/16.
 */
public class Temperatura {

    @SerializedName("Descricao")
    private String descricao;

    @SerializedName("Chuva")
    private String chuva;

    @SerializedName("Temperatura")
    private String temperatura;

    @SerializedName("Humidade")
    private String humidade;

    @SerializedName("Vento")
    private String vento;

    @SerializedName("id")
    private Integer id;

    @SerializedName("id_cidade")
    private Integer idCidade;

    @SerializedName("cidade")
    private Cidade cidade;

    /**
     *
     * @return
     * The descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     * The Descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     * The chuva
     */
    public String getChuva() {
        return chuva;
    }

    /**
     *
     * @param chuva
     * The Chuva
     */
    public void setChuva(String chuva) {
        this.chuva = chuva;
    }

    /**
     *
     * @return
     * The temperatura
     */
    public String getTemperatura() {
        return temperatura;
    }

    /**
     *
     * @param temperatura
     * The Temperatura
     */
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    /**
     *
     * @return
     * The humidade
     */
    public String getHumidade() {
        return humidade;
    }

    /**
     *
     * @param humidade
     * The Humidade
     */
    public void setHumidade(String humidade) {
        this.humidade = humidade;
    }

    /**
     *
     * @return
     * The vento
     */
    public String getVento() {
        return vento;
    }

    /**
     *
     * @param vento
     * The Vento
     */
    public void setVento(String vento) {
        this.vento = vento;
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
     * The idCidade
     */
    public Integer getIdCidade() {
        return idCidade;
    }

    /**
     *
     * @param idCidade
     * The id_cidade
     */
    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    /**
     *
     * @return
     * The cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     *
     * @param cidade
     * The cidade
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Temperatura{" +
                "descricao='" + descricao + '\'' +
                ", temperatura='" + temperatura + '\'' +
                ", cidade=" + cidade.toString() +
                '}';
    }
}
