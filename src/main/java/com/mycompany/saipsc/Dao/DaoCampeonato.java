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
public class DaoCampeonato extends BancoDeDadosMySql{
    
    String sql;
    
    public Boolean inserir(int id, String nome, String local, String responsavel, String contato, Date data, String inscricao){
        try{
            sql = "INSERT INTO CAMPEONATO (ID, NOME, LOCAL, RESPONSAVEL, CONTATO, DATA, INSCRICAO) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, nome);
            getStatement().setString(3, local);
            getStatement().setString(4, responsavel);
            getStatement().setString(5, contato);
            getStatement().setDate(6, data);
            getStatement().setString(7, inscricao);            
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar(int id, String nome, String local, String responsavel, String contato, Date data, String inscricao){
        try{
            sql = "UPDATE CAMPEONATO SET NOME = ?, LOCAL = ?, RESPONSAVEL = ?, CONTATO = ?, DATA = ?, INSCRICAO? = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(7, id);
            getStatement().setString(1, nome);
            getStatement().setString(2, local);
            getStatement().setString(3, responsavel);
            getStatement().setString(4, contato);
            getStatement().setDate(5, data);
            getStatement().setString(6, inscricao);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM CAMPEONATO WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public ResultSet listarTodos(){
        try{
            sql = " SELECT ID, NOME, LOCAL, RESPONSAVEL, CONTATO, DATA, INSCRICAO   FROM CAMPEONATO";
                
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, '') FROM CAMPEONATO WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    public ResultSet listarPorNome(String nome){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, '') FROM CAMPEONATO WHERE NOME LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    public ResultSet listarPorDescricao(String descricao){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, '') FROM CAMPEONATO WHERE DESCRICAO LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, descricao + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    public ResultSet listarPorLocal(String local){
        try{
            sql = "SELECT ID, NOME, IFNULL(LOCAL, '') FROM CAMPEONATO WHERE LOCAL LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, local + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    public ResultSet listarPorData(String data){
        try{
            sql = "SELECT ID, NOME, IFNULL(DATA, '') FROM CAMPEONATO WHERE DATA LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, data + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return getResultado();
    }
    public int buscarProximoId(){
           int id = -1;

           try{
               sql = "SELECT MAX(ID) + 1 FROM CAMPEONATO";

               setStatement(getConexao().prepareStatement(sql));

               setResultado(getStatement().executeQuery());

               getResultado().next(); 

               id = getResultado().getInt(1); 
           }catch(Exception e){
               System.out.println(e.getMessage());
        }
        return id;
    }
}
