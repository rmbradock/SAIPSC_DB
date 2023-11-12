/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Modelo;

/**
 *
 * @author batista.4995
 */
public class ModInvestidores {
    private int id;
    private int idPessoa;
    private String obs;
    private String investimento;
    private String periodicidade;

    public ModInvestidores(int id, int idPessoa, String obs, String investimento, String periodicidade){
    }
    public ModInvestidores(){
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    public String getInvestimento() {
        return investimento;
    }

    public void setInvestimento(String investimento) {
        this.investimento = investimento;
    }
    
    
    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeridodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }
    @Override
    public String toString() {
        return "ModInvestidores{" + "id=" + id + ", idPessoa=" + idPessoa + ", obs=" + obs + ", investimento=" +  investimento + ", periodicidade=" +  periodicidade + '}';
    }
}
