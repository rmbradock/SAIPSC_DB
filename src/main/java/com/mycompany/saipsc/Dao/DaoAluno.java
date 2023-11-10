/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Dao;

import com.mycompany.saipsc.ferramentas.BancoDeDadosMySql;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author batista.4995
 */
public class DaoAluno extends BancoDeDadosMySql{
    String sql;
    
    public Boolean inserir(int id, int idPessoa, int idCor, Date nascimento, String idade, String responsavel, Date uGrad, Date pGrad, String faltas, int idPolo, String cpfResp){
        try{
            sql = "INSERT INTO ALUNO (ID, ID_PESSOA, ID_COR, NASCIMENTO, IDADE, RESPONSAVEL, UGRAD, PGRAD, FALTAS, ID_POLO, CPFRESP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idPessoa);
            getStatement().setInt(3, idCor);
            getStatement().setDate(4, nascimento);
            getStatement().setString(5, idade);
            getStatement().setString(6, responsavel);
            getStatement().setDate(7, uGrad);
            getStatement().setDate(8, pGrad);
            getStatement().setString(9, faltas);
            getStatement().setInt(10,idPolo );
            getStatement().setString(11,cpfResp );
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar(int id, int idPessoa, int idCor, Date nascimento, String idade, String responsavel, Date uGrad, Date pGrad, String faltas, int idPolo, String cpfResp){
        try{
            sql = "UPDATE ALUNO SET ID_PESSOA = ?, ID_COR = ?, NASCIMENTO = ?, IDADE = ?, RESPONSAVEL = ?, UGRAD = ?, PGRAD = ?, FALTAS = ?, ID_POLO = ?, CPFRESP = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(11, id);
            getStatement().setInt(1, idPessoa);
            getStatement().setInt(2, idCor);
            getStatement().setDate(3, nascimento);
            getStatement().setString(4, idade);
            getStatement().setString(5, responsavel);
            getStatement().setDate(6, uGrad);
            getStatement().setDate(7, pGrad);
            getStatement().setString(8, faltas);
            getStatement().setInt(9,idPolo );
            getStatement().setString(10,cpfResp );
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM ALUNO WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
