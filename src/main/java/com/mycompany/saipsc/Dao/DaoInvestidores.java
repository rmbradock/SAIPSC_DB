/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saipsc.Dao;

import com.mycompany.saipsc.ferramentas.BancoDeDadosMySql;
import java.sql.ResultSet;

/**
 *
 * @author batista.4995
 */
public class DaoInvestidores extends BancoDeDadosMySql{
    
    String sql;
    
    public Boolean inserir (int id, int idPessoa,String obs, String investimento, String periodicidade){
        try{
            sql = "INSERT INTO INVESTIDORES (ID, ID_PESSOA, OBS, INVESTIMENTO, PERIODICIDADE) VALUES (?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idPessoa);
            getStatement().setString(3, obs);
            getStatement().setString(4, investimento);
            getStatement().setString(5, periodicidade);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar(int id, int idNovoPessoa, String novoObs, String novoInvestimento, String novoPeriodicidade){
        try{
            sql = "UPDATE INVESTIDORES SET ID_PESSOA = ?, OBS = ?, INVESTIMENTO = ?, PERIODICIDADE = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(5, id);
            getStatement().setInt(1, idNovoPessoa);
            getStatement().setString(2, novoObs);
            getStatement().setString(3, novoInvestimento);
            getStatement().setString(4, novoPeriodicidade);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM INVESTIDORES WHERE ID = ?";
            
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
            sql = 
                " SELECT                    " +
                "   INV.ID,                 " +
                "   PE.NOME AS NOME,        " +
                "   INV. OBS,               " +
                "   INV. IVESTIMENTO,       " +
                "   INV. PERIODICIDADE      " +
                "   FROM                    " +
                "   INVESTIDORES INV        " +
                "   JOIN PESSOA PE ON       " +
                "   PE.ID = INV.ID_PESSOA   " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorId(int id){
        try{
            sql =
                " SELECT                    " +
                "   INV.ID AS ID,           " +
                "   PE.NOME AS NOME,        " +
                "   INV. OBS,               " +
                "   INV. IVESTIMENTO,       " +
                "   INV. PERIODICIDADE      " +
                "   FROM                    " +
                "   INVESTIDORES INV        " +
                "   JOIN PESSOA PE ON       " +
                "   PE.ID = INV.ID_PESSOA   " +
                "   WHERE                   " +
                "   INV.ID = ?              ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorNome(String nome){
        try{
            sql = 
                "   SELECT                  " +
                "   INV.ID,                 " +
                "   PE.NOME AS NOME,        " +
                "   INV. OBS,               " +
                "   INV. IVESTIMENTO,       " +
                "   INV. PERIODICIDADE      " +
                "   FROM                    " +
                "   INVESTIDORES INV        " +
                "   JOIN PESSOA PE ON       " +
                "   PE.ID = INV.ID_PESSOA   " +
                "   WHERE                   " +
                "   PE.NOME LIKE ?         " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorObs(String obs){
        try{
            sql = 
                "   SELECT                  " +
                "   INV.ID,                 " +
                "   PE.NOME AS NOME,        " +
                "   INV. OBS,               " +
                "   INV. IVESTIMENTO,       " +
                "   INV. PERIODICIDADE      " +
                "   FROM                    " +
                "   INVESTIDORES INV        " +
                "   JOIN PESSOA PE ON       " +
                "   PE.ID = INV.ID_PESSOA   " +
                "   WHERE                   " +
                "   INV.OBS LIKE ?         " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, obs + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorInvestimento(String investimento){
        try{
            sql = 
                "   SELECT                  " +
                "   INV.ID,                 " +
                "   PE.NOME AS NOME,        " +
                "   INV. OBS,               " +
                "   INV. IVESTIMENTO,       " +
                "   INV. PERIODICIDADE      " +
                "   FROM                    " +
                "   INVESTIDORES INV        " +
                "   JOIN PESSOA PE ON       " +
                "   PE.ID = INV.ID_PESSOA   " +
                "   WHERE                   " +
                "   INV.INVESTIMENTO LIKE ?         " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, investimento + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public ResultSet listarPorPeriodicidade(String periodicidade){
        try{
            sql = 
                "   SELECT                  " +
                "   INV.ID,                 " +
                "   PE.NOME AS NOME,        " +
                "   INV. OBS,               " +
                "   INV. IVESTIMENTO,       " +
                "   INV. PERIODICIDADE      " +
                "   FROM                    " +
                "   INVESTIDORES INV        " +
                "   JOIN PESSOA PE ON       " +
                "   PE.ID = INV.ID_PESSOA   " +
                "   WHERE                   " +
                "   INV.PERIODICIDADE LIKE ?         " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, periodicidade + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM INVESTIDORES";
            
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

