/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Modelo;

/**
 *
 * @author batista.4995
 */
public class ModPatrimonio {
    private int id;
    private String material;
    private String quantidade;
    private String situacao;
    private String descricao;

    public ModPatrimonio(){
    }
    
    public ModPatrimonio (int id, String material, String quantidade, String situacao, String descricao){
        this.id = id;
        this.material = material;
        this.quantidade = quantidade;
        this.situacao = situacao;
        this.descricao = descricao;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String toString() {
        return "ModPatrimonio{" + "id=" + id + ", material=" + material + ", quantidade=" + quantidade + ", situacao=" + situacao + ", descricao=" + descricao + '}';
    }
}
