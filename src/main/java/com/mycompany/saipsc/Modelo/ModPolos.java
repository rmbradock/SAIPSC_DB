/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Modelo;

/**
 *
 * @author batista.4995
 */
public class ModPolos {
    private int id;
    private String nome, endereco, responsavel, contato;
    
    public ModPolos(){
    }
    
    public ModPolos (int id, String nome, String endereco, String responsavel, String contato){
    this.id = id;
    this.nome = nome;
    this.endereco = endereco;
    this.responsavel = responsavel;
    this.contato = contato;
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
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
    @Override
    public String toString() {
        return "ModPessoa{" + "id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", responsavel=" + responsavel + " contato=" + contato + '}';
    }
}
