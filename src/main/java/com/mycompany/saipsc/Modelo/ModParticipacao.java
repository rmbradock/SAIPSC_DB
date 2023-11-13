/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Modelo;

/**
 *
 * @author batista.4995
 */
    public class ModParticipacao {
    
        private int id;
        private int idAluno;
        private int idCampeonato;
        private String resultado;
        
        public ModParticipacao (int id, int idAluno, int idCampeonato, String resultado){
        this.id = id;
        this.idAluno = idAluno;
        this.idCampeonato = idCampeonato;
        this.resultado = resultado;
    }
    public ModParticipacao(){
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    
    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }
    
    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    @Override
    public String toString() {
        return "ModParticipacao{" + "id=" + id + ", idAluno=" + idAluno + ", idCampeonato=" + idCampeonato + ", resultado=" + resultado + '}';
    }
}
