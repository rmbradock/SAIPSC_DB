/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Modelo;

/**
 *
 * @author batista.4995
 */
public class ModCategoriaKF {
    private int id;
    private String nome;

    public ModCategoriaKF(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ModCategoriaKF() {
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

    @Override
    public String toString() {
        return "ModCategoriakf" + "id=" + id + ", nome=" + nome + '}';
    }
}