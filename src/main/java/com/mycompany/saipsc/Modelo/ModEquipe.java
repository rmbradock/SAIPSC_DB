/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Modelo;

import java.sql.Date;

/**
 *
 * @author batista.4995
 */
    public class ModEquipe {

        private int id;
        private int idPessoa;
        private int idCargo;
        private int idCor;
        private Date graduacao;
        private String salario;
        private int idAcesso;

        public ModEquipe(int id, int idPessoa, int idCargo, int idCor, Date graduacao, String salario, int idAcesso){
        this.id = id;
        this.idPessoa = idPessoa;
        this.idCargo = idCargo;
        this.idCor = idCor;
        this.graduacao = graduacao;
        this.salario = salario;
        this.idAcesso = idAcesso;
        }

    public ModEquipe(){
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

    public void setIdPessoa(int id) {
        this.idPessoa = idPessoa;
    }
    
    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public int getIdCor() {
        return idCor;
    }

    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }
    
    public Date getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Date graduacao) {
        this.graduacao = graduacao;
    }
    
    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
    
    public int getIdAcesso() {
        return idAcesso;
    }

    public void setIdAcesso(int idAcesso) {
        this.idAcesso = idAcesso;
    }
    
    @Override
    public String toString() {
        //int id, int idPessoa, int idCargo, int idCor, Date graduacao, String salario, int idAcesso
        return "ModAEquipe{" + "id=" + id + ", idPessoa=" + idPessoa + "idCargo=" + idCargo + ", idCor=" + idCor + ", graduacao=" + graduacao + ", salario=" + salario + ", idAcesso=" + idAcesso + '}';
    }
}