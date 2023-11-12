/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Modelo;

/**
 *
 * @author batista.4995
 */
public class ModPessoa {
    private int id;
    private String nome, rg, cpf, endereco, contato, obs, genero, usuario, senha;
    
    public ModPessoa(){
    }
    
    public ModPessoa (int id, String nome, String rg, String cpf, String endereco, String contato, String obs, String genero, String usuario, String senha){
    this.id = id;
    this.nome = nome;
    this.rg = rg;
    this.cpf = cpf;
    this.endereco = endereco;
    this.contato = contato;
    this.obs = obs;
    this.genero = genero;
    this.usuario = usuario;
    this.senha = senha;
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
    
    public String getRG() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    @Override
    public String toString() {
        return "ModPessoa{" + "id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", endereco=" + endereco + ", contato=" + contato + ", obs=" + obs + ", genero=" + genero + ", usuario=" + usuario + ", senha=" + senha + '}';
    }
}
