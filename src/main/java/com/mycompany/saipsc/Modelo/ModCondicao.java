/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Modelo;

/**
 *
 * @author batista.4995
 */
public class ModCondicao {
    private int id;
    private String estado;
    private String descricao;
//Alt + insert Constructor
    public ModCondicao() {
    }
//Alt + insert Construcot - selecionar todos
    public ModCondicao(int id, String estado, String descricao) {
        this.id = id;
        this.estado = estado;
        this.descricao = descricao;
    }
//alt + insert 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String toString() {
        return "ModCategoria{" + "id=" + id + ", estado=" + estado + ", descricao=" + descricao + '}';
    }
}
