/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Modelo;

/**
 *
 * @author batista.4995
 */
public class ModCampeonato {
    private int id;
    private String nome;
    private String local;
    private String responsavel;
    private String contato;
    private String data;
    private String inscricao;
    
//Alt + insert Constructor
    public ModCampeonato() {
    }
//Alt + insert Construcot - selecionar todos
    public ModCampeonato(int id, String nome, String local, String responsavel, String contato, String data, String inscricao) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.responsavel = responsavel;
        this.contato = contato;
        this.data = data;
        this.inscricao = inscricao;
    }
//alt + insert 
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
     public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }
    @Override
    public String toString() {
        return "ModCampeonato{" + "id=" + id + ", nome=" + nome + ", local=" + local + "responsavel=" + responsavel + "contato=" + contato + "data=" + data + "inscricao=" + inscricao + '}';
    }
}
