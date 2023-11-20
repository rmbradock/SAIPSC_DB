/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Modelo;

import java.sql.Date;

/**
 *
 * @author Batista
 */
    public class ModAluno {

        private int id;
        private int idPessoa;
        private int idCor;
        private String nascimento;
        private String idade;
        private String responsavel;
        private String uGrad;
        private String pGrad;
        private String faltas;
        private int idPolo;
        private String cpfResp;

    public ModAluno(int id, int idPessoa, int idCor, String nascimento, String idade, String responsavel, String uGrad, String pGrad, String faltas, int idPolo, String cpfResp){
        this.id = id;
        this.idPessoa = idPessoa;
        this.idCor = idCor;
        this.nascimento = nascimento;
        this.idade = idade;
        this.responsavel = responsavel;
        this.uGrad = uGrad;
        this.pGrad = pGrad;
        this.faltas = faltas;
        this.idPolo = idPolo;
        this.cpfResp = cpfResp;   
    }
    public ModAluno(){
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
    
    public int getIdCor() {
        return idCor;
    }

    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }
    
    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    
    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
    
    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
    public String getUGrad() {
        return uGrad;
    }

    public void setUGrad(String uGrad) {
        this.uGrad = uGrad;
    }
    
    public String getPGrad() {
        return pGrad;
    }

    public void setPGrad(String pGrad) {
        this.pGrad = pGrad;
    }
    
    public String getFaltas() {
        return faltas;
    }

    public void setFaltas(String faltas) {
        this.faltas = faltas;
    }
    
    public int getIdPolo() {
        return idPolo;
    }

    public void setIdPolo(int idPolo) {
        this.idPolo = idPolo;
    }
    
    public String getCpfResp() {
        return cpfResp;
    }

    public void setCpfResp(String cpfResp) {
        this.cpfResp = cpfResp;
    }
    @Override
    public String toString() {
        //id, idPessoa, idCor, nascimento, idade, responsavel, uGrad, pGrad, faltas,idPolo,cpfResp
        return "ModAluno{" + "id=" + id + ", idPessoa=" + idPessoa + ", idCor=" + idCor + ", nascimento=" + nascimento + ", idade=" + idade + ", responsavel=" + responsavel + ", uGrad=" + uGrad + ", faltas=" + faltas + ", idPolo=" + idPolo + ", cpfResp=" + cpfResp + '}';
    }
}
