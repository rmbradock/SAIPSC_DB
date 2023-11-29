/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Modelo;

/**
 *
 * @author batista.4995
 */
public class ModUniforme {
    
    private int id;
    private String quantidade;
    private int idCategoria;
    private int idTamanho;
    private int idCor;
    private int idMarca;
    private int idCondicao;
    
    public ModUniforme (int id, String quantidade, int idCategoria, int idTamanho, int idCor, int idMarca, int idCondicao){
    this.id = id;
    this.quantidade = quantidade;
    this.idCategoria = idCategoria;
    this.idTamanho = idTamanho;
    this.idCor = idCor;
    this.idMarca = idMarca;
    this.idCondicao = idCondicao;
    }
    public ModUniforme (){
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public int getIdTamanho() {
        return idTamanho;
    }

    public void setIdTamanho(int idTamanho) {
        this.idTamanho = idTamanho;
    }
    
    public int getIdCor() {
        return idCor;
    }

    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }
    
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    
    public int getIdCondicao() {
        return idCondicao;
    }

    public void setIdCondicao(int idCondicao) {
        this.idCondicao = idCondicao;
    }
    @Override
    public String toString() {
        //int id, String quantidade, int idCategoria, int idTamanho, int idCor, int idMarca, int idCondicao
        return "ModAluno{" + "id=" + id + ", quantidade=" + quantidade + ", idCategoria=" + idCategoria + ", idTamanho=" + idTamanho + ", idCor=" + idCor + ", idMarca=" + idMarca + ", idCondicao=" + idCondicao + '}';
    }
}
