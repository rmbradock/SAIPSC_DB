/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Modelo;

/**
 *
 * @author batista.4995
 */
public class ModTamanho {
    private int id;
    private String nome;
    private String descricao;

    public ModTamanho() {
    }

    public ModTamanho(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String toString() {
        return "ModTamanho{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
}